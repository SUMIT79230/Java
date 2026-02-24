// This file demonstrates how to use BufferedReader in Java to read input from the console.
// BufferedReader is a class in the java.io package that allows for efficient reading of characters,
// arrays, and lines. In this example, we use BufferedReader to read a string input (name), two integer inputs (num1 and num2), and an array of integers from the user.

// Keypoints to be noted here are:
// 1. We create a BufferedReader object by wrapping it around an InputStreamReader, which reads bytes and decodes them into characters.
// 2. We use the readLine() method to read a line of text from the console, and we can parse it into the desired data type (e.g., Integer.parseInt() for integers).
// 3. Finally, we close the BufferedReader to free up system resources.
// Note: When using BufferedReader, it's important to handle IOException, which can occur during input/output operations.
// Also, remember to close the BufferedReader after use to prevent resource leaks.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferReader_2 {
    public static void main(String[] args) throws IOException {
        
        String FILE_PATH = "C:/Users/sumit/Desktop/Java/JavaBasic/input.txt";
        BufferedReader fileReader = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        while((line = fileReader.readLine()) != null){
            System.out.println(line);
        }
        fileReader.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your name : ");
        String name = reader.readLine();
        System.out.printf("You have enter %s\n", name);

        System.out.println("Enter first number : ");
        int num1 = Integer.parseInt(reader.readLine());

        System.out.println("Enter second number : ");
        int num2 = Integer.parseInt(reader.readLine());

        System.out.printf("Input Number is %d and %d \n", num1, num2);

        System.out.println("Enter number of element in an Array");
        int n  = Integer.parseInt(reader.readLine());

        int[] numArray = new int[n];
        for(int i = 0; i<n; i++){
            numArray[i] = Integer.parseInt(reader.readLine());
        }

        System.out.print("Array : ");
        for(int element : numArray){
            System.out.printf("%d ", element);
        }

        reader.close();

    }
}
