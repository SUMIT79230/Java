// Notes ::
// Thread class is a built-in class in Java that provides a way to create and manage threads. To create a thread, we can extend the Thread class and override the run() method. The run() method contains the code that will be executed when the thread is started.
// MyRunnable class implements the Runnable interface, which is another way to create a thread in Java. By implementing the Runnable interface, we can define the run() method in a separate class and then also pass an instance of that class to a Thread object to start the thread. This approach is useful when we want to extend another class, as Java does not support multiple inheritance. By implementing Runnable, we can still create a thread while extending another class.

class Vehicle{
    String vName;
    public Vehicle(String vName){
        this.vName = vName;
    }
    public void display(){
        System.out.println("Vehicle is " + vName);
    }
}

// Note - multiple inheritance is not supported in Java, but we can achieve it using interfaces. In this example, we have a Vehicle class and a MyThread class that extends the Thread class.
class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread is running...");
    }
}

class MyRunnable extends Vehicle implements Runnable{
    public MyRunnable(String vName){
        super(vName); // calling the constructor of the Vehicle class to initialize the vName variable
    }
    @Override
    public void run(){
        System.out.println("Runnable thread is running...");
        display(); // calling the display method of the Vehicle class to print the vehicle name
    }
}


public class BasicThread2 {
    public static void main(String[] args){
        MyThread t1  =  new MyThread();
        t1.start();

        MyRunnable r1  = new MyRunnable("Honda");
        Thread t2 = new Thread(r1);
        t2.start();
    }
}
