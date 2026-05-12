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

    boolean add(int ele){
        // In Java, ANY OBJECT can be used as a lock
        // So, synchronized(new String("ss")) is valid
        synchronized(lock) {
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
    }

    int remove(){
        synchronized(lock) {
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
