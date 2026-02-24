// This file demonstrates the use of different print methods in Java to display output on the console.
// The System.out.print() method prints the given input and keeps the cursor on the same line, while System.out.println() prints the given input and moves the cursor to the next line.
// The System.out.printf() method allows for formatted output, where you can specify the format of the output using format specifiers. In this example, we use %s for strings and %d for integers to format the output in a specific way.

public class input_1 {
    public static void main(String[] args){
        System.out.print("Sumit - print given input and cursor is in same line");
        System.out.println("Kumar - print given input and cursor is in next line");
        System.out.printf("Employee : %s scored %d out %d ","Sumit",50,50);
    }
}
