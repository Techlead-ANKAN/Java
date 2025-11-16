// File: Abstraction12.java
// Topic: Abstraction using abstract classes

/*
------------------------------------------------------------
📌 WHAT YOU WILL LEARN
------------------------------------------------------------
1. Abstract class: cannot be instantiated directly.
2. Abstract method: no body, must be overridden.
3. Achieves partial abstraction.
------------------------------------------------------------
*/

abstract class Shape2 {
    abstract void draw(); // abstract method

    void commonInfo() {
        System.out.println("All shapes have area and perimeter.");
    }
}

class Circle2 extends Shape2 {
    @Override
    void draw() {
        System.out.println("Drawing a Circle2");
    }
}

class Square2 extends Shape2 {
    @Override
    void draw() {
        System.out.println("Drawing a Square2");
    }
}

public class Abstraction12 {

    public static void main(String[] args) {
        Shape2 s;

        s = new Circle2();
        s.draw();
        s.commonInfo();

        s = new Square2();
        s.draw();
        s.commonInfo();
    }
}
