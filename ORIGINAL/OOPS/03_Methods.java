/*
 * ===============================================================
 *                    JAVA OOP CONCEPTS - PART 3
 *                          METHODS
 * ===============================================================
 * 
 * WHAT ARE METHODS?
 * - Methods are functions that belong to a class
 * - They define the behavior of objects
 * - Methods can accept parameters and return values
 * - They provide reusability and organization of code
 * 
 * METHOD SYNTAX:
 * [access_modifier] [static] returnType methodName(parameters) {
 *     // method body
 *     return value; // if return type is not void
 * }
 * 
 * TYPES OF METHODS:
 * 1. Instance Methods (need object to call)
 * 2. Static Methods (called using class name)
 * 3. Void Methods (don't return anything)
 * 4. Methods with Return Values
 * 5. Methods with Parameters
 * 6. Overloaded Methods (same name, different parameters)
 * 
 * METHOD OVERLOADING:
 * - Same method name with different parameters
 * - Different number of parameters OR different parameter types
 * - Return type alone cannot be used for overloading
 */

// Example 1: Calculator Class with Various Method Types
class Calculator {
    String calculatorName;
    
    // Constructor
    Calculator(String name) {
        calculatorName = name;
        System.out.println("🧮 Calculator '" + name + "' initialized!");
    }
    
    // ===============================
    // BASIC METHODS WITH RETURN VALUES
    // ===============================
    
    // Method to add two numbers
    int add(int a, int b) {
        System.out.println("➕ Adding " + a + " + " + b);
        return a + b;
    }
    
    // Method to subtract two numbers
    int subtract(int a, int b) {
        System.out.println("➖ Subtracting " + a + " - " + b);
        return a - b;
    }
    
    // Method to multiply two numbers
    int multiply(int a, int b) {
        System.out.println("✖️ Multiplying " + a + " × " + b);
        return a * b;
    }
    
    // Method to divide two numbers
    double divide(int a, int b) {
        if (b == 0) {
            System.out.println("❌ Error: Division by zero!");
            return 0;
        }
        System.out.println("➗ Dividing " + a + " ÷ " + b);
        return (double) a / b;
    }
    
    // ===============================
    // METHOD OVERLOADING EXAMPLES
    // ===============================
    
    // Overloaded add method for double values
    double add(double a, double b) {
        System.out.println("➕ Adding doubles: " + a + " + " + b);
        return a + b;
    }
    
    // Overloaded add method for three integers
    int add(int a, int b, int c) {
        System.out.println("➕ Adding three numbers: " + a + " + " + b + " + " + c);
        return a + b + c;
    }
    
