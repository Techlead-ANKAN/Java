/*
 * ===============================================================
 *                    JAVA OOP CONCEPTS - PART 11
 *                      STATIC KEYWORD
 * ===============================================================
 * 
 * WHAT IS STATIC KEYWORD?
 * - 'static' is a keyword in Java that belongs to the class rather than any instance
 * - Static members are shared among all instances of the class
 * - They can be accessed without creating an object of the class
 * - Memory is allocated only once when the class is first loaded
 * 
 * TYPES OF STATIC MEMBERS:
 * 1. Static Variables (Class Variables)
 * 2. Static Methods (Class Methods)
 * 3. Static Blocks (Static Initializers)
 * 4. Static Nested Classes
 * 
 * KEY CHARACTERISTICS:
 * - Belongs to class, not to any specific instance
 * - Shared among all objects of the class
 * - Can be accessed using ClassName.memberName
 * - Loaded when class is first referenced
 * - Cannot access non-static members directly
 * - Cannot be overridden (but can be hidden)
 */

// Example 1: University Student Management System
class Student {
    // Static variables (shared by all instances)
    private static String universityName = "Tech University";
    private static int totalStudents = 0;
    private static double totalFees = 0.0;
    private static String currentSemester = "Fall 2024";
    
    // Instance variables (unique to each object)
    private String studentId;
    private String name;
    private String course;
    private double gpa;
    private double feesPaid;
    
