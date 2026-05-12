package LLD_Java_Essentials.Riddhi_Dutta_Java_Multithreading.ThreadCreation;

public class ThreadViaThreadClass extends Thread {

    public ThreadViaThreadClass(String name) {
        super(name);
    }

    @Override
    public void run(){
        System.out.println("\nCurrent Thread Id, Thread Name, Thread Priority, Parent Thread name");
        System.out.println(Thread.currentThread());
        for (int i = 0; i < 5; i++) {
            System.out.println("\nInside ThreadViaThreadClass.run() " + i);
        }
    }
    
}
