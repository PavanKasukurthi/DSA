package Java.MultiThreading;

public class DeadlockExample {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        MyRunnable1 runnable1 = new MyRunnable1();
        Thread T1 = new Thread(runnable1);

        MyRunnable2 runnable2 = new MyRunnable2();
        Thread T2 = new Thread(runnable2);

        T1.start();
        T2.start();
    }

    private static class MyRunnable1 implements Runnable {
        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread #1 - Holding lock1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Waiting for lock2");
                synchronized (lock2) {
                    System.out.println("Holding lock1 and lock2");
                }
            }
        }
    }

    private static class MyRunnable2 implements Runnable {
        @Override
        public void run() {
            synchronized (lock2) {

                System.out.println("Thread #2 - Holding lock2");

                try

                {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Waiting for lock1");

                synchronized (lock1) {
                    System.out.println("Holding lock2 and lock1");
                }
            }

        }
    }
}
