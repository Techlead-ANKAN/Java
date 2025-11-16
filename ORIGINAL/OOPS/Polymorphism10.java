// File: Polymorphism10.java
// Topic: Polymorphism (one name, many forms)

/*
------------------------------------------------------------
📌 WHAT YOU WILL LEARN
------------------------------------------------------------
1. Compile-time polymorphism -> Method Overloading.
2. Runtime polymorphism -> Method Overriding with upcasting.
------------------------------------------------------------
*/

class Shape {
    void draw() {
        System.out.println("Drawing a generic shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}

public class Polymorphism10 {

    public static void main(String[] args) {
        // Runtime polymorphism using parent reference
        Shape s;

        s = new Circle();
        s.draw();

        s = new Rectangle();
        s.draw();

        /*
        🔎 OUTPUT:
        Drawing a circle
        Drawing a rectangle
        */
    }
}
