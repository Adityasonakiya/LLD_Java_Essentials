package LLD_Java_Essentials.Riddhi_Dutta_Java_Multithreading.ThreadCreation;

public class ThreadCreationDemo {
    public static void main(String[] args) {
        System.out.println("main is starting...");

        // Thread t1 = new ThreadViaThreadClass("custom-name-ThreadViaThreadClass");
        // to mark a thread as daemon thread (no independent existence; dies when all user threads die)
        // has to be done before start()
        // t1.setDaemon(true);
        // t1.start();

        // Preferrable, as now this runnable class can implement other classes/interfaces as well, but if I make a thread
        // by extending Thread class, that class can't extend any other class
        Thread t2 = new Thread(new ThreadViaRunnableInterface(), "custom-name-ThreadViaRunnableInterface");
        t2.run();

        System.out.println("main is exiting...");
    }
}
