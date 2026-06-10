package LLD_Java_Essentials.Riddhi_Dutta_Java_Multithreading.ThreadCreation;

public class ThreadCreationDemo {
    public static void main(String[] args) {
        System.out.println("main is starting...");

        // Thread t1 = new ThreadViaThreadClass("custom-name-ThreadViaThreadClass");
        // to mark a thread as a daemon thread (no independent existence; dies when all user threads die)
        // has to be done before start()
        // t1.setDaemon(true);
        // t1.start();

        //Preferably, as now this runnable class can implement other classes/interfaces as well, but if I make a thread
        // by extending the Thread class, that class can't extend any other class
        Thread t2 = new Thread(new ThreadViaRunnableInterface(), "custom-name-ThreadViaRunnableInterface");
        t2.start();
        //no need to call the run method explicitly, JVM will take care of it, just need to call the start method to execute the thread.
        // t2.run();
        
        // this can be done via lambda as well
        Thread t3 = new Thread(() -> {
            for(int i = 0; i < 5; i++) {
                System.out.println("Inside Lambda Runable run() "+ i);
            }
        }, "custom-name-ThreadViaRunnableLambda");
        t3.start();
        

        System.out.println("main is exiting...");
    }
}
