// File: Inheritance05.java
// Topic: Basic Inheritance (IS-A relationship)

/*
------------------------------------------------------------
📌 WHAT YOU WILL LEARN
------------------------------------------------------------
1. Inheritance = acquiring properties of one class into another.
2. Parent (super) class and child (sub) class.
3. Code reuse using "extends".
------------------------------------------------------------
*/

class Animal {
    void eat() {
        System.out.println("Animal is eating...");
    }

    void sleep() {
        System.out.println("Animal is sleeping...");
    }
}

// Dog IS-A Animal
class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking...");
    }
}

public class Inheritance05 {

    public static void main(String[] args) {
        Dog dog = new Dog();

        // Inherited methods
        dog.eat();
        dog.sleep();

        // Own method
        dog.bark();

        /*
        🔎 OUTPUT:
        Animal is eating...
        Animal is sleeping...
        Dog is barking...
        */
    }
}
