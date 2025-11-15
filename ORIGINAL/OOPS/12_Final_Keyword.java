/*
 * ===============================================================
 *                    JAVA OOP CONCEPTS - PART 12
 *                       FINAL KEYWORD
 * ===============================================================
 * 
 * WHAT IS FINAL KEYWORD?
 * - 'final' is a keyword in Java that imposes restrictions on classes, methods, and variables
 * - It prevents modification, inheritance, or overriding depending on where it's used
 * - Promotes immutability and security in object-oriented design
 * - Helps in optimization by the JVM compiler
 * 
 * USES OF FINAL KEYWORD:
 * 1. Final Variables - Cannot be reassigned once initialized (Constants)
 * 2. Final Methods - Cannot be overridden by subclasses
 * 3. Final Classes - Cannot be extended/subclassed
 * 4. Final Parameters - Method parameters cannot be modified
 * 
 * KEY CHARACTERISTICS:
 * - Compile-time enforcement of immutability
 * - Memory optimization opportunities
 * - Thread-safety for final variables
 * - Clear indication of design intent
 */

// Example 1: Final Variables (Constants and Immutable Objects)
class MathConstants {
    // Final static variables (Class Constants)
    public static final double PI = 3.14159265359;
    public static final double E = 2.71828182846;
    public static final int MAX_PRECISION = 15;
    public static final String LIBRARY_NAME = "Advanced Math Library";
    
    // Final instance variables
    private final String version;
    private final long creationTime;
    private final int maxOperations;
    
    // Final variable with complex initialization
    private final java.util.List<String> supportedOperations;
    
    public MathConstants(String version, int maxOps) {
        this.version = version; // Final variable initialized in constructor
        this.creationTime = System.currentTimeMillis();
        this.maxOperations = maxOps;
        
        // Final reference - list reference cannot change, but contents can be modified
        this.supportedOperations = new java.util.ArrayList<>();
        supportedOperations.add("Addition");
        supportedOperations.add("Subtraction");
        supportedOperations.add("Multiplication");
        supportedOperations.add("Division");
        
        System.out.println("🧮 MathConstants v" + version + " initialized");
    }
    
    // Method with final parameters
    public double calculateCircleArea(final double radius) {
        // radius = radius + 1; // ❌ Compilation error - cannot modify final parameter
        
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        
        System.out.println("⭕ Calculating area for radius: " + radius);
        return PI * radius * radius;
    }
    
    public double calculateCompoundInterest(final double principal, final double rate, final int time) {
        // All parameters are final - cannot be modified within method
        System.out.println("💰 Calculating compound interest:");
        System.out.println("   Principal: $" + principal);
        System.out.println("   Rate: " + rate + "%");
        System.out.println("   Time: " + time + " years");
        
        double amount = principal * Math.pow(1 + rate/100, time);
        return amount - principal;
    }
    
    // Getter methods for final variables
    public String getVersion() {
        return version; // Final variable can be read
    }
    
    public long getCreationTime() {
        return creationTime;
    }
    
    public int getMaxOperations() {
        return maxOperations;
    }
    
    // Method demonstrating final reference behavior
    public void demonstrateFinalReference() {
        System.out.println("\n📝 FINAL REFERENCE DEMONSTRATION:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ Can modify contents of final reference:");
        supportedOperations.add("Power");
        supportedOperations.add("Square Root");
        
        System.out.println("Current operations: " + supportedOperations);
        
        // supportedOperations = new ArrayList<>(); // ❌ Cannot reassign final reference
        System.out.println("❌ Cannot reassign final reference to new object");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
    
    public void displayConstants() {
        System.out.println("📊 MATHEMATICAL CONSTANTS:");
        System.out.println("PI = " + PI);
        System.out.println("E = " + E);
        System.out.println("Max Precision = " + MAX_PRECISION);
        System.out.println("Library = " + LIBRARY_NAME);
        System.out.println("Version = " + version);
        System.out.println("Max Operations = " + maxOperations);
    }
}

// Example 2: Final Methods (Cannot be overridden)
class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    
    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        System.out.println("🚗 Vehicle created: " + brand + " " + model);
    }
    
    // Final method - cannot be overridden by subclasses
    public final void startEngine() {
        System.out.println("🔥 " + brand + " " + model + " engine starting...");
        performEngineChecks(); // Calls non-final method
        System.out.println("✅ Engine started successfully!");
    }
    
    // Another final method with complex logic
    public final String getVehicleIdentification() {
        return brand + "-" + model + "-" + year + "-" + System.currentTimeMillis();
    }
    
    // Non-final method - can be overridden
    public void accelerate() {
        System.out.println("⚡ " + brand + " " + model + " is accelerating");
    }
    
    // Protected non-final method for template pattern
    protected void performEngineChecks() {
        System.out.println("🔍 Performing basic engine checks...");
    }
    
    public void displayInfo() {
        System.out.println("Vehicle: " + brand + " " + model + " (" + year + ")");
        System.out.println("ID: " + getVehicleIdentification());
    }
}

