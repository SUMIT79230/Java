// This file demonstrates the use of generics in Java to create a type-safe Employee class that can store any type of data for name and age without the need for type casting, thus avoiding runtime errors due to type mismatches.
// Keypoints:
// 1. We can use generics to create a type-safe Employee class that can store any type of data for name and age without the need for type casting, thus avoiding runtime errors due to type mismatches.
// 2. We can specify the type of name and age while creating the object of Employee class, and we can use the getName() and getAge() methods to retrieve the data without the need for type casting.


import java.util.ArrayList;

class Employee<T, U>{
    private T name;
    private U age;

    Employee(T name, U age){
        this.name = name;
        this.age = age;
    }

    public T getName(){
        return this.name;
    }

    public U getAge(){
        return this.age;
    }

    public void setName(T name){
        this.name = name;
    }

    public void setAge(U age){
        this.age = age;
    }

};

public class With_Generic_2 {
    public static void main(String[] args){
        // Employee<String, Integer> e1 =  new Employee<String, Integer>("Sumit", 24);
        // String name = e1.getName(); // No need of type casting because we are using generics and we have specified the type of name as String and age as Integer while creating the object of Employee class.
        // int age = e1.getAge(); // No need of type casting because we are using

        ArrayList<Employee<String, Integer>> employees = new ArrayList<>();
        employees.add( new Employee<String,Integer>("Sumit", 24) );
        employees.add( new Employee<String,Integer>("Rahul", 25) );

        for(Employee<String, Integer> e : employees){
            System.out.println("Name: "+ e.getName() +" Age: "+ e.getAge() );
        }
    }
}