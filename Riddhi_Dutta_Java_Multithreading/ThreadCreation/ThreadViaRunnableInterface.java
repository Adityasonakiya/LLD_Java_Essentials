package LLD_Java_Essentials.Riddhi_Dutta_Java_Multithreading.ThreadCreation;

public class ThreadViaRunnableInterface implements Runnable {

    @Override
    public void run() {
        System.out.println("\nCurrent Thread Id, Thread Name, Thread Priority, Parent Thread name");
        System.out.println(Thread.currentThread());
        for (int i = 0; i < 5; i++) {
            System.out.println("Inside thread via Runnable interface "+ i);
        }
    }
    
}
