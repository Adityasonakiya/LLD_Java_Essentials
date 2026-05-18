package LLD_Java_Essentials.Riddhi_Dutta_Java_Multithreading.ProducerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

class BlockingQueue {
    private Queue<Integer> q;
    private int capacity;

    BlockingQueue(int cap) {
        q = new LinkedList<>();
        capacity = cap;
    }

    boolean isFull(){
        return (q.size() == capacity);
    }

    boolean isEmpty() {
        return q.isEmpty();
    }

    public boolean addItem(int item) {
        synchronized(q) {
            while(isFull()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting...");
                    q.wait();
                } catch (Exception e) {
                    System.out.println("Exception: "+e);
                }
            }
            q.offer(item);
            q.notifyAll();
            return true;
        }
    }

    
    public int removeItem() {
        synchronized(q) {
            while(isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " waiting...");
                    q.wait();
                } catch (InterruptedException e) {
                    System.out.println("Exception: "+e);
                }
            }
            int val = q.poll();
            q.notifyAll();
            return val;
        }
    }
}

public class demo {
    public static void main(String[] args) {
        BlockingQueue bq = new BlockingQueue(2);
        Thread pth1 = new Thread(() -> {
            bq.addItem(20);
            System.out.println(Thread.currentThread().getName()+ " added 20 to queue");
        }, "Producer Thread 1");

        Thread pth2 = new Thread(() -> {
            bq.addItem(10);
            System.out.println(Thread.currentThread().getName()+ " added 10 to queue");
        }, "Producer Thread 2");

        Thread csm1 = new Thread(() -> {
            int val = bq.removeItem();
            System.out.println(Thread.currentThread().getName()+ " removed "+ val + " from queue");
        }, "Consumer Thread 1");

        Thread csm2 = new Thread(() -> {
            int val = bq.removeItem();
            System.out.println(Thread.currentThread().getName()+ " removed "+ val + " from queue");
        }, "Consumer Thread 2");

        csm1.start();
        csm2.start();
        pth1.start();
        pth2.start();
    }
}
