> For previous elements please refer to the README.md file in the LinkedDict repository: https://github.com/lantzmarlene/LinkedDict/blob/master/README.md

### 3.0) Testing

#### 3.1) Verification Testing --

To test the code, two methods were created within the main class, one of which called test and the other of which to obtain user input. I will explain each of them below.

##### 3.1.1) UserInput Method:
    public static String userInput(String args) throws IOException {
        if(args.equals("-1")){
            test();
        }
        else if(args.equals(tree.containsString(args))){
            System.out.println(args);
        }
        return args;
    }

Here is the method to test if the file contains a certain word that the user asks the system. If they type in "-1" then the test method is called. 

##### 3.1.2) Test Method:

    public static void test() throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader("Resources\\sorteddict.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("Resources\\sorteddictTest.txt"));
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        boolean areEqual = true;
        int lineNum = 1;
        while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
                areEqual = false;
                break;
            }
            else if(! line1.equalsIgnoreCase(line2))
            {
                areEqual = false;
                break;
            }
            line1 = reader1.readLine();
            line2 = reader2.readLine();
            lineNum++;
        }
        if(areEqual)
        {
            System.out.println("Two files have same content.");
        }
        else
        {
            System.out.println("Two files have different content. They differ at line "+lineNum);
            System.out.println("File1 has "+line1+" and File2 has "+line2+" at line "+lineNum);
        }
        reader1.close();
        reader2.close();
    }

This test method checks to see if the sorteddict file is the same to a sorteddictTest file. In the sorteddict test file, I went in an changed a bunch of things by deleting elements or changing the element entirely. Essentially, it will tell me at which line the files starts to differ so you can tell the files are not the same.

#### 3.2) Performance Testing --

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
        
        
        double average = Math.round((timeElapsedReadFile+timeElapsedLinkedDictionaryCreator+timeElapsedInOrder)/3);

        System.out.println("Average execution time per task: " + (average)/1000+ " seconds");
     }
    }

Here we make a performance test to determine how long each task takes to execute. In this case, as it is done with the BinaryTree method, the execution time is very fast and there were no bottlenecks found. We additionally found out how long each method takes as well as compute the average time each method takes to execute. You can tell this works as the total time it takes to execute it equal to all the separate parts added up together. 
