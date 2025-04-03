package Java.MultiThreading;

public class MyThread extends Thread {
    public static void main(String[] args) {

    }

    @Override
    public void run() {
        if (this.isDaemon()) {
            System.out.println("This is a Deamon thread is running");
        } else {
            System.out.println("This is a user thread that is runnning");
        }
    }
}
