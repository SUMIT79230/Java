// Threads in Java can be created by extending the Thread class or by implementing the Runnable interface. In this example, we will see both approaches.
// The MyThread class extends the Thread class and overrides the run() method to print a message to the console. The MyRunnable class implements the Runnable interface and also overrides the run() method to print a message to the console. In the main method, we create an instance of MyThread and start it, which will call the run() method of the MyThread class. We also create an instance of MyRunnable and pass it to a new Thread object, which we then start, calling the run() method of the MyRunnable class.
// Thread Keypoints:
// 1. A thread is a lightweight process that can run concurrently with other threads in the same program.
// 2. Threads can be created by extending the Thread class or by implementing the Runnable interface.
// 3. The run() method is the entry point for a thread and contains the code that will be executed when the thread is started.
// 4. The start() method is used to start a thread, which will call the run() method of the thread class. It is important to note that calling the run() method directly will not start a new thread, but will instead execute the run() method in the current thread.
// 5. Threads can be used to perform tasks concurrently, which can improve the performance of a program by allowing multiple tasks to be executed at the same time. However, it is important to manage threads properly to avoid issues such

// Runnable interface is preferable when you want to extend another class as Java does not support multiple inheritance. By implementing Runnable, you can still create a thread while extending another class. Additionally, using Runnable allows for better separation of concerns, as the task to be performed by the thread is defined in a separate class, making the code more modular and easier to maintain.


class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println("Thread is running...");
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run(){
        System.out.println("Runnable thread is running...");
    }
}

public class BasicThread {
    public static void main(String[] args){

        MyThread t1 = new MyThread();
        t1.start(); // This will start the thread and call the run() method of the Thread class, which does nothing by default.
        
        MyRunnable r1 = new MyRunnable();
        Thread t2 = new Thread(r1);
        t2.start(); // This will start the thread and call the run() method of the MyRunnable class, which prints a message to the console.
    }
}