class Car extends Vehicle {
    private int numberOfDoors;
    
    public Car(String brand, String model, int year, int doors) {
        super(brand, model, year);
        this.numberOfDoors = doors;
        System.out.println("🚙 Car with " + doors + " doors");
    }
    
    // Cannot override final method from parent
    // public void startEngine() { } // ❌ Compilation error
    
    // Can override non-final methods
    @Override
    public void accelerate() {
        System.out.println("🏎️ " + brand + " " + model + " car accelerating smoothly");
    }
    
    @Override
    protected void performEngineChecks() {
        System.out.println("🔍 Performing car-specific engine diagnostics...");
        System.out.println("🔧 Checking oil, coolant, and battery");
    }
    
    public void openTrunk() {
        System.out.println("📦 " + brand + " " + model + " trunk opened");
    }
}

class SportsCar extends Car {
    private boolean hasTurbo;
    
    public SportsCar(String brand, String model, int year, int doors, boolean turbo) {
        super(brand, model, year, doors);
        this.hasTurbo = turbo;
        System.out.println("🏎️ Sports car with turbo: " + turbo);
    }
    
    // Inherits final startEngine() method - cannot override it
    
    @Override
    public void accelerate() {
        if (hasTurbo) {
            System.out.println("🚀 " + brand + " " + model + " TURBO acceleration!");
        } else {
            System.out.println("🏎️ " + brand + " " + model + " sports acceleration!");
        }
    }
    
    @Override
    protected void performEngineChecks() {
        super.performEngineChecks();
        System.out.println("🏁 Checking turbo and performance systems");
    }
}

// Example 3: Final Classes (Cannot be extended)
final class ImmutablePoint {
    private final double x;
    private final double y;
    private final String label;
    
    public ImmutablePoint(double x, double y, String label) {
        this.x = x;
        this.y = y;
        this.label = label;
        System.out.println("📍 Immutable point created: " + label + " (" + x + ", " + y + ")");
    }
    
    // Getter methods (no setters for immutability)
    public double getX() { return x; }
    public double getY() { return y; }
    public String getLabel() { return label; }
    
    // Method to create new point (since this one is immutable)
    public ImmutablePoint move(double deltaX, double deltaY) {
        return new ImmutablePoint(x + deltaX, y + deltaY, label + "'");
    }
    
    public double distanceFrom(ImmutablePoint other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
    @Override
    public String toString() {
        return label + "(" + x + ", " + y + ")";
    }
    
    // Final method in final class
    public final void displayCoordinates() {
        System.out.println("📍 Point " + label + " is at coordinates (" + x + ", " + y + ")");
    }
}

// Cannot extend final class
// class ExtendedPoint extends ImmutablePoint { } // ❌ Compilation error

// Example 4: Utility class demonstrating final usage patterns
final class SecurityUtils {
    // Final constants for security configuration
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final int MAX_LOGIN_ATTEMPTS = 3;
    public static final long SESSION_TIMEOUT_MS = 1800000; // 30 minutes
    public static final String ENCRYPTION_ALGORITHM = "AES";
    
    // Private constructor prevents instantiation
    private SecurityUtils() {
        throw new AssertionError("Utility class cannot be instantiated");
    }
    
    // Final static method with final parameters
    public static final boolean validatePassword(final String password) {
        if (password == null) {
            System.out.println("❌ Password cannot be null");
            return false;
        }
        
        final int length = password.length();
        
        if (length < MIN_PASSWORD_LENGTH) {
            System.out.println("❌ Password too short (minimum " + MIN_PASSWORD_LENGTH + " characters)");
            return false;
        }
        
        // Check for various password criteria
        final boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
        final boolean hasLower = password.chars().anyMatch(Character::isLowerCase);
        final boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        final boolean hasSpecial = password.chars().anyMatch(ch -> "!@#$%^&*".indexOf(ch) >= 0);
        
        if (hasUpper && hasLower && hasDigit && hasSpecial) {
            System.out.println("✅ Password meets all security requirements");
            return true;
        } else {
            System.out.println("❌ Password must contain uppercase, lowercase, digit, and special character");
            return false;
        }
    }
    