    // Overloaded add method for array of numbers
    int add(int[] numbers) {
        System.out.print("➕ Adding array: ");
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) System.out.print(" + ");
            sum += numbers[i];
        }
        System.out.println();
        return sum;
    }
    
    // ===============================
    // VOID METHODS (NO RETURN VALUE)
    // ===============================
    
    // Method to display calculator info
    void displayInfo() {
        System.out.println("=== Calculator Information ===");
        System.out.println("Name: " + calculatorName);
        System.out.println("Type: Scientific Calculator");
        System.out.println("Status: Ready for calculations");
        System.out.println("==============================");
    }
    
    // Method to show operation history
    void showOperationHistory(String[] operations) {
        System.out.println("📊 Operation History:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━");
        for (int i = 0; i < operations.length; i++) {
            System.out.println((i + 1) + ". " + operations[i]);
        }
        System.out.println("━━━━━━━━━━━━━━━━━━━━━");
    }
    
    // ===============================
    // METHODS WITH COMPLEX OPERATIONS
    // ===============================
    
    // Method to calculate power
    double power(double base, int exponent) {
        System.out.println("🔢 Calculating " + base + "^" + exponent);
        double result = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result *= base;
        }
        return exponent < 0 ? 1/result : result;
    }
    
    // Method to calculate factorial
    long factorial(int n) {
        if (n < 0) {
            System.out.println("❌ Factorial not defined for negative numbers!");
            return -1;
        }
        System.out.println("🔢 Calculating factorial of " + n);
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    // Method to find maximum of three numbers
    int findMax(int a, int b, int c) {
        System.out.println("🔍 Finding maximum of: " + a + ", " + b + ", " + c);
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }
    
    // Method to check if number is prime
    boolean isPrime(int number) {
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
}

// Example 2: Student Management System
class StudentManager {
    
    // ===============================
    // STATIC METHODS (CLASS METHODS)
    // ===============================
    
    // Static method to validate student age
    static boolean isValidAge(int age) {
        System.out.println("🔍 Validating age: " + age);
        return age >= 5 && age <= 100;
    }
    
    // Static method to calculate letter grade
    static String calculateLetterGrade(double marks) {
        System.out.println("📝 Calculating letter grade for marks: " + marks);
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }
    
    // Static method to calculate GPA
    static double calculateGPA(double[] marks) {
        System.out.println("📊 Calculating GPA for multiple subjects");
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total / marks.length;
    }
    
    // ===============================
    // INSTANCE METHODS
    // ===============================
    
    // Method to generate student report
    void generateReport(String studentName, double[] marks, String[] subjects) {
        System.out.println("\n📋 STUDENT REPORT");
        System.out.println("════════════════════════════════");
        System.out.println("Student Name: " + studentName);
        System.out.println("────────────────────────────────");
        
        double total = 0;
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i] + ": " + marks[i] + " (" + calculateLetterGrade(marks[i]) + ")");
            total += marks[i];
        }
        
        double average = total / marks.length;
        System.out.println("────────────────────────────────");
        System.out.println("Total Marks: " + total);
        System.out.println("Average: " + String.format("%.2f", average));
        System.out.println("Overall Grade: " + calculateLetterGrade(average));
        System.out.println("GPA: " + String.format("%.2f", calculateGPA(marks)));
        System.out.println("════════════════════════════════\n");
    }
    
    // Method to compare two students
    void compareStudents(String student1, double avg1, String student2, double avg2) {
        System.out.println("👥 STUDENT COMPARISON");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println(student1 + ": " + avg1 + "%");
        System.out.println(student2 + ": " + avg2 + "%");
        
        if (avg1 > avg2) {
            System.out.println("🏆 " + student1 + " is performing better!");
        } else if (avg2 > avg1) {
            System.out.println("🏆 " + student2 + " is performing better!");
        } else {
            System.out.println("🤝 Both students have equal performance!");
        }
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━\n");
    }
}

