/*
 * ===============================================================
 *                    JAVA OOP CONCEPTS - PART 9
 *                        ABSTRACTION
 * ===============================================================
 * 
 * WHAT IS ABSTRACTION?
 * - Abstraction is the process of hiding implementation details and showing only functionality
 * - It focuses on what an object does rather than how it does it
 * - One of the four fundamental pillars of OOP (Encapsulation, Inheritance, Polymorphism, Abstraction)
 * - Provides a clear separation between interface and implementation
 * 
 * WAYS TO ACHIEVE ABSTRACTION IN JAVA:
 * 
 * 1. ABSTRACT CLASSES (0-100% abstraction)
 *    - Can have both abstract and concrete methods
 *    - Can have instance variables, constructors
 *    - Cannot be instantiated directly
 *    - Use 'abstract' keyword
 * 
 * 2. INTERFACES (100% abstraction)
 *    - All methods are abstract by default (until Java 8)
 *    - Can have constants (public static final)
 *    - Multiple inheritance support
 *    - Use 'interface' keyword
 * 
 * KEY CONCEPTS:
 * - Abstract Method: Method without implementation (body)
 * - Concrete Method: Method with implementation
 * - Cannot create objects of abstract classes
 * - Subclasses must implement all abstract methods
 * - Used for defining common structure/behavior
 */

// Example 1: Vehicle Abstract Class Hierarchy
abstract class Vehicle {
    // Instance variables (concrete)
    protected String brand;
    protected String model;
    protected int year;
    protected String color;
    protected boolean isEngineRunning;
    
    // Constructor in abstract class
    public Vehicle(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isEngineRunning = false;
        System.out.println("🚗 Abstract Vehicle created: " + brand + " " + model);
    }
    
    // Abstract methods (must be implemented by subclasses)
    public abstract void startEngine();
    public abstract void stopEngine();
    public abstract void accelerate();
    public abstract void brake();
    public abstract double getFuelEfficiency();
    public abstract String getVehicleType();
    
    // Concrete methods (inherited by all subclasses)
    public void displayBasicInfo() {
        System.out.println("=== Vehicle Information ===");
        System.out.println("Type: " + getVehicleType()); // Uses abstract method
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Engine: " + (isEngineRunning ? "Running ✅" : "Stopped 🛑"));
        System.out.println("Fuel Efficiency: " + getFuelEfficiency() + " mpg");
        System.out.println("===========================");
    }
    
    public void honk() {
        System.out.println("🔊 BEEP BEEP! " + brand + " " + model + " is honking!");
    }
    
    public int getAge() {
        return 2024 - year;
    }
    
    // Template method using abstract methods
    public void performMaintenanceCheck() {
        System.out.println("\n🔧 MAINTENANCE CHECK for " + brand + " " + model);
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        startEngine();          // Abstract method call
        System.out.println("✅ Engine test completed");
        
        accelerate();           // Abstract method call
        System.out.println("✅ Acceleration test completed");
        
        brake();               // Abstract method call
        System.out.println("✅ Brake test completed");
        
        stopEngine();          // Abstract method call
        System.out.println("✅ Engine shutdown test completed");
        
        System.out.println("🎯 Maintenance check finished for " + getVehicleType());
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
}

// Concrete class 1: Car
class Car extends Vehicle {
    private int numberOfDoors;
    private String transmissionType;
    
    public Car(String brand, String model, int year, String color, int doors, String transmission) {
        super(brand, model, year, color);
        this.numberOfDoors = doors;
        this.transmissionType = transmission;
        System.out.println("🚙 Car specific features: " + doors + " doors, " + transmission + " transmission");
    }
    
    // Implementing all abstract methods
    @Override
    public void startEngine() {
        if (!isEngineRunning) {
            isEngineRunning = true;
            System.out.println("🔥 " + brand + " " + model + " car engine started smoothly");
        } else {
            System.out.println("⚠️ Engine is already running");
        }
    }
    
    @Override
    public void stopEngine() {
        if (isEngineRunning) {
            isEngineRunning = false;
            System.out.println("🛑 " + brand + " " + model + " car engine stopped");
        } else {
            System.out.println("⚠️ Engine is already stopped");
        }
    }
    
