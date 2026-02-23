// This Files demonstrates a race condition in Java. A race condition occurs when two or more threads access shared resources concurrently, and the outcome of the execution depends on the timing of the threads' execution. 
// In this example, we have a shared resource (B_Account) that is accessed by two threads (t1 and t2) without proper synchronization, leading to unpredictable results. 
// The final balance may not reflect all the updates made by both threads, demonstrating the race condition.
// Keypoints to be noted here are:
// 1. Both threads are modifying the shared resource (B_Account) without any synchronization mechanism, which can lead to inconsistent state of the shared resource.
// 2. The output of the program may vary between runs due to the non-deterministic nature of thread scheduling, which is a hallmark of race conditions.
// To avoid race conditions, we can use synchronization mechanisms such as synchronized blocks, locks, or atomic variables to ensure that only one thread can access the shared resource at a time.

class B_Account{
    private int amount = 1000;

    public void addAmmount(int amt){
        amount = amount + amt;
    }

    public int getAmount(){
        return amount;
    }
};

class MyRunnable implements Runnable {
    B_Account b;

    public MyRunnable(B_Account b) {
        this.b = b;
    }

    @Override
    public void run(){
        b.addAmmount(200);
        System.out.println("Amounts Balance checked by T1 Thread : "+ b.getAmount());
    }
}


public class RaceCondition_10{
    public static void main(String[] args) throws InterruptedException {

        B_Account sharedResources = new B_Account();
        Thread t1 = new Thread(new MyRunnable(sharedResources));

        Thread t2 = new Thread(()->{
            sharedResources.addAmmount(500);
            System.out.println("Amounts Balance checked by T2 Thread : "+ sharedResources.getAmount());
        });

        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        System.out.println("Amounts Balance checked by main Thread  : "+ sharedResources.getAmount());
    }
}