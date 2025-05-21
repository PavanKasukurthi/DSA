package Java.classes;

/*Method hiding in Java occurs when a subclass defines a static method with the same signature(name and parameters)as a 
static method in its superclass. In this case,the method in the subclass hides the method in the superclass.
The version of the method that gets executed is determined by the reference type of the object,
not the actual object type at runtime.This is different from method overriding,where the version of the method executed 
is determined by the object type at runtime. */

public class MethodHiding {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dogAnimal = new Dog();
        Dog dog = new Dog();

        animal.makeSound(); // Output: Generic animal sound
        dogAnimal.makeSound(); // Output: Generic animal sound (method hiding)
        dog.makeSound(); // Output: Woof!
    }
}

class Animal {
    static void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Dog extends Animal {
    static void makeSound() {
        System.out.println("Woof!");
    }
}