// Main class to demonstrate Methods
public class Methods {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                      METHODS DEMO                       ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        // ===============================
        // BASIC METHODS DEMONSTRATION
        // ===============================
        System.out.println("\n🧮 CALCULATOR METHODS DEMO:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        Calculator calc = new Calculator("Scientific Pro");
        calc.displayInfo();
        
        // Basic arithmetic operations
        System.out.println("\n--- Basic Operations ---");
        int sum = calc.add(15, 25);
        System.out.println("Result: " + sum);
        
        int difference = calc.subtract(50, 20);
        System.out.println("Result: " + difference);
        
        int product = calc.multiply(8, 7);
        System.out.println("Result: " + product);
        
        double quotient = calc.divide(100, 3);
        System.out.println("Result: " + String.format("%.2f", quotient));
        
        // ===============================
        // METHOD OVERLOADING DEMONSTRATION
        // ===============================
        System.out.println("\n--- Method Overloading Examples ---");
        
        // Different parameter types
        double doubleSum = calc.add(15.5, 25.3);
        System.out.println("Double sum result: " + doubleSum);
        
        // Different number of parameters
        int tripleSum = calc.add(10, 20, 30);
        System.out.println("Triple sum result: " + tripleSum);
        
        // Array parameter
        int[] numbers = {5, 10, 15, 20, 25};
        int arraySum = calc.add(numbers);
        System.out.println("Array sum result: " + arraySum);
        
        // ===============================
        // COMPLEX OPERATIONS
        // ===============================
        System.out.println("\n--- Complex Operations ---");
        
        double powerResult = calc.power(2, 8);
        System.out.println("Power result: " + powerResult);
        
        long factorialResult = calc.factorial(5);
        System.out.println("Factorial result: " + factorialResult);
        
        int maxResult = calc.findMax(45, 67, 23);
        System.out.println("Maximum: " + maxResult);
        
        boolean primeCheck = calc.isPrime(17);
        System.out.println("Is 17 prime? " + primeCheck);
        
        // Operation history
        String[] history = {
            "15 + 25 = 40",
            "50 - 20 = 30",
            "8 × 7 = 56",
            "100 ÷ 3 = 33.33"
        };
        calc.showOperationHistory(history);
        
        // ===============================
        // STATIC METHODS DEMONSTRATION
        // ===============================
        System.out.println("\n👨‍🎓 STUDENT MANAGER - STATIC METHODS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Static methods are called using class name
        boolean validAge = StudentManager.isValidAge(20);
        System.out.println("Is age 20 valid? " + validAge);
        
        String grade = StudentManager.calculateLetterGrade(85);
        System.out.println("Letter grade for 85: " + grade);
        
        double[] studentMarks = {85, 92, 78, 88, 90};
        double gpa = StudentManager.calculateGPA(studentMarks);
        System.out.println("GPA: " + String.format("%.2f", gpa));
        
        // ===============================
        // INSTANCE METHODS WITH OBJECTS
        // ===============================
        System.out.println("\n--- Student Reports ---");
        
        StudentManager manager = new StudentManager();
        
        // Generate report for student 1
        String[] subjects1 = {"Math", "Physics", "Chemistry", "English", "Computer Science"};
        double[] marks1 = {85, 92, 78, 88, 90};
        manager.generateReport("Alice Johnson", marks1, subjects1);
        
        // Generate report for student 2
        String[] subjects2 = {"Math", "Physics", "Chemistry", "English", "Computer Science"};
        double[] marks2 = {78, 85, 82, 79, 88};
        manager.generateReport("Bob Smith", marks2, subjects2);
        
        // Compare students
        double alice_avg = StudentManager.calculateGPA(marks1);
        double bob_avg = StudentManager.calculateGPA(marks2);
        manager.compareStudents("Alice Johnson", alice_avg, "Bob Smith", bob_avg);
        
        // ============================
        // KEY CONCEPTS DEMONSTRATION
        // ============================
        System.out.println("🎯 KEY CONCEPTS ABOUT METHODS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ Methods define behavior of objects");
        System.out.println("✅ Instance methods need object to call");
        System.out.println("✅ Static methods called using class name");
        System.out.println("✅ Method overloading = same name, different parameters");
        System.out.println("✅ Return type can be void or any data type");
        System.out.println("✅ Parameters allow passing data to methods");
        System.out.println("✅ Methods promote code reusability");
        System.out.println("✅ Method signature = name + parameters");
        
        // ================================
        // BEST PRACTICES
        // ================================
        System.out.println("\n💡 METHOD BEST PRACTICES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("✅ Use descriptive method names (calculateGPA, not calc)");
        System.out.println("✅ Keep methods focused on single responsibility");
        System.out.println("✅ Use static methods for utility functions");
        System.out.println("✅ Validate parameters inside methods");
        System.out.println("✅ Use return statements effectively");
        System.out.println("✅ Document complex methods with comments");
        
        System.out.println("\n🎓 Ready to move to 04_Encapsulation.java!");
    }
}

/*
 * EXPECTED OUTPUT SAMPLE:
 * ═══════════════════════════════════════════════════════════
 *                       METHODS DEMO
 * ═══════════════════════════════════════════════════════════
 * 
 * 🧮 CALCULATOR METHODS DEMO:
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * 🧮 Calculator 'Scientific Pro' initialized!
 * === Calculator Information ===
 * Name: Scientific Pro
 * Type: Scientific Calculator
 * Status: Ready for calculations
 * ==============================
 * 
 * --- Basic Operations ---
 * ➕ Adding 15 + 25
 * Result: 40
 * ➖ Subtracting 50 - 20
 * Result: 30
 * 
 * ... and so on
 */