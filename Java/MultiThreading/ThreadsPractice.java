package Java.MultiThreading;

public class ThreadsPractice {
    public static void main(String[] args) throws InterruptedException {
        // ACTIVE THREADS COUNT
        System.out.println(Thread.activeCount());

        // NAME OF THE THREAD
        System.out.println(Thread.currentThread().getName());

        // CHANGING THE NAME OF THE THREAD
        Thread.currentThread().setName("Custom Thread");
        System.out.println(Thread.currentThread().getName());

        // PRIORITY OF THE THREAD 1 - 10
        // System.out.println(Thread.currentThread().getPriority());

        // CHANGING THE PRIORITY OF THE THREAD
        // Thread.currentThread().setPriority(3);
        // System.out.println(Thread.currentThread().getPriority());

        // TO CHECK IF THE THREAD IS ALIVE OR NOT
        System.out.println(Thread.currentThread().isAlive());

        // for (int i = 3; i > 0; i--) {
        // System.out.println(i);
        // Thread.sleep(1000);
        // }

        // System.out.println("You are done!");

        MyThread thread2 = new MyThread();

        thread2.setDaemon(true);
        System.out.println(thread2.isDaemon());

        thread2.start(); // else thread2.isAlive() will return false
        System.out.println(thread2.isAlive());

        System.out.println(thread2.getName());

        thread2.setName("Second Thread using extends");
        System.out.println(thread2.getName());

        thread2.setPriority(7);
        System.out.println(thread2.getPriority());
    }
}
