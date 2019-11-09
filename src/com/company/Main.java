package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static Scanner scan;
    private static BinaryTree tree;
    private static LinkedList<String> linkedList;
    private static PrintWriter writer;

    public static void readFile() throws FileNotFoundException {
        File file = new File("Resources\\unsorteddict.txt");
        scan = new Scanner(file);
    }

    public static void linkedDictionaryCreatorInputer() throws FileNotFoundException, UnsupportedEncodingException {
        //Creation of linked list and line variable
        String fileContents = "";
        linkedList = new LinkedList<>();
        tree = new BinaryTree();

        while(scan.hasNextLine()) {
            fileContents = scan.nextLine();
            if (linkedList.size() == 0) {
                linkedList.add(0, fileContents);
            } else {
                for (int i = 0; i < linkedList.size(); i++) {
                    tree.insert(fileContents);
                }
            }
        }
    }
    public static void inOrder() throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter("Resources\\sorteddict.txt", "UTF-8");
        tree.inorderTraversal(writer); //Calls method and writes to a file
    }


    public static void userInput(String[] arguments, BinaryTree tree){
        if (arguments.length > 10){
            System.out.println("You may not enter more than 10 arguments at a time.");
        }
        else{

        }
    }

    public static void main(String ... args) throws IOException {
        double startTime = System.currentTimeMillis();

        double readFileStartTime = System.currentTimeMillis();
        readFile();
        double readFileEndTime = System.currentTimeMillis();
        double storeContentsStartTime = System.currentTimeMillis();
        linkedDictionaryCreatorInputer();
        double storeContentsEndTime = System.currentTimeMillis();
        double putInOrderAndOutputStartTime = System.currentTimeMillis();
        inOrder();
        double putInOrderAndOutputEndTime = System.currentTimeMillis();

        double endTime = System.currentTimeMillis();

        double timeElapsed = endTime - startTime;
        double timeElapsedReadFile = readFileEndTime - readFileStartTime;
        double timeElapsedLinkedDictionaryCreator = storeContentsEndTime - storeContentsStartTime;
        double timeElapsedInOrder = putInOrderAndOutputEndTime - putInOrderAndOutputStartTime;

        System.out.println("Full Programme execution time: " + timeElapsed/1000+ " seconds");
        System.out.println("Read File Method execution time: " + timeElapsedReadFile/1000+ " seconds");
        System.out.println("Store Contents from File to put In Order execution time: " + timeElapsedLinkedDictionaryCreator/1000+ " seconds");
        System.out.println("Put In Order Method and Output to File execution time: " + timeElapsedInOrder/1000+ " seconds");



    }
}