    @Override
    public void accelerate() {
        if (isEngineRunning) {
            System.out.println("⚡ " + brand + " " + model + " car accelerating smoothly");
        } else {
            System.out.println("❌ Cannot accelerate - engine not running");
        }
    }
    
    @Override
    public void brake() {
        System.out.println("🛑 " + brand + " " + model + " car brakes applied gently");
    }
    
    @Override
    public double getFuelEfficiency() {
        return transmissionType.equals("Manual") ? 32.0 : 28.0; // Manual cars more efficient
    }
    
    @Override
    public String getVehicleType() {
        return "Car";
    }
    
    // Car-specific method
    public void openTrunk() {
        System.out.println("📦 " + brand + " " + model + " trunk opened");
    }
    
    @Override
    public void displayBasicInfo() {
        super.displayBasicInfo();
        System.out.println("--- Car Specific Info ---");
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Transmission: " + transmissionType);
        System.out.println("=========================\n");
    }
}

// Concrete class 2: Motorcycle
class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    private int engineCC;
    
    public Motorcycle(String brand, String model, int year, String color, boolean sidecar, int cc) {
        super(brand, model, year, color);
        this.hasSidecar = sidecar;
        this.engineCC = cc;
        System.out.println("🏍️ Motorcycle specs: " + cc + "cc engine, Sidecar: " + (sidecar ? "Yes" : "No"));
    }
    
    @Override
    public void startEngine() {
        if (!isEngineRunning) {
            isEngineRunning = true;
            System.out.println("🔥 " + brand + " " + model + " motorcycle engine ROARS to life!");
        } else {
            System.out.println("⚠️ Engine is already running");
        }
    }
    
    @Override
    public void stopEngine() {
        if (isEngineRunning) {
            isEngineRunning = false;
            System.out.println("🛑 " + brand + " " + model + " motorcycle engine stopped");
        } else {
            System.out.println("⚠️ Engine is already stopped");
        }
    }
    
    @Override
    public void accelerate() {
        if (isEngineRunning) {
            System.out.println("🚀 " + brand + " " + model + " motorcycle accelerating rapidly!");
        } else {
            System.out.println("❌ Cannot accelerate - engine not running");
        }
    }
    
    @Override
    public void brake() {
        System.out.println("🛑 " + brand + " " + model + " motorcycle braking hard");
    }
    
    @Override
    public double getFuelEfficiency() {
        double baseEfficiency = 45.0; // Motorcycles generally more efficient
        return hasSidecar ? baseEfficiency - 5.0 : baseEfficiency; // Sidecar reduces efficiency
    }
    
    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }
    
    public void performWheelstand() {
        if (isEngineRunning) {
            System.out.println("🤸 " + brand + " " + model + " performing epic wheelstand!");
        } else {
            System.out.println("❌ Start engine first to perform wheelstand");
        }
    }
    
    @Override
    public void displayBasicInfo() {
        super.displayBasicInfo();
        System.out.println("--- Motorcycle Specific Info ---");
        System.out.println("Engine CC: " + engineCC);
        System.out.println("Sidecar: " + (hasSidecar ? "Yes" : "No"));
        System.out.println("===============================\n");
    }
}

