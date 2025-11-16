// File: ClassAndObjects01.java
// Topic: Basic idea of Class and Object in Java

/*
------------------------------------------------------------
📌 WHAT YOU WILL LEARN IN THIS FILE
------------------------------------------------------------
1. What is a Class?
   - A blueprint/template that defines properties (fields) and actions (methods).

2. What is an Object?
   - A real-world instance created from a class.
   - It has its own copy of the fields defined in the class.

3. How to:
   - Define a class (Car)
   - Create objects of that class
   - Access fields and methods using the object
------------------------------------------------------------
*/

class Car {
    // 🔹 Fields (Properties / Data Members)
    String brand;
    String color;
    int year;

    // 🔹 Method (Behavior / Functionality)
    void start() {
        System.out.println(brand + " is starting...");
    }

    void showDetails() {
        System.out.println("Brand: " + brand + ", Color: " + color + ", Year: " + year);
    }
}

// 🔹 Main class: file name and class name are SAME (valid, recommended)
public class ClassAndObjects01 {

    public static void main(String[] args) {
        /*
        --------------------------------------------------------
        🧠 STEP 1: CREATE OBJECTS
        --------------------------------------------------------
        Syntax:
            ClassName refVar = new ClassName();

        - 'new' keyword allocates memory.
        - 'refVar' is a reference variable that points to the object.
        --------------------------------------------------------
        */

        Car car1 = new Car();   // Object 1
        Car car2 = new Car();   // Object 2

        /*
        --------------------------------------------------------
        🧠 STEP 2: SET FIELD VALUES FOR EACH OBJECT
        --------------------------------------------------------
        Syntax:
            objectName.fieldName = value;
        --------------------------------------------------------
        */

        car1.brand = "Toyota";
        car1.color = "White";
        car1.year = 2020;

        car2.brand = "Tesla";
        car2.color = "Red";
        car2.year = 2023;

        /*
        --------------------------------------------------------
        🧠 STEP 3: CALL METHODS USING OBJECTS
        --------------------------------------------------------
        Syntax:
            objectName.methodName();
        --------------------------------------------------------
        */

        car1.start();        // calls start() of car1
        car1.showDetails();  // shows details of car1

        System.out.println("-----------------------------");

        car2.start();        // calls start() of car2
        car2.showDetails();  // shows details of car2

        /*
        --------------------------------------------------------
        ✅ KEY TAKEAWAYS
        --------------------------------------------------------
        1. Class = Design / Blueprint (Car)
        2. Object = Real thing created from class (car1, car2)
        3. Each object has its own copy of fields.
        4. Methods define what an object can DO.
        --------------------------------------------------------
        */

        /*
        🔎 EXPECTED OUTPUT (approx):

        Toyota is starting...
        Brand: Toyota, Color: White, Year: 2020
        -----------------------------
        Tesla is starting...
        Brand: Tesla, Color: Red, Year: 2023
        */
    }
}