    public static final String generateSecureId(final String prefix) {
        final long timestamp = System.currentTimeMillis();
        final int random = (int) (Math.random() * 10000);
        return prefix + "-" + timestamp + "-" + random;
    }
    
    public static final void displaySecurityConfig() {
        System.out.println("\n🔒 SECURITY CONFIGURATION:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Min Password Length: " + MIN_PASSWORD_LENGTH);
        System.out.println("Max Login Attempts: " + MAX_LOGIN_ATTEMPTS);
        System.out.println("Session Timeout: " + (SESSION_TIMEOUT_MS / 60000) + " minutes");
        System.out.println("Encryption: " + ENCRYPTION_ALGORITHM);
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }
}

// Example 5: Final in interfaces and inheritance
interface Shape {
    // Interface methods are implicitly public and abstract
    double calculateArea();
    double calculatePerimeter();
    
    // Default method can be final (Java 8+)
    default final void displayShapeType() {
        System.out.println("🔷 This is a geometric shape");
    }
}

class Circle implements Shape {
    private final double radius; // Final instance variable
    
    public Circle(final double radius) {
        this.radius = radius;
        System.out.println("⭕ Circle created with radius: " + radius);
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    public final double getRadius() {
        return radius;
    }
    
    // Cannot override final default method from interface
    // public void displayShapeType() { } // ❌ Compilation error
}

// Main class to demonstrate Final Keyword
public class Final_Keyword {
    
    // Final static variable at class level
    private static final String DEMO_VERSION = "1.0";
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                   FINAL KEYWORD DEMO v" + DEMO_VERSION + "                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        // ===============================
        // FINAL VARIABLES DEMONSTRATION
        // ===============================
        System.out.println("\n📊 FINAL VARIABLES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━");
        
        MathConstants mathLib = new MathConstants("2.1", 1000);
        mathLib.displayConstants();
        
        // Using final parameters in methods
        double area = mathLib.calculateCircleArea(7.5);
        System.out.println("Circle area: " + String.format("%.2f", area));
        
        double interest = mathLib.calculateCompoundInterest(10000, 5.5, 3);
        System.out.println("Compound interest: $" + String.format("%.2f", interest));
        
        // Demonstrate final reference behavior
        mathLib.demonstrateFinalReference();
        
        // ===============================
        // FINAL METHODS DEMONSTRATION
        // ===============================
        System.out.println("\n🚗 FINAL METHODS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━");
        
        Vehicle[] vehicles = {
            new Car("Toyota", "Camry", 2022, 4),
            new SportsCar("Ferrari", "488 GTB", 2023, 2, true)
        };
        
        for (Vehicle vehicle : vehicles) {
            System.out.println("\n--- Testing " + vehicle.getClass().getSimpleName() + " ---");
            vehicle.displayInfo();
            vehicle.startEngine(); // Final method - same implementation for all
            vehicle.accelerate();   // Non-final method - can be overridden
            System.out.println();
        }
        
        // ===============================
        // FINAL CLASSES DEMONSTRATION
        // ===============================
        System.out.println("\n📍 FINAL CLASSES (IMMUTABLE OBJECTS):");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        ImmutablePoint point1 = new ImmutablePoint(3.0, 4.0, "A");
        ImmutablePoint point2 = new ImmutablePoint(6.0, 8.0, "B");
        
        point1.displayCoordinates();
        point2.displayCoordinates();
        
        // Create new point (immutable - cannot modify existing)
        ImmutablePoint point3 = point1.move(2.0, 3.0);
        System.out.println("Original point: " + point1);
        System.out.println("New point after move: " + point3);
        
        double distance = point1.distanceFrom(point2);
        System.out.println("Distance between " + point1.getLabel() + " and " + 
                          point2.getLabel() + ": " + String.format("%.2f", distance));
        
        // ===============================
        // SECURITY UTILITY DEMONSTRATION
        // ===============================
        System.out.println("\n🔒 SECURITY UTILITIES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━");
        
