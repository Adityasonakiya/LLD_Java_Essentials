package LLD_Java_Essentials.Riddhi_Dutta_Java_Multithreading.Synchronization;

class ThreadSafeStack {
    private int a[];
    private int top;
    Object lock;

    public ThreadSafeStack(int cap) {
        a = new int[cap];
        top = -1;
        lock = new Object();
    }

    boolean isFull() {
        return (top == a.length - 1);
    }

    boolean isEmpty(){
        return top == -1;
    }

    // boolean add(int ele){
    //     // In Java, ANY OBJECT INSTANCE can be used as a lock
    //     // So, synchronized(new String("ss")) is valid
    //     // What if you're inside a static fn? Use synchronized(ClassName.class) 
    //     synchronized(lock) {
    //        ...
    //     }
    // }

    // int remove(){
    //     synchronized(lock) {
    //      ...
    //     }
    // }

    synchronized boolean add(int ele){
        // In background, java basically wraps everything in sychronized(this)
        // i.e. current class instance is used as lock!! 
        // So now, for all synchronized methods in the class, they have same lock
        // which means, if multiple threads are calling multiple methods of this class instance, 
        // only 1 thread can execute all synchronized methods at a time.

        // Note - Since internally, static methods use ClassName.class as lock and non-static methods use this,
        // so, due to seperate locks, threads can enter static and non-static methods at the same time.
        if(isFull()) {
            System.out.println("Can't add; Stack full");
            return false;
        }
        top = top + 1;
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception during simulateSleep(): "+e);
        }
        a[top] = ele;
        return true;
    }

    synchronized int remove(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return Integer.MIN_VALUE;
        }
        int val = a[top];
        a[top] = Integer.MIN_VALUE;
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Exception during simulateSleep(): "+e);
        }
        top = top -1;
        return val;
    }
}



public class solution {
    public static void main(String[] args) {
        System.out.println("Main is starting...");
        ThreadSafeStack st = new ThreadSafeStack(5);
        new Thread(() -> {
            for(int i = 99; i < 110; i++) {
                boolean isInserted = st.add(i);
                System.out.println(Thread.currentThread().getName() + " insertion of "+i+" | isInserted = "+isInserted);
            }
        }, "insertionThread").start();


        new Thread(() -> {
            for(int i = 99; i < 110; i++) {
                int removedVal = st.remove();
                System.out.println(Thread.currentThread().getName() + " removed value "+removedVal);
            }
        }, "removalThread").start();

        System.out.println("Main is exiting...");


    }
}
