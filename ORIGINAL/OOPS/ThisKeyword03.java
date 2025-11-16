// File: ThisKeyword03.java
// Topic: Use of 'this' keyword in Java

/*
------------------------------------------------------------
📌 WHAT YOU WILL LEARN IN THIS FILE
------------------------------------------------------------
1. Meaning of 'this'
   - Refers to the current object.

2. Common Uses:
   - To distinguish between instance variable and parameter.
   - To call another constructor (this()).
   - To pass current object as argument.
------------------------------------------------------------
*/

class Person {
    String name;
    int age;

    // Constructor with parameters having same names as fields
    Person(String name, int age) {
        // 'this.name' = instance variable, 'name' = parameter
        this.name = name;
        this.age = age;
    }

    void show() {
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }
}

public class ThisKeyword03 {

    public static void main(String[] args) {
        Person p1 = new Person("Ankan", 22);
        Person p2 = new Person("Rahul", 21);

        p1.show();
        p2.show();

        /*
        🔎 OUTPUT (approx):
        Name: Ankan, Age: 22
        Name: Rahul, Age: 21
        */
    }
}
