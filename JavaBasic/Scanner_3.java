// This file demonstrates the use of the Scanner class in Java to read input from both a file and the console.
// The Scanner class is part of the java.util package and provides methods for parsing primitive types and strings using regular expressions. In this example, we first read lines from a file specified by FILE_PATH and then read user input from the console.

// Keypoints to be noted here are:
// 1. We create a Scanner object for reading from a file by passing a FileReader object to the Scanner constructor.
// 2. We use the hasNextLine() method to check if there are more lines to read from the file, and the nextLine() method to read each line.
// 3. For reading from the console, we create a Scanner object without any arguments, which defaults to reading from System.in. We then use methods like next(), nextInt(), and nextLine() to read different types of input from the user.
// 4. Finally, we close the Scanner objects to free up system resources.

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Scanner_3{
    public static void main(String[] args) throws IOException {

        String FILE_PATH = "C:/Users/sumit/Desktop/Java/JavaBasic/input.txt";
        Scanner fileReader = new Scanner(new FileReader(FILE_PATH));
        while(fileReader.hasNextLine()){
            String line = fileReader.nextLine();
            System.out.println(line);
        }
        fileReader.close();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name : ");
        String name = sc.next();
        System.out.printf("You have enter %s\n", name);

        System.out.println("Enter first number : ");
        int num1 = sc.nextInt();

        System.out.println("Enter second number : ");
        int num2 = sc.nextInt();

        System.out.printf("Input Number is %d and %d \n", num1, num2);

        System.out.println("Enter number of element in an Array");
        int n  = sc.nextInt();

        int[] numArray = new int[n];
        for(int i = 0; i<n; i++){
            numArray[i] = sc.nextInt();
        }

        System.out.print("Array : ");
        for(int element : numArray){
            System.out.printf("%d ", element);
        }

        sc.close();

    }
}