    // Static block - executed when class is first loaded
    static {
        System.out.println("🏫 Student Management System Initializing...");
        System.out.println("🏛️ Welcome to " + universityName);
        System.out.println("📅 Current Semester: " + currentSemester);
        System.out.println("✅ Static block executed - System ready!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }
    
    // Constructor
    public Student(String studentId, String name, String course, double gpa, double fees) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.gpa = gpa;
        this.feesPaid = fees;
        
        // Update static variables
        totalStudents++;
        totalFees += fees;
        
        System.out.println("👨‍🎓 Student created: " + name + " (ID: " + studentId + ")");
        System.out.println("📊 Total students now: " + totalStudents);
    }
    
    // Static methods (can be called without creating objects)
    public static void displayUniversityInfo() {
        System.out.println("\n🏛️ UNIVERSITY INFORMATION");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("University: " + universityName);
        System.out.println("Current Semester: " + currentSemester);
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Total Fees Collected: $" + String.format("%.2f", totalFees));
        System.out.println("Average Fees per Student: $" + 
                          String.format("%.2f", (totalStudents > 0 ? totalFees/totalStudents : 0)));
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
    
    public static int getTotalStudents() {
        return totalStudents;
    }
    
    public static double getTotalFees() {
        return totalFees;
    }
    
    public static void setCurrentSemester(String semester) {
        currentSemester = semester;
        System.out.println("📅 Semester updated to: " + semester);
    }
    
    public static void setUniversityName(String name) {
        universityName = name;
        System.out.println("🏛️ University name updated to: " + name);
    }
    
    // Static method with business logic
    public static void generateSemesterReport() {
        System.out.println("\n📊 SEMESTER REPORT - " + currentSemester);
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("University: " + universityName);
        System.out.println("Total Enrolled Students: " + totalStudents);
        System.out.println("Total Revenue: $" + String.format("%.2f", totalFees));
        
        if (totalStudents > 0) {
            System.out.println("Average Fee per Student: $" + String.format("%.2f", totalFees/totalStudents));
            
            if (totalStudents > 1000) {
                System.out.println("🎉 Milestone: Large University Status!");
            } else if (totalStudents > 500) {
                System.out.println("🏛️ Status: Medium University");
            } else {
                System.out.println("🏫 Status: Small University");
            }
        }
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
    
    // Instance methods (non-static)
    public void displayStudentInfo() {
        System.out.println("=== Student Information ===");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("GPA: " + gpa);
        System.out.println("Fees Paid: $" + feesPaid);
        // Accessing static variable from instance method
        System.out.println("University: " + universityName);
        System.out.println("Semester: " + currentSemester);
        System.out.println("===========================\n");
    }
    
    public void payAdditionalFees(double amount) {
        if (amount > 0) {
            this.feesPaid += amount;
            totalFees += amount; // Update static variable
            System.out.println("💰 " + name + " paid additional $" + amount);
            System.out.println("New total fees for " + name + ": $" + feesPaid);
            System.out.println("University total fees now: $" + String.format("%.2f", totalFees));
        }
    }
    
    // Getter methods
    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public double getGpa() { return gpa; }
    public double getFeesPaid() { return feesPaid; }
}

// Example 2: Utility Class with Static Methods
class MathUtils {
    // Static constants
    public static final double PI = 3.14159265359;
    public static final double E = 2.71828182846;
    public static final int MAX_INT = Integer.MAX_VALUE;
    
    // Static variable to count method calls
    private static int totalCalculations = 0;
    
    // Static block for initialization
    static {
        System.out.println("🧮 MathUtils class loaded - Mathematical operations available");
    }
    
    // Private constructor to prevent instantiation (Utility class pattern)
    private MathUtils() {
        // Utility class should not be instantiated
    }
    
    // Static methods for mathematical operations
    public static double add(double a, double b) {
        totalCalculations++;
        System.out.println("➕ Adding: " + a + " + " + b);
        return a + b;
    }
    
    public static double multiply(double a, double b) {
        totalCalculations++;
        System.out.println("✖️ Multiplying: " + a + " × " + b);
        return a * b;
    }
    
    public static double power(double base, int exponent) {
        totalCalculations++;
        System.out.println("🔢 Calculating: " + base + "^" + exponent);
        double result = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }
        return exponent < 0 ? 1/result : result;
    }
    
    public static long factorial(int n) {
        totalCalculations++;
        if (n < 0) {
            System.out.println("❌ Factorial undefined for negative numbers");
            return -1;
        }
        System.out.println("🔢 Calculating factorial of: " + n);
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    public static double circleArea(double radius) {
        totalCalculations++;
        System.out.println("⭕ Calculating circle area with radius: " + radius);
        return PI * radius * radius;
    }
    
    public static boolean isPrime(int number) {
        totalCalculations++;
        System.out.println("🔍 Checking if " + number + " is prime");
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    
    // Static method to get statistics
    public static void displayCalculationStats() {
        System.out.println("\n📊 MATHUTILS STATISTICS");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Total calculations performed: " + totalCalculations);
        System.out.println("Available constants:");
        System.out.println("• PI = " + PI);
        System.out.println("• E = " + E);
        System.out.println("• MAX_INT = " + MAX_INT);
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
    
    public static void resetCalculationCount() {
        totalCalculations = 0;
        System.out.println("🔄 Calculation count reset to 0");
    }
}

// Example 3: Singleton Pattern using Static
class DatabaseConnection {
    // Static variable to hold the single instance
    private static DatabaseConnection instance = null;
    private static int connectionCount = 0;
    
    // Private constructor prevents external instantiation
    private DatabaseConnection() {
        connectionCount++;
        System.out.println("🗄️ Database connection established (Connection #" + connectionCount + ")");
        System.out.println("💾 Connecting to: mysql://localhost:3306/university_db");
    }
    
    // Static method to get the single instance (Singleton pattern)
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            System.out.println("🔗 Creating new database connection...");
            instance = new DatabaseConnection();
        } else {
            System.out.println("♻️ Reusing existing database connection");
        }
        return instance;
    }
    
    // Static method to get connection statistics
    public static void displayConnectionInfo() {
        System.out.println("\n🗄️ DATABASE CONNECTION INFO");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Instance created: " + (instance != null ? "Yes" : "No"));
        System.out.println("Total connection attempts: " + connectionCount);
        System.out.println("Connection status: " + (instance != null ? "Active" : "Not connected"));
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
    
    // Instance methods for database operations
    public void executeQuery(String query) {
        System.out.println("🔍 Executing query: " + query);
    }
    
    public void closeConnection() {
        System.out.println("🔌 Database connection closed");
    }
}

// Example 4: Static Nested Class
class OuterClass {
    private static String staticOuterField = "Static Outer Field";
    private String instanceOuterField = "Instance Outer Field";
    
    // Static nested class
    static class StaticNestedClass {
        public void display() {
            System.out.println("📦 Inside Static Nested Class");
            // Can access static members of outer class
            System.out.println("Accessing: " + staticOuterField);
            // Cannot access instance members directly
            // System.out.println(instanceOuterField); // ❌ Compilation error
        }
        
        public static void staticMethod() {
            System.out.println("⚡ Static method in static nested class");
        }
    }
    
    public void demonstrateNestedClass() {
        System.out.println("🏠 Creating static nested class instance from outer class");
        StaticNestedClass nested = new StaticNestedClass();
        nested.display();
    }
}

// Main class to demonstrate Static Keyword
public class Static_Keyword {
    
    // Static method for utility testing
    public static void performMathOperations() {
        System.out.println("\n🧮 PERFORMING MATH OPERATIONS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Using static methods without creating objects
        double sum = MathUtils.add(15.5, 25.3);
        System.out.println("Result: " + sum);
        
        double product = MathUtils.multiply(7.0, 8.0);
        System.out.println("Result: " + product);
        
        double powerResult = MathUtils.power(2, 10);
        System.out.println("Result: " + powerResult);
        
        long factResult = MathUtils.factorial(6);
        System.out.println("Result: " + factResult);
        
        double area = MathUtils.circleArea(5.0);
        System.out.println("Result: " + String.format("%.2f", area));
        
        boolean isPrime = MathUtils.isPrime(17);
        System.out.println("Is 17 prime? " + isPrime);
        
        MathUtils.displayCalculationStats();
    }
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                    STATIC KEYWORD DEMO                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        // Static block is executed when class is loaded
        // This happens when Student class is first referenced
        
        // ===============================
        // STATIC VARIABLES AND METHODS
        // ===============================
        System.out.println("\n👨‍🎓 STATIC VARIABLES AND METHODS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Accessing static method without creating objects
        Student.displayUniversityInfo();
        
        // Create some students
        Student student1 = new Student("S001", "Alice Johnson", "Computer Science", 3.8, 15000.0);
        Student student2 = new Student("S002", "Bob Smith", "Mathematics", 3.6, 12000.0);
        Student student3 = new Student("S003", "Carol Davis", "Physics", 3.9, 18000.0);
        
        // Display updated static information
        Student.displayUniversityInfo();
        
        // Use static methods
        Student.setCurrentSemester("Spring 2025");
        Student.generateSemesterReport();
        
        // Instance methods can access static variables
        student1.displayStudentInfo();
        student1.payAdditionalFees(2000.0);
        
        System.out.println("Current total students: " + Student.getTotalStudents());
        System.out.println("Current total fees: $" + String.format("%.2f", Student.getTotalFees()));
        
        // ===============================
        // STATIC UTILITY CLASS
        // ===============================
        System.out.println("\n🧮 STATIC UTILITY CLASS DEMONSTRATION:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        performMathOperations(); // Static method call
        
        // ===============================
        // SINGLETON PATTERN WITH STATIC
        // ===============================
        System.out.println("\n🗄️ SINGLETON PATTERN:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Multiple calls return same instance
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        DatabaseConnection db3 = DatabaseConnection.getInstance();
        
        System.out.println("db1 == db2: " + (db1 == db2)); // Should be true
        System.out.println("db2 == db3: " + (db2 == db3)); // Should be true
        
        DatabaseConnection.displayConnectionInfo();
        
        db1.executeQuery("SELECT * FROM students");
        db1.closeConnection();
        
        // ===============================
        // STATIC NESTED CLASS
        // ===============================
        System.out.println("\n📦 STATIC NESTED CLASS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Create static nested class instance without outer class instance
        OuterClass.StaticNestedClass nested = new OuterClass.StaticNestedClass();
        nested.display();
        
        // Call static method of static nested class
        OuterClass.StaticNestedClass.staticMethod();
        
        // Create outer class and demonstrate
        OuterClass outer = new OuterClass();
        outer.demonstrateNestedClass();
        
        // ============================
        // STATIC KEYWORD RULES DEMO
        // ============================
        System.out.println("\n📋 STATIC KEYWORD RULES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ WHAT STATIC CAN DO:");
        System.out.println("   • Access other static members directly");
        System.out.println("   • Be called without creating objects");
        System.out.println("   • Shared among all instances of class");
        System.out.println("   • Initialized when class is first loaded");
        
        System.out.println("\n❌ WHAT STATIC CANNOT DO:");
        System.out.println("   • Access non-static members directly");
        System.out.println("   • Use 'this' or 'super' keywords");
        System.out.println("   • Be overridden (can be hidden)");
        System.out.println("   • Be abstract");
        
        // ============================
        // MEMORY AND PERFORMANCE
        // ============================
        System.out.println("\n💾 MEMORY AND PERFORMANCE:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ MEMORY EFFICIENCY:");
        System.out.println("   • Static variables: One copy per class");
        System.out.println("   • Instance variables: One copy per object");
        System.out.println("   • Static methods: No object creation needed");
        
        System.out.println("\n⚡ PERFORMANCE BENEFITS:");
        System.out.println("   • Faster access (no object lookup)");
        System.out.println("   • Memory savings for shared data");
        System.out.println("   • Utility methods without instantiation");
        
        // ============================
        // BEST PRACTICES
        // ============================
        System.out.println("\n💡 STATIC KEYWORD BEST PRACTICES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ USE STATIC FOR:");
        System.out.println("   • Utility methods (Math operations, validations)");
        System.out.println("   • Constants that are shared across instances");
        System.out.println("   • Factory methods and singleton patterns");
        System.out.println("   • Counters and statistics shared by all instances");
        
        System.out.println("\n⚠️ AVOID STATIC FOR:");
        System.out.println("   • Methods that need access to instance variables");
        System.out.println("   • Overuse leading to procedural programming");
        System.out.println("   • Mutable static variables (can cause issues)");
        System.out.println("   • Methods that should be overridden by subclasses");
        
        System.out.println("\n🎓 Ready to move to 12_Final_Keyword.java!");
    }
}

/*
 * STATIC MEMORY MODEL:
 * 
 * ┌─────────────────────────────────────────────────┐
 * │                 JVM MEMORY                      │
 * ├─────────────────────────────────────────────────┤
 * │ METHOD AREA (Static Memory)                     │
 * │ ┌─────────────────────────────────────────────┐ │
 * │ │ • Static variables                          │ │
 * │ │ • Static methods                            │ │
 * │ │ • Class definitions                         │ │
 * │ │ • Constants                                 │ │
 * │ └─────────────────────────────────────────────┘ │
 * ├─────────────────────────────────────────────────┤
 * │ HEAP MEMORY (Instance Memory)                   │
 * │ ┌─────────────────────────────────────────────┐ │
 * │ │ • Object instances                          │ │
 * │ │ • Instance variables                        │ │
 * │ │ • Arrays                                    │ │
 * │ └─────────────────────────────────────────────┘ │
 * └─────────────────────────────────────────────────┘
 */