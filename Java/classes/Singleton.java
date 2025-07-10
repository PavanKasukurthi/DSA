package Java.classes;

public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
        System.out.println("Singleton instance created");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    public void doSomething() {
        System.out.println("Singleton is doing something");
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

        singleton.doSomething();
    }
}

class SingletonThreadSafe {
    private static volatile SingletonThreadSafe instance = null;

    private SingletonThreadSafe() {
        System.out.println("Thread safe Singleton is created");
    }

    public static SingletonThreadSafe getInstance() {
        synchronized (SingletonThreadSafe.class) {
            if (instance == null) {
                instance = new SingletonThreadSafe();
            }
        }

        return instance;
    }
}