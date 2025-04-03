package Java.MultiThreading;

public class DeadlockExample {
    static final Object resource1 = new Object();
    static final Object resource2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread #1 - Locked resource1");
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("Thread1: Waiting for resource2");

            synchronized (resource2) {
                System.out.println("Thread1: Locked resource2");
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread #2 - Locked resource1");
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println("Thread2: Waiting for resource1");

            synchronized (resource1) {
                System.out.println("Thread2: Locked resource1");
            }
        });

        thread1.start();
        thread2.start();
    }
}
