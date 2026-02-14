// In this example, we have a BankAccount class that represents a bank account with a balance. The withdraw method is synchronized, which means that only one thread can access it at a time. This ensures that the balance is updated correctly and prevents race conditions when multiple threads try to withdraw money from the same account simultaneously. 
// The MyRunnable class implements the Runnable interface and takes a BankAccount object and an amount to withdraw as parameters. In the main method, we create a BankAccount object and two threads that attempt to withdraw money from the account. The output will show the result of each withdrawal attempt, demonstrating how synchronization ensures thread safety when accessing shared resources.

// Points to remember:
// 1. Synchronization is used to control access to shared resources in a multi-threaded environment.
// 2. The synchronized keyword can be applied to methods or blocks of code to ensure that only one thread can access the synchronized code at a time.
// 3. When a thread is executing a synchronized method or block, other threads that try to access the same synchronized code will be blocked until the first thread finishes executing it.
// 4. Synchronization can help prevent race conditions and ensure that shared resources are accessed in a thread-safe manner, but it can also lead to performance issues if not used carefully, as it can cause threads to be blocked for extended periods of time.

class BankAccount{
    private int balance = 1000;

    public synchronized void withdraw(int amount){
        if(balance >= amount){
            balance = balance - amount;
            System.out.println("Wihdrawing " + amount + " from account by "+ Thread.currentThread().getName()+". Current balance: " + balance);
        }
        else{
            System.out.println("Insufficient balance for " + Thread.currentThread().getName() + ". Current balance: " + balance);
        }
    }
}

class MyRunnable implements Runnable{
    BankAccount B_account;
    private int amount;

    public MyRunnable(BankAccount account,int amount){
        this.B_account = account;
        this.amount = amount;
    }

    @Override
    public void run(){
        B_account.withdraw(amount);
    }
}

public class SynchronizedMultiThreading {

    public static void main(String[] args){
        BankAccount account = new BankAccount(); // shared resource

        Thread r1 = new Thread(()-> account.withdraw(500),"Thread - 1"); // use lambda expression to create a thread that calls the withdraw method of the BankAccount class with an amount of 500
        Thread r2 = new Thread(new MyRunnable(account,200),"Thread - 2");

        r1.start();
        r2.start();
    } 
}
