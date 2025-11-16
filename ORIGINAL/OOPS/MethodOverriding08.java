// File: MethodOverriding08.java
// Topic: Runtime Polymorphism (Method Overriding)

/*
------------------------------------------------------------
📌 WHAT YOU WILL LEARN
------------------------------------------------------------
1. Method Overriding:
   - Same method signature in parent and child.
   - Decided at runtime based on object.
------------------------------------------------------------
*/

class Animal2 {
    void sound() {
        System.out.println("Animal2 makes a sound");
    }
}

class Dog2 extends Animal2 {
    @Override
    void sound() {
        System.out.println("Dog2 barks");
    }
}

class Cat2 extends Animal2 {
    @Override
    void sound() {
        System.out.println("Cat2 meows");
    }
}

public class MethodOverriding08 {

    public static void main(String[] args) {
        Animal2 a;

        a = new Dog2();
        a.sound(); // Dog2 version

        a = new Cat2();
        a.sound(); // Cat2 version

        /*
        🔎 OUTPUT:
        Dog2 barks
        Cat2 meows
        */
    }
}
