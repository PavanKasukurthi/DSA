package Java.OOPS_Concepts;

public class OverridingScenario {
    public static void main(String[] args) {
        A a1 = new A();

        // For subclass reference, parent object cannot be created (incompatible types)
        // B b1 = new A(); //A cannot be converted to B

        A a2 = new B();
        B b2 = new B();

        int num1 = a1.sum(4, 5);

        int num2 = a2.sum(44, 5);
        int num3 = b2.sum(4, 34);

        // System.out.println(num1);
        // System.out.println(num2);
    }
}

class A {
    // default methods cannot be used inside class, it must only be used in
    // interfaces
    protected int sum(int a, int b) {
        System.out.println("Calling class A");
        return a + b;
    }
}

// If parent class is public, child class cannot be having less visibility

class B extends A {
    @Override
    public int sum(int a, int b) {
        System.out.println("Calling class B");
        return a + b;
    }
}