// Example 2: Shape Abstract Class
abstract class Shape {
    protected String name;
    protected String color;
    
    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
        System.out.println("🔷 Abstract Shape created: " + color + " " + name);
    }
    
    // Abstract methods for area and perimeter calculation
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    public abstract void draw();
    
    // Concrete method using abstract methods (Template Method Pattern)
    public void displayShapeInfo() {
        System.out.println("=== Shape Analysis ===");
        System.out.println("Shape: " + name);
        System.out.println("Color: " + color);
        System.out.println("Area: " + String.format("%.2f", calculateArea()));
        System.out.println("Perimeter: " + String.format("%.2f", calculatePerimeter()));
        draw(); // Abstract method call
        System.out.println("=====================\n");
    }
    
    // Concrete method
    public void changeColor(String newColor) {
        System.out.println("🎨 Changing " + name + " color from " + color + " to " + newColor);
        this.color = newColor;
    }
    
    // Template method demonstrating abstraction
    public void performCompleteAnalysis() {
        System.out.println("\n📊 COMPLETE SHAPE ANALYSIS");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        displayShapeInfo();
        
        if (calculateArea() > 50) {
            System.out.println("📏 This is a LARGE " + name);
        } else {
            System.out.println("📏 This is a SMALL " + name);
        }
        
        if (calculatePerimeter() > calculateArea()) {
            System.out.println("📐 Perimeter is greater than area");
        } else {
            System.out.println("📐 Area is greater than or equal to perimeter");
        }
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super("Circle", color);
        this.radius = radius;
        System.out.println("⭕ Circle radius: " + radius);
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void draw() {
        System.out.println("⭕ Drawing a perfect " + color + " circle with radius " + radius);
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(String color, double length, double width) {
        super("Rectangle", color);
        this.length = length;
        this.width = width;
        System.out.println("🔲 Rectangle dimensions: " + length + " x " + width);
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
    
    @Override
    public void draw() {
        System.out.println("🔲 Drawing a " + color + " rectangle " + length + " x " + width);
    }
}

class Triangle extends Shape {
    private double side1, side2, side3;
    private double base, height;
    
    public Triangle(String color, double side1, double side2, double side3, double base, double height) {
        super("Triangle", color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.base = base;
        this.height = height;
        System.out.println("🔺 Triangle sides: " + side1 + ", " + side2 + ", " + side3);
    }
    
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
    
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
    
    @Override
    public void draw() {
        System.out.println("🔺 Drawing a " + color + " triangle with base " + base + " and height " + height);
    }
}

// Example 3: Abstract Employee Management System
abstract class Employee {
    protected String employeeId;
    protected String name;
    protected String department;
    protected double baseSalary;
    
    public Employee(String id, String name, String department, double baseSalary) {
        this.employeeId = id;
        this.name = name;
        this.department = department;
        this.baseSalary = baseSalary;
        System.out.println("👨‍💼 Abstract Employee created: " + name + " (" + id + ")");
    }
    
    // Abstract methods - each employee type calculates differently
    public abstract double calculateSalary();
    public abstract double calculateBonus();
    public abstract String getEmployeeType();
    public abstract void performDuties();
    
    // Concrete methods
    public void displayBasicInfo() {
        System.out.println("=== Employee Information ===");
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Type: " + getEmployeeType());
        System.out.println("Department: " + department);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Total Salary: $" + String.format("%.2f", calculateSalary()));
        System.out.println("Bonus: $" + String.format("%.2f", calculateBonus()));
        System.out.println("============================");
    }
    
    public void clockIn() {
        System.out.println("🕐 " + name + " (" + getEmployeeType() + ") clocked in");
    }
    
    public void clockOut() {
        System.out.println("🕐 " + name + " (" + getEmployeeType() + ") clocked out");
    }
    
    // Template method
    public void workDay() {
        System.out.println("\n📅 " + name + "'s Work Day:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
        clockIn();
        performDuties(); // Abstract method - each employee type different
        clockOut();
        System.out.println("✅ Work day completed for " + getEmployeeType());
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
}

class FullTimeEmployee extends Employee {
    private double overtimeHours;
    private double overtimeRate;
    
    public FullTimeEmployee(String id, String name, String department, double baseSalary, double overtimeHours) {
        super(id, name, department, baseSalary);
        this.overtimeHours = overtimeHours;
        this.overtimeRate = 1.5; // 1.5x regular rate
        System.out.println("💼 Full-time employee with " + overtimeHours + " overtime hours");
    }
    
    @Override
    public double calculateSalary() {
        double regularPay = baseSalary;
        double overtimePay = (baseSalary / 160) * overtimeHours * overtimeRate; // Assuming 160 hours/month
        return regularPay + overtimePay;
    }
    
    @Override
    public double calculateBonus() {
        return baseSalary * 0.15; // 15% bonus for full-time
    }
    
    @Override
    public String getEmployeeType() {
        return "Full-Time Employee";
    }
    
    @Override
    public void performDuties() {
        System.out.println("💼 " + name + " working full 8-hour shift");
        System.out.println("📋 Managing projects and team responsibilities");
        System.out.println("⏰ Working " + overtimeHours + " overtime hours");
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;
    
    public PartTimeEmployee(String id, String name, String department, double hourlyRate, int hoursWorked) {
        super(id, name, department, 0); // No base salary for part-time
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        System.out.println("⏰ Part-time employee: $" + hourlyRate + "/hour, " + hoursWorked + " hours");
    }
    
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
    
    @Override
    public double calculateBonus() {
        return calculateSalary() * 0.05; // 5% bonus for part-time
    }
    
    @Override
    public String getEmployeeType() {
        return "Part-Time Employee";
    }
    
    @Override
    public void performDuties() {
        System.out.println("⏰ " + name + " working part-time " + hoursWorked + " hours");
        System.out.println("📋 Handling assigned tasks and supporting team");
    }
}

class Contractor extends Employee {
    private int projectsCompleted;
    private double ratePerProject;
    
    public Contractor(String id, String name, String department, double ratePerProject, int projects) {
        super(id, name, department, 0); // No base salary for contractors
        this.ratePerProject = ratePerProject;
        this.projectsCompleted = projects;
        System.out.println("🔧 Contractor: $" + ratePerProject + "/project, " + projects + " projects completed");
    }
    
    @Override
    public double calculateSalary() {
        return ratePerProject * projectsCompleted;
    }
    
    @Override
    public double calculateBonus() {
        // Bonus based on project completion efficiency
        return projectsCompleted > 5 ? ratePerProject * 0.5 : 0;
    }
    
    @Override
    public String getEmployeeType() {
        return "Contractor";
    }
    
    @Override
    public void performDuties() {
        System.out.println("🔧 " + name + " working on specialized contract projects");
        System.out.println("📈 Completed " + projectsCompleted + " projects this period");
        System.out.println("🎯 Focusing on project deliverables and deadlines");
    }
}

// Main class to demonstrate Abstraction
public class Abstraction {
    
    public static void testVehicle(Vehicle vehicle) {
        System.out.println("\n🚗 TESTING VEHICLE ABSTRACTION:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        vehicle.displayBasicInfo();
        vehicle.performMaintenanceCheck();
    }
    
    public static void analyzeShape(Shape shape) {
        System.out.println("🔷 ANALYZING SHAPE:");
        shape.performCompleteAnalysis();
    }
    
    public static void processEmployee(Employee employee) {
        System.out.println("👨‍💼 PROCESSING EMPLOYEE:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
        employee.displayBasicInfo();
        employee.workDay();
    }
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                    ABSTRACTION DEMO                     ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        // ===============================
        // ABSTRACT VEHICLE SYSTEM
        // ===============================
        System.out.println("\n🚗 ABSTRACT VEHICLE SYSTEM:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Cannot instantiate abstract class
        // Vehicle vehicle = new Vehicle(); // ❌ This would cause compilation error
        
        // Create concrete implementations
        Vehicle car = new Car("Toyota", "Camry", 2022, "Blue", 4, "Automatic");
        Vehicle motorcycle = new Motorcycle("Harley-Davidson", "Street 750", 2021, "Black", false, 750);
        
        // Test polymorphic behavior with abstract class reference
        testVehicle(car);
        testVehicle(motorcycle);
        
        // ===============================
        // ABSTRACT SHAPE SYSTEM
        // ===============================
        System.out.println("\n🔷 ABSTRACT SHAPE SYSTEM:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        Shape[] shapes = {
            new Circle("Red", 7.5),
            new Rectangle("Green", 12.0, 8.0),
            new Triangle("Blue", 5.0, 6.0, 7.0, 6.0, 4.0)
        };
        
        for (Shape shape : shapes) {
            analyzeShape(shape);
        }
        
        // ===============================
        // ABSTRACT EMPLOYEE SYSTEM
        // ===============================
        System.out.println("\n👨‍💼 ABSTRACT EMPLOYEE SYSTEM:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        Employee[] employees = {
            new FullTimeEmployee("FT001", "Alice Johnson", "Engineering", 8000.0, 10.0),
            new PartTimeEmployee("PT001", "Bob Smith", "Marketing", 25.0, 80),
            new Contractor("CT001", "Carol Davis", "Design", 1500.0, 6)
        };
        
        System.out.println("\n--- Processing All Employees ---");
        for (Employee employee : employees) {
            processEmployee(employee);
        }
        
        // Calculate total payroll
        System.out.println("💰 PAYROLL SUMMARY:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━");
        double totalPayroll = 0;
        for (Employee employee : employees) {
            double totalPay = employee.calculateSalary() + employee.calculateBonus();
            totalPayroll += totalPay;
            System.out.println(employee.name + " (" + employee.getEmployeeType() + "): $" + 
                             String.format("%.2f", totalPay));
        }
        System.out.println("━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Total Payroll: $" + String.format("%.2f", totalPayroll));
        
        // ============================
        // ABSTRACTION BENEFITS DEMO
        // ============================
        System.out.println("\n🎯 ABSTRACTION BENEFITS DEMONSTRATION:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ HIDING COMPLEXITY:");
        System.out.println("   • Car.startEngine() hides complex engine starting process");
        System.out.println("   • Shape.calculateArea() hides geometric calculations");
        System.out.println("   • Employee.calculateSalary() hides payroll complexities");
        
        System.out.println("\n✅ CONSISTENT INTERFACE:");
        System.out.println("   • All vehicles have startEngine(), stopEngine(), accelerate()");
        System.out.println("   • All shapes have calculateArea(), calculatePerimeter()");
        System.out.println("   • All employees have calculateSalary(), performDuties()");
        
        System.out.println("\n✅ FLEXIBILITY & EXTENSIBILITY:");
        System.out.println("   • Can add new vehicle types (Truck, Bus) easily");
        System.out.println("   • Can add new shapes (Pentagon, Hexagon) easily");
        System.out.println("   • Can add new employee types (Intern, Manager) easily");
        
        // ============================
        // KEY CONCEPTS SUMMARY
        // ============================
        System.out.println("\n🎯 KEY ABSTRACTION CONCEPTS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("🎭 HIDING IMPLEMENTATION: Focus on 'what' not 'how'");
        System.out.println("🏗️ ABSTRACT CLASSES: Partial abstraction with concrete methods");
        System.out.println("📋 TEMPLATE METHODS: Define algorithm structure, subclasses fill details");
        System.out.println("🔄 POLYMORPHISM: Same interface, different implementations");
        System.out.println("🎨 DESIGN FLEXIBILITY: Easy to extend and modify");
        System.out.println("🛡️ CODE SAFETY: Cannot instantiate abstract classes directly");
        
        System.out.println("\n💡 ABSTRACTION BEST PRACTICES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("• Use abstract classes for IS-A relationships with shared code");
        System.out.println("• Define clear, focused abstract methods");
        System.out.println("• Provide meaningful concrete methods in abstract class");
        System.out.println("• Use template method pattern for common algorithms");
        System.out.println("• Document abstract method contracts clearly");
        System.out.println("• Consider interfaces for pure contracts (next topic!)");
        
        System.out.println("\n🎓 Ready to move to 10_Interfaces.java!");
    }
}

/*
 * ABSTRACTION vs ENCAPSULATION:
 * 
 * ╔═══════════════════╦═══════════════════════╦═══════════════════════╗
 * ║ Aspect            ║ Abstraction           ║ Encapsulation         ║
 * ╠═══════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ Purpose           ║ Hide complexity       ║ Hide data             ║
 * ║                   ║ Show functionality    ║ Control access        ║
 * ╠═══════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ Focus             ║ Design level          ║ Implementation level  ║
 * ╠═══════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ Implementation    ║ Abstract classes      ║ Private variables     ║
 * ║                   ║ Interfaces            ║ Getter/Setter methods ║
 * ╠═══════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ Level             ║ Class/Interface level ║ Variable/Method level ║
 * ╚═══════════════════╩═══════════════════════╩═══════════════════════╝
 */