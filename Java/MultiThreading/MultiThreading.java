package Java.MultiThreading;

public class MultiThreading {

    public static void main(String[] args) throws InterruptedException {

        CustomThread thread1 = new CustomThread();

        MyRunnable runnable1 = new MyRunnable();
        Thread thread2 = new Thread(runnable1);

        thread1.start();
        thread1.join(); // CALLING THREAD WAITS UNTIL THE SPECIFIED THREAD DIES OR FOR X MILLISECONDS
        thread2.start();
    }

}
