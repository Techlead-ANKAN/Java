// File: TypesOfInheritance06.java
// Topic: Types of Inheritance (Single, Multi-level, Hierarchical)

/*
------------------------------------------------------------
📌 WHAT YOU WILL LEARN
------------------------------------------------------------
1. Single Inheritance
2. Multi-level Inheritance
3. Hierarchical Inheritance

(⚠ Java does not support multiple inheritance using classes)
------------------------------------------------------------
*/

// Single Inheritance: A -> B
class A {
    void showA() {
        System.out.println("Inside class A");
    }
}

class B extends A {
    void showB() {
        System.out.println("Inside class B");
    }
}

// Multi-level Inheritance: X -> Y -> Z
class X {
    void showX() {
        System.out.println("Inside class X");
    }
}

class Y extends X {
    void showY() {
        System.out.println("Inside class Y");
    }
}

class Z extends Y {
    void showZ() {
        System.out.println("Inside class Z");
    }
}

// Hierarchical Inheritance: Parent -> Child1, Child2
class Parent {
    void showParent() {
        System.out.println("Inside Parent");
    }
}

class Child1 extends Parent {
    void showChild1() {
        System.out.println("Inside Child1");
    }
}

class Child2 extends Parent {
    void showChild2() {
        System.out.println("Inside Child2");
    }
}

public class TypesOfInheritance06 {

    public static void main(String[] args) {
        System.out.println("Single Inheritance:");
        B objB = new B();
        objB.showA();
        objB.showB();

        System.out.println("--------------------");
        System.out.println("Multi-level Inheritance:");
        Z objZ = new Z();
        objZ.showX();
        objZ.showY();
        objZ.showZ();

        System.out.println("--------------------");
        System.out.println("Hierarchical Inheritance:");
        Child1 c1 = new Child1();
        Child2 c2 = new Child2();

        c1.showParent();
        c1.showChild1();

        c2.showParent();
        c2.showChild2();
    }
}
