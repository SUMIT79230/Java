// Without Generic, we can use Object type to store any type of data, but it can lead to runtime errors due to type mismatches.
// Keypoints:
// 1. We can use Object type to store any type of data, but it can lead to runtime errors due to type mismatches.
// 2. We need to use type casting to retrieve the data from Object type, which can also lead to runtime errors if the type casting is not done correctly.

class Employee{
   private Object name;
   private Object age;
   
   public Employee(Object name, Object age){
    this.name  = name;
    this.age = age;
   }

   public Object getName(){
    return name;
   }

   public Object getAge(){
    return age;
   }

   public void setName(Object name){
    this.name = name;
   }

   public void setAge(Object age){
    this.age = age;
   }
};


public class Without_generic_1 {
    public static void main(String[] args){

        Employee e1 = new Employee("Sumit",24);
        String myName = (String) e1.getName(); // Type casting 
        int myAge = (int) e1.getAge(); // Type casting 
        System.out.println("Employee name is "+myName+" having age "+ myAge);

        e1.setName(16); //  Type mismatch, but it will compile successfully because we are using Object type for name and age in Employee class. 
                             //  This is one of the drawbacks of not using generics, as it can lead to runtime errors due to type mismatches.

        String name = (String) e1.getName(); // This will throw a ClassCastException at runtime because we are trying to cast an Integer (16) to a String, which is not possible.
        System.out.println("Employee name is "+ name + " having age "+ myAge);

    }
}
