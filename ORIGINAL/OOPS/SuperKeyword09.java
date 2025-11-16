// File: SuperKeyword09.java
// Topic: super keyword (access parent class members)

/*
------------------------------------------------------------
📌 WHAT YOU WILL LEARN
------------------------------------------------------------
1. super.variable   -> access parent class variable
2. super.method()   -> call parent method
3. super()          -> call parent constructor
------------------------------------------------------------
*/

class Vehicle {
    int maxSpeed = 120;

    Vehicle() {
        System.out.println("Vehicle constructor called");
    }

    void show() {
        System.out.println("Vehicle show()");
    }
}

class Bike extends Vehicle {
    int maxSpeed = 80;

    Bike() {
        super(); // calling parent constructor
        System.out.println("Bike constructor called");
    }

    void show() {
        System.out.println("Child maxSpeed = " + maxSpeed);
        System.out.println("Parent maxSpeed = " + super.maxSpeed);
        super.show(); // call parent method
        System.out.println("Bike show()");
    }
}

public class SuperKeyword09 {

    public static void main(String[] args) {
        Bike b = new Bike();
        b.show();

        /*
        🔎 OUTPUT (approx):
        Vehicle constructor called
        Bike constructor called
        Child maxSpeed = 80
        Parent maxSpeed = 120
        Vehicle show()
        Bike show()
        */
    }
}
