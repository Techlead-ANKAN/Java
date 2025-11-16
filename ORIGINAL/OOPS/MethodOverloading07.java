// File: MethodOverloading07.java
// Topic: Compile-time Polymorphism (Method Overloading)

/*
------------------------------------------------------------
📌 WHAT YOU WILL LEARN
------------------------------------------------------------
1. Method Overloading:
   - Same method name, different parameter list.
2. Resolved at compile time.
------------------------------------------------------------
*/

class Calculator {

    // add two ints
    int add(int a, int b) {
        return a + b;
    }

    // add three ints
    int add(int a, int b, int c) {
        return a + b + c;
    }

    // add two doubles
    double add(double a, double b) {
        return a + b;
    }
}

public class MethodOverloading07 {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int sum1 = calc.add(10, 20);
        int sum2 = calc.add(5, 15, 25);
        double sum3 = calc.add(2.5, 3.7);

        System.out.println("add(int, int) = " + sum1);
        System.out.println("add(int, int, int) = " + sum2);
        System.out.println("add(double, double) = " + sum3);

        /*
        🔎 OUTPUT:
        add(int, int) = 30
        add(int, int, int) = 45
        add(double, double) = 6.2
        */
    }
}
