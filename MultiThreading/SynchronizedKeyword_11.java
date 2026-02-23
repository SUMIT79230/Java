// This Files demonstrates the use of the synchronized keyword in Java to prevent race conditions when multiple threads access shared resources.
// In this example, we have a shared resource (B_Account) that is accessed by multiple threads (t1, t2, and t3). 
// By using the synchronized keyword on the methods that modify and access the shared resource, we ensure that only one thread can access the critical section of code at a time, thus preventing race conditions and ensuring thread safety.
// Keypoints to be noted here are:
// 1. The synchronized keyword can be applied to methods or blocks of code to control access to shared resources.
// 2. When a thread enters a synchronized method or block, it acquires the lock for that resource, and other threads that try to access the same resource will be blocked until the lock is released.

class B_Account{
    private int amount = 1000;
    // private static int amount = 1000; // with static, shared across all instances of B_Account

    public  synchronized void addAmmount(int amt){ // with synchronized
        amount = amount + amt;
    }

    public synchronized int getAmount(){ // with synchronized
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
        try{
            b.addAmmount(300);
            System.out.println("Amounts Balance checked by T1 Thread : "+ b.getAmount());
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class SynchronizedKeyword_11 {
     public static void main(String[] args) throws InterruptedException {

        B_Account sharedResources1 = new B_Account();
        B_Account sharedResources2 = new B_Account();

        Thread t1 = new Thread(new MyRunnable(sharedResources1));

        Thread t2 = new Thread(()->{
            try{
                Thread.sleep(500);  // Let T1 print first
                sharedResources1.addAmmount(500);
                System.out.println("Amounts Balance checked by T2 Thread : "+ sharedResources1.getAmount());
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(()->{
            try{                
                sharedResources2.addAmmount(1000);
                System.out.println("Amounts Balance checked by T3 Thread : "+ sharedResources2.getAmount());
                Thread.sleep(2000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        
        t1.join();
        t2.join();
        t3.join();
    }
}
