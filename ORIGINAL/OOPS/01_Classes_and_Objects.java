/*
 * ===============================================================
 *                    JAVA OOP CONCEPTS - PART 1
 *                     CLASSES AND OBJECTS
 * ===============================================================
 * 
 * WHAT IS A CLASS?
 * - A class is a blueprint or template for creating objects
 * - It defines the structure and behavior that objects will have
 * - Think of it as a cookie cutter - the class is the cutter, objects are the cookies
 * 
 * WHAT IS AN OBJECT?
 * - An object is an instance of a class
 * - It's a real entity that occupies memory
 * - Objects have state (attributes) and behavior (methods)
 * 
 * SYNTAX:
 * class ClassName {
 *     // Instance variables (attributes/properties)
 *     dataType variableName;
 *     
 *     // Methods (behavior/functions)
 *     returnType methodName() {
 *         // method body
 *     }
 * }
 * 
 * CREATING OBJECTS:
 * ClassName objectName = new ClassName();
 */

// Example 1: Simple Student Class
class Student {
    // Instance variables (attributes/properties)
    String name;        // Student's name
    int age;           // Student's age
    String course;     // Student's course
    double marks;      // Student's marks
    
    // Method to display student information
    void displayInfo() {
        System.out.println("=== Student Information ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("==========================");
    }
    
    // Method to check if student passed (marks >= 40)
    void checkResult() {
        if (marks >= 40) {
            System.out.println(name + " has PASSED! 🎉");
        } else {
            System.out.println(name + " has FAILED. Better luck next time! 📚");
        }
    }
    
    // Method to calculate grade based on marks
    String calculateGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 40) return "D";
        else return "F";
    }
}

// Example 2: Car Class
class Car {
    // Instance variables
    String brand;       // Car brand (Toyota, Honda, etc.)
    String model;       // Car model (Corolla, Civic, etc.)
    String color;       // Car color
    int year;          // Manufacturing year
    double price;      // Car price
    boolean isRunning; // Is the car currently running?
    
    // Method to start the car
    void startCar() {
        if (!isRunning) {
            isRunning = true;
            System.out.println("🚗 " + brand + " " + model + " is now STARTED! Vroom!");
        } else {
            System.out.println("🚗 " + brand + " " + model + " is already running!");
        }
    }
    
    // Method to stop the car
    void stopCar() {
        if (isRunning) {
            isRunning = false;
            System.out.println("🛑 " + brand + " " + model + " has been STOPPED!");
        } else {
            System.out.println("🛑 " + brand + " " + model + " is already stopped!");
        }
    }
    
    // Method to display car details
    void displayCarInfo() {
        System.out.println("=== Car Information ===");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Year: " + year);
        System.out.println("Price: $" + price);
        System.out.println("Status: " + (isRunning ? "Running 🟢" : "Stopped 🔴"));
        System.out.println("=====================");
    }
    
    // Method to calculate car age
    int calculateAge() {
        return 2024 - year; // Assuming current year is 2024
    }
}

// Main class to demonstrate Classes and Objects
public class Classes_and_Objects {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                 CLASSES AND OBJECTS DEMO                ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        // ========================
        // CREATING STUDENT OBJECTS
        // ========================
        System.out.println("\n📚 STUDENT EXAMPLES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━");
        
        // Creating first student object
        Student student1 = new Student();
        student1.name = "Alice Johnson";
        student1.age = 20;
        student1.course = "Computer Science";
        student1.marks = 85.5;
        
        // Creating second student object
        Student student2 = new Student();
        student2.name = "Bob Smith";
        student2.age = 19;
        student2.course = "Mathematics";
        student2.marks = 35.0;
        
        // Creating third student object
        Student student3 = new Student();
        student3.name = "Carol Davis";
        student3.age = 21;
        student3.course = "Physics";
        student3.marks = 92.0;
        
        // Display student information
        student1.displayInfo();
        student1.checkResult();
        System.out.println("Grade: " + student1.calculateGrade() + "\n");
        
        student2.displayInfo();
        student2.checkResult();
        System.out.println("Grade: " + student2.calculateGrade() + "\n");
        
        student3.displayInfo();
        student3.checkResult();
        System.out.println("Grade: " + student3.calculateGrade() + "\n");
        
        // =====================
        // CREATING CAR OBJECTS
        // =====================
        System.out.println("🚗 CAR EXAMPLES:");
        System.out.println("━━━━━━━━━━━━━━━━");
        
        // Creating first car object
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.model = "Corolla";
        car1.color = "Red";
        car1.year = 2020;
        car1.price = 25000.00;
        car1.isRunning = false;
        
        // Creating second car object
        Car car2 = new Car();
        car2.brand = "Honda";
        car2.model = "Civic";
        car2.color = "Blue";
        car2.year = 2018;
        car2.price = 22000.00;
        car2.isRunning = true;
        
        // Demonstrate car operations
        System.out.println("\n--- Car 1 Operations ---");
        car1.displayCarInfo();
        System.out.println("Car Age: " + car1.calculateAge() + " years");
        car1.startCar();
        car1.startCar(); // Try to start again
        car1.stopCar();
        
        System.out.println("\n--- Car 2 Operations ---");
        car2.displayCarInfo();
        System.out.println("Car Age: " + car2.calculateAge() + " years");
        car2.stopCar();
        car2.startCar();
        
        // ===============================
        // DEMONSTRATING MULTIPLE OBJECTS
        // ===============================
        System.out.println("\n🎯 KEY CONCEPTS DEMONSTRATION:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ Each object has its own copy of instance variables");
        System.out.println("   student1.name = " + student1.name);
        System.out.println("   student2.name = " + student2.name);
        System.out.println("   student3.name = " + student3.name);
        
        System.out.println("\n✅ Objects can have different states:");
        System.out.println("   car1.isRunning = " + car1.isRunning);
        System.out.println("   car2.isRunning = " + car2.isRunning);
        
        System.out.println("\n✅ Methods can be called on different objects:");
        System.out.println("   student1 grade: " + student1.calculateGrade());
        System.out.println("   student2 grade: " + student2.calculateGrade());
        System.out.println("   student3 grade: " + student3.calculateGrade());
        
        // ================================
        // IMPORTANT NOTES AND BEST PRACTICES
        // ================================
        System.out.println("\n📝 IMPORTANT NOTES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━");
        System.out.println("1. Class name should always start with Capital letter");
        System.out.println("2. Object creation: ClassName objectName = new ClassName();");
        System.out.println("3. Each object has its own copy of instance variables");
        System.out.println("4. Methods define the behavior of objects");
        System.out.println("5. Multiple objects of same class can have different states");
        System.out.println("6. Objects are stored in heap memory");
        System.out.println("7. Reference variables are stored in stack memory");
        System.out.println("\n🎓 Ready to move to 02_Constructors.java!");
    }
}

/*
 * EXPECTED OUTPUT:
 * ═══════════════════════════════════════════════════════════
 *                  CLASSES AND OBJECTS DEMO
 * ═══════════════════════════════════════════════════════════
 * 
 * 📚 STUDENT EXAMPLES:
 * ━━━━━━━━━━━━━━━━━━━━━━
 * === Student Information ===
 * Name: Alice Johnson
 * Age: 20
 * Course: Computer Science
 * Marks: 85.5
 * ==========================
 * Alice Johnson has PASSED! 🎉
 * Grade: A
 * 
 * === Student Information ===
 * Name: Bob Smith
 * Age: 19
 * Course: Mathematics
 * Marks: 35.0
 * ==========================
 * Bob Smith has FAILED. Better luck next time! 📚
 * Grade: F
 * 
 * ... and so on
 */