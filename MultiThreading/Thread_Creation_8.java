// This file demonstrates three different ways to create threads in Java:
// by extending the Thread class, by implementing the Runnable interface, and by using lambda expressions. 
// Each method has its own advantages and use cases, and this example shows how to use each of them effectively.

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("M1 - Creating Thread by extending Thread class");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }    
}

class Vehicle{
    Vehicle(){
        System.out.println("Vehicle Constructor Called");
    }
    public void start(){
        System.out.println("Vehicle is starting...");
    }
}

class MyRunnable extends Vehicle implements Runnable{ // this is prefferred over extending thread class because we can extend other class as well
    MyRunnable(){
        super(); // Call Vehicle constructor
        System.out.println("MyRunnable Constructor Called");
    }

    @Override
    public void run(){
        System.out.println("M2 - Creating Thread by Implementing through runnable interface");
        try{
            Thread.sleep(200);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class Thread_Creation_8 {
    public static void main(String[] args){
        MyThread t1 = new MyThread();

        MyRunnable task = new MyRunnable();
        Thread t2 = new Thread(task);

        Thread t3 = new Thread(()->{
            System.out.println("M3 - Creating Thread by using Lambda");
            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
