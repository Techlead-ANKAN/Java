// File: StaticKeyword04.java
// Topic: static variable, static method, static block

/*
------------------------------------------------------------
📌 WHAT YOU WILL LEARN
------------------------------------------------------------
1. static variable: shared by all objects of the class.
2. static method: can be called without object.
3. static block: runs once when class is loaded.
------------------------------------------------------------
*/

class Counter {
    // static = shared
    static int count = 0;

    // non-static field
    String name;

    Counter(String name) {
        this.name = name;
        count++; // increments shared count
    }

    void show() {
        System.out.println("Name: " + name + ", Current count = " + count);
    }

    static void showTotalObjects() {
        System.out.println("Total objects created: " + count);
    }

    // static block (runs once)
    static {
        System.out.println("Static block: Counter class loaded ✅");
    }
}

public class StaticKeyword04 {

    public static void main(String[] args) {
        Counter c1 = new Counter("Obj1");
        c1.show();

        Counter c2 = new Counter("Obj2");
        c2.show();

        Counter c3 = new Counter("Obj3");
        c3.show();

        // calling static method using class name
        Counter.showTotalObjects();

        /*
        🔎 OUTPUT (approx):
        Static block: Counter class loaded ✅
        Name: Obj1, Current count = 1
        Name: Obj2, Current count = 2
        Name: Obj3, Current count = 3
        Total objects created: 3
        */
    }
}
