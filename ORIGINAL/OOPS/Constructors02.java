// File: Constructors02.java
// Topic: Constructors in Java (Default & Parameterized)

/*
------------------------------------------------------------
📌 WHAT YOU WILL LEARN IN THIS FILE
------------------------------------------------------------
1. What is a Constructor?
   - A special method that has the SAME NAME as the class.
   - It is called automatically when an object is created.
   - No return type (not even void).

2. Types:
   - Default Constructor (no parameters)
   - Parameterized Constructor (with parameters)

3. Why use Constructors?
   - To initialize object data at the time of object creation.
------------------------------------------------------------
*/

class Student {
    String name;
    int age;
    double cgpa;

    /*
    --------------------------------------------------------
    🧱 1. DEFAULT CONSTRUCTOR
    --------------------------------------------------------
    - No parameters
    - Sets some default values
    --------------------------------------------------------
    */
    Student() {
        name = "Unknown";
        age = 18;
        cgpa = 0.0;
        System.out.println("Default Constructor called ");
    }

    /*
    --------------------------------------------------------
    🧱 2. PARAMETERIZED CONSTRUCTOR
    --------------------------------------------------------
    - Has parameters
    - Allows us to give custom values while creating object
    --------------------------------------------------------
    */
    Student(String name, int age, double cgpa) {
        // 'this' refers to the current object's fields
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
        System.out.println("Parameterized Constructor called ");
    }

    void showInfo() {
        System.out.println("Name: " + name + ", Age: " + age + ", CGPA: " + cgpa);
    }
}

public class Constructors02 {

    public static void main(String[] args) {

        /*
        --------------------------------------------------------
        🧠 EXAMPLE 1: USING DEFAULT CONSTRUCTOR
        --------------------------------------------------------
        */

        Student s1 = new Student();  // calls Student()
        s1.showInfo();

        System.out.println("-----------------------------");

        /*
        --------------------------------------------------------
        🧠 EXAMPLE 2: USING PARAMETERIZED CONSTRUCTOR
        --------------------------------------------------------
        */

        Student s2 = new Student("Ankan", 22, 8.7);
        s2.showInfo();

        System.out.println("-----------------------------");

        Student s3 = new Student("Rahul", 21, 9.1);
        s3.showInfo();

        /*
        --------------------------------------------------------
        ✅ KEY TAKEAWAYS
        --------------------------------------------------------
        1. Constructor name == Class name.
        2. No return type.
        3. Called automatically when we use 'new'.
        4. We can create MANY constructors with different parameters
           (this is called CONSTRUCTOR OVERLOADING).
        --------------------------------------------------------
        */

        /*
        🔎 SAMPLE OUTPUT (approx):

        Default Constructor called ✅
        Name: Unknown, Age: 18, CGPA: 0.0
        -----------------------------
        Parameterized Constructor called ✅
        Name: Ankan, Age: 22, CGPA: 8.7
        -----------------------------
        Parameterized Constructor called ✅
        Name: Rahul, Age: 21, CGPA: 9.1
        */
    }
}