        SecurityUtils.displaySecurityConfig();
        
        // Test password validation with final parameters
        String[] testPasswords = {
            "weak",
            "StrongPass123!",
            "NoSpecialChar123",
            "ALLUPPERCASE123!",
            "alllowercase123!"
        };
        
        for (String password : testPasswords) {
            System.out.println("\nTesting password: '" + password + "'");
            boolean isValid = SecurityUtils.validatePassword(password);
            System.out.println("Result: " + (isValid ? "VALID ✅" : "INVALID ❌"));
        }
        
        // Generate secure IDs
        System.out.println("\n🆔 Generated secure IDs:");
        for (int i = 1; i <= 3; i++) {
            String id = SecurityUtils.generateSecureId("USER");
            System.out.println("ID " + i + ": " + id);
        }
        
        // ===============================
        // INTERFACE WITH FINAL DEFAULT METHOD
        // ===============================
        System.out.println("\n🔷 INTERFACE FINAL METHODS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        Circle circle = new Circle(5.0);
        circle.displayShapeType(); // Final default method from interface
        
        System.out.println("Circle area: " + String.format("%.2f", circle.calculateArea()));
        System.out.println("Circle perimeter: " + String.format("%.2f", circle.calculatePerimeter()));
        System.out.println("Circle radius: " + circle.getRadius());
        
        // ============================
        // FINAL KEYWORD BENEFITS
        // ============================
        System.out.println("\n💡 FINAL KEYWORD BENEFITS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("🔒 IMMUTABILITY: Final variables cannot be reassigned");
        System.out.println("🛡️ SECURITY: Final methods cannot be overridden maliciously");
        System.out.println("🏗️ DESIGN: Final classes ensure no unwanted inheritance");
        System.out.println("⚡ OPTIMIZATION: JVM can optimize final members");
        System.out.println("🧵 THREAD-SAFETY: Final variables are inherently thread-safe");
        System.out.println("📝 DOCUMENTATION: Clear indication of design intent");
        
        // ============================
        // FINAL vs OTHER CONCEPTS
        // ============================
        System.out.println("\n🔄 FINAL vs OTHER CONCEPTS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("🆚 FINAL vs STATIC:");
        System.out.println("   • final: Cannot be changed after initialization");
        System.out.println("   • static: Belongs to class, not instance");
        System.out.println("   • Can be used together: static final (constants)");
        
        System.out.println("\n🆚 FINAL vs ABSTRACT:");
        System.out.println("   • final: Cannot be overridden/extended");
        System.out.println("   • abstract: Must be overridden/extended");
        System.out.println("   • Cannot be used together (contradictory)");
        
        // ============================
        // BEST PRACTICES
        // ============================
        System.out.println("\n💡 FINAL KEYWORD BEST PRACTICES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ USE FINAL FOR:");
        System.out.println("   • Constants that should never change");
        System.out.println("   • Method parameters to prevent accidental modification");
        System.out.println("   • Methods that implement critical security or business logic");
        System.out.println("   • Classes designed to be immutable (like String)");
        System.out.println("   • Variables that are initialized once and never changed");
        
        System.out.println("\n⚠️ CONSIDER CAREFULLY:");
        System.out.println("   • Final classes prevent inheritance (reduces extensibility)");
        System.out.println("   • Final methods prevent polymorphism in subclasses");
        System.out.println("   • Overuse can make code inflexible");
        System.out.println("   • Balance between immutability and flexibility");
        
        System.out.println("\n🎓 Ready to move to 13_Super_Keyword.java!");
    }
}

/*
 * FINAL KEYWORD SUMMARY:
 * 
 * ╔═══════════════════╦═══════════════════════╦═══════════════════════╗
 * ║ Usage             ║ Effect                ║ Example               ║
 * ╠═══════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ final variable    ║ Cannot be reassigned  ║ final int x = 10;     ║
 * ╠═══════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ final method      ║ Cannot be overridden  ║ final void method()   ║
 * ╠═══════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ final class       ║ Cannot be extended    ║ final class MyClass   ║
 * ╠═══════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ final parameter   ║ Cannot be modified    ║ void method(final x)  ║
 * ╠═══════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ static final      ║ Class constant        ║ static final PI=3.14  ║
 * ╚═══════════════════╩═══════════════════════╩═══════════════════════╝
 */