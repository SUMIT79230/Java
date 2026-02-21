// Covariance in Java allows us to assign a reference of a subclass type to a reference of a superclass type. 
// This is possible because the subclass is a specialized version of the superclass, and it can be treated as an instance of the superclass.

import java.util.*;
public class Covariance_3 {
    public static void main(String[] args) {
        // covariance with arrays
        String[] stringArray = {"Hello", "World"};
        Object[] objectArray ;
        objectArray = stringArray; // Covariance allows this assignment 
        for(Object obj : objectArray) {
            System.out.println(obj);
        }
        System.out.println("Valid or not : " + stringArray == objectArray + "");

        // However, covariance with arrays can lead to runtime exceptions if we try to assign an incompatible type
        try {
            objectArray[0] = 42; // This will throw an ArrayStoreException at runtime because we are trying to store an Integer in an array of Strings.
        } catch (ArrayStoreException e) {
            System.out.println("Caught ArrayStoreException: " + e.getMessage());
        }

        // covariance with collection
        List<String> stringList = new ArrayList<>();
        stringList.add("Sumit");
        stringList.add("Rahul");
        List<Object> objectList = new ArrayList<>();
        // objectList = stringList // collection doesn't suppport covariance 

    }
}
