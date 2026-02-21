// Keypoints of SubType_4.java:
// 1. We can use wildcard with extends to create a list of a specific type and its subtypes, but we cannot add any object to the list because we don't know the exact type of the list, it can be a list of Developer_Team or a list of Testing_Team, so we cannot add any object to the list because it can lead to runtime errors due to type mismatches.
// 2. We can iterate over the list and access the common properties of the Employee class, but we cannot access the specific properties of the Developer_Team or Testing_Team class because we don't know the exact type of the list.
import java.util.*;

class Employee{
    private String name;
    
    Employee(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
};

class Testing_Team extends Employee{
    Testing_Team(String name){
        super(name);
    }
}

class Developer_Team extends Employee{
    Developer_Team(String name){
        super(name);
    }
}

public class SubType_4 {
    public static void main(String[] args) {
        ArrayList<Developer_Team> d = new ArrayList<>();
            d.add(  new Developer_Team("Developer Team 1") );
            d.add(  new Developer_Team("Developer Team 2") );
            d.add(  new Developer_Team("Developer Team 3") );
        ArrayList<? extends Employee> e = d; // We can use wildcard with extends to create a list of a specific type and its subtypes, but we cannot add any object to the list because we don't know the exact type of the list, it can be a list of Developer_Team or a list of Testing_Team, so we cannot add any object to the list because it can lead to runtime errors due to type mismatches.
            // e.add(  new Developer_Team("Developer Team 4") );
            // e.add(  new Testing_Team("Testing Team 4") ); 
            // We cannot add any object to the list e because we don't know the exact type of the list e, it can be a list of Developer_Team or a list of Testing_Team, so we cannot add any object to the list e because it can lead to runtime errors due to type mismatches.
        
            for(Employee emp : e){
            System.out.println(emp.getName());
        }
    }
}
