/*
 * ===============================================================
 *                    JAVA OOP CONCEPTS - PART 8
 *                       POLYMORPHISM
 * ===============================================================
 * 
 * WHAT IS POLYMORPHISM?
 * - Polymorphism means "many forms" (Greek: poly = many, morph = forms)
 * - It's the ability of a single interface to represent different underlying forms (data types)
 * - One of the four fundamental pillars of OOP
 * - Allows objects to be treated as instances of their parent class rather than their actual class
 * 
 * TYPES OF POLYMORPHISM:
 * 
 * 1. COMPILE-TIME POLYMORPHISM (Static Polymorphism)
 *    - Method Overloading
 *    - Constructor Overloading
 *    - Resolved during compilation
 * 
 * 2. RUNTIME POLYMORPHISM (Dynamic Polymorphism)
 *    - Method Overriding
 *    - Dynamic Method Dispatch
 *    - Resolved during runtime
 * 
 * KEY CONCEPTS:
 * - Dynamic Method Dispatch: JVM calls the appropriate method based on actual object type
 * - Late Binding: Method binding happens at runtime, not compile time
 * - Virtual Method Invocation: JVM uses virtual method table for method calls
 * - Upcasting: Child object referenced by parent type
 * - Downcasting: Parent reference cast back to child type
 */

// Example 1: Animal Kingdom - Runtime Polymorphism
abstract class Animal {
    protected String name;
    protected String habitat;
    protected String diet;
    
    public Animal(String name, String habitat, String diet) {
        this.name = name;
        this.habitat = habitat;
        this.diet = diet;
        System.out.println("🦁 Animal created: " + name);
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract void makeSound();
    public abstract void move();
    
    // Concrete methods that can be overridden
    public void eat() {
        System.out.println("🍽️ " + name + " is eating " + diet);
    }
    
    public void sleep() {
        System.out.println("😴 " + name + " is sleeping in " + habitat);
    }
    
    public void displayInfo() {
        System.out.println("Animal: " + name + ", Habitat: " + habitat + ", Diet: " + diet);
    }
    
    // Method that demonstrates polymorphic behavior
    public void performDailyRoutine() {
        System.out.println("\n--- " + name + "'s Daily Routine ---");
        makeSound();  // Polymorphic call
        move();       // Polymorphic call
        eat();
        sleep();
        System.out.println("--- End of Routine ---\n");
    }
}

class Lion extends Animal {
    private boolean isMale;
    
    public Lion(String name, boolean isMale) {
        super(name, "Savanna", "Meat");
        this.isMale = isMale;
        System.out.println("🦁 " + (isMale ? "Male" : "Female") + " lion created");
    }
    
    @Override
    public void makeSound() {
        System.out.println("🦁 ROAR! " + name + " roars powerfully across the savanna!");
    }
    
    @Override
    public void move() {
        System.out.println("🏃 " + name + " stalks through the grassland with stealth");
    }
    
    @Override
    public void eat() {
        System.out.println("🥩 " + name + " hunts and devours prey");
    }
    
    public void leadPride() {
        if (isMale) {
            System.out.println("👑 " + name + " leads the pride majestically");
        } else {
            System.out.println("🦁 " + name + " hunts for the pride");
        }
    }
}

class Elephant extends Animal {
    private double weight;
    
    public Elephant(String name, double weight) {
        super(name, "Grasslands", "Plants");
        this.weight = weight;
        System.out.println("🐘 Elephant weight: " + weight + " tons");
    }
    
    @Override
    public void makeSound() {
        System.out.println("🐘 TRUMPET! " + name + " trumpets loudly with trunk raised!");
    }
    
    @Override
    public void move() {
        System.out.println("🚶 " + name + " walks slowly but steadily, shaking the ground");
    }
    
    @Override
    public void eat() {
        System.out.println("🌿 " + name + " uses trunk to grab leaves and grass");
    }
    
    public void sprayWater() {
        System.out.println("💦 " + name + " sprays water with trunk to cool down");
    }
    
    public void chargeThreat() {
        System.out.println("⚡ " + name + " charges at threat with " + weight + " tons of force!");
    }
}

class Dolphin extends Animal {
    private String podName;
    
    public Dolphin(String name, String podName) {
        super(name, "Ocean", "Fish");
        this.podName = podName;
        System.out.println("🐬 Dolphin pod: " + podName);
    }
    
    @Override
    public void makeSound() {
        System.out.println("🐬 *CLICK CLICK* " + name + " communicates with echolocation!");
    }
    
    @Override
    public void move() {
        System.out.println("🌊 " + name + " swims gracefully through ocean waves");
    }
    
    @Override
    public void eat() {
        System.out.println("🐟 " + name + " catches fish with precision underwater");
    }
    
    public void performTricks() {
        System.out.println("🤸 " + name + " jumps and performs acrobatic tricks!");
    }
    
    public void echolocate() {
        System.out.println("📡 " + name + " uses echolocation to navigate");
    }
}

// Example 2: Vehicle System - Polymorphic Interface
interface Driveable {
    void accelerate();
    void brake();
    void steer(String direction);
    double getMaxSpeed();
}

interface Flyable {
    void takeOff();
    void land();
    void fly(int altitude);
}

abstract class Vehicle implements Driveable {
    protected String brand;
    protected String model;
    protected double currentSpeed;
    protected boolean engineRunning;
    
    public Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.currentSpeed = 0;
        this.engineRunning = false;
        System.out.println("🚗 Vehicle created: " + brand + " " + model);
    }
    
    public abstract void startEngine();
    public abstract void stopEngine();
    
    public void displayStatus() {
        System.out.println(brand + " " + model + " - Speed: " + currentSpeed + 
                          " mph, Engine: " + (engineRunning ? "ON" : "OFF"));
    }
    
    // Template method using polymorphism
    public void completeJourney() {
        System.out.println("\n🚗 Starting journey with " + brand + " " + model);
        startEngine();    // Polymorphic call
        accelerate();     // Polymorphic call
        steer("forward"); // Polymorphic call
        brake();          // Polymorphic call
        stopEngine();     // Polymorphic call
        System.out.println("✅ Journey completed safely!\n");
    }
}

class Car extends Vehicle {
    private int numberOfDoors;
    
    public Car(String brand, String model, int doors) {
        super(brand, model);
        this.numberOfDoors = doors;
        System.out.println("🚙 Car doors: " + doors);
    }
    
    @Override
    public void startEngine() {
        engineRunning = true;
        System.out.println("🔥 " + brand + " " + model + " car engine started smoothly");
    }
    
    @Override
    public void stopEngine() {
        engineRunning = false;
        currentSpeed = 0;
        System.out.println("🛑 " + brand + " " + model + " car engine stopped");
    }
    
    @Override
    public void accelerate() {
        if (engineRunning) {
            currentSpeed += 30;
            System.out.println("⚡ " + brand + " " + model + " accelerating to " + currentSpeed + " mph");
        }
    }
    
    @Override
    public void brake() {
        currentSpeed = Math.max(0, currentSpeed - 20);
        System.out.println("🛑 " + brand + " " + model + " braking, speed: " + currentSpeed + " mph");
    }
    
    @Override
    public void steer(String direction) {
        System.out.println("🎯 " + brand + " " + model + " steering " + direction);
    }
    
    @Override
    public double getMaxSpeed() {
        return 180.0; // mph
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    
    public Motorcycle(String brand, String model, boolean sidecar) {
        super(brand, model);
        this.hasSidecar = sidecar;
        System.out.println("🏍️ Motorcycle sidecar: " + (sidecar ? "Yes" : "No"));
    }
    
    @Override
    public void startEngine() {
        engineRunning = true;
        System.out.println("🔥 " + brand + " " + model + " motorcycle engine roars to life!");
    }
    
    @Override
    public void stopEngine() {
        engineRunning = false;
        currentSpeed = 0;
        System.out.println("🛑 " + brand + " " + model + " motorcycle engine stopped");
    }
    
    @Override
    public void accelerate() {
        if (engineRunning) {
            currentSpeed += 50; // Motorcycles accelerate faster
            System.out.println("🚀 " + brand + " " + model + " speeding up to " + currentSpeed + " mph");
        }
    }
    
    @Override
    public void brake() {
        currentSpeed = Math.max(0, currentSpeed - 30);
        System.out.println("🛑 " + brand + " " + model + " braking hard, speed: " + currentSpeed + " mph");
    }
    
    @Override
    public void steer(String direction) {
        System.out.println("🏍️ " + brand + " " + model + " leaning into " + direction + " turn");
    }
    
    @Override
    public double getMaxSpeed() {
        return 220.0; // mph
    }
    
    public void wheelie() {
        if (engineRunning && currentSpeed > 20) {
            System.out.println("🤸 " + brand + " " + model + " performing wheelie!");
        }
    }
}

class Airplane extends Vehicle implements Flyable {
    private int passengerCapacity;
    private boolean isAirborne;
    
    public Airplane(String brand, String model, int capacity) {
        super(brand, model);
        this.passengerCapacity = capacity;
        this.isAirborne = false;
        System.out.println("✈️ Airplane capacity: " + capacity + " passengers");
    }
    
    @Override
    public void startEngine() {
        engineRunning = true;
        System.out.println("🔥 " + brand + " " + model + " jet engines spooling up!");
    }
    
    @Override
    public void stopEngine() {
        engineRunning = false;
        currentSpeed = 0;
        System.out.println("🛑 " + brand + " " + model + " engines shut down");
    }
    
    @Override
    public void accelerate() {
        if (engineRunning) {
            currentSpeed += 100;
            System.out.println("🚀 " + brand + " " + model + " accelerating to " + currentSpeed + " mph");
        }
    }
    
    @Override
    public void brake() {
        currentSpeed = Math.max(0, currentSpeed - 50);
        System.out.println("🛑 " + brand + " " + model + " thrust reversers engaged, speed: " + currentSpeed + " mph");
    }
    
    @Override
    public void steer(String direction) {
        System.out.println("✈️ " + brand + " " + model + " banking " + direction);
    }
    
    @Override
    public double getMaxSpeed() {
        return 600.0; // mph
    }
    
    // Flyable interface methods
    @Override
    public void takeOff() {
        if (engineRunning && currentSpeed > 150) {
            isAirborne = true;
            System.out.println("🛫 " + brand + " " + model + " taking off into the sky!");
        } else {
            System.out.println("❌ Insufficient speed for takeoff!");
        }
    }
    
    @Override
    public void land() {
        if (isAirborne) {
            isAirborne = false;
            System.out.println("🛬 " + brand + " " + model + " landing safely on runway");
        }
    }
    
    @Override
    public void fly(int altitude) {
        if (isAirborne) {
            System.out.println("✈️ " + brand + " " + model + " flying at " + altitude + " feet");
        }
    }
}

// Example 3: Shape Calculator - Compile-time and Runtime Polymorphism
abstract class Shape {
    protected String name;
    protected String color;
    
    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }
    
    // Abstract methods for runtime polymorphism
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
    
    // Method overloading - compile-time polymorphism
    public void draw() {
        System.out.println("Drawing " + color + " " + name);
    }
    
    public void draw(String style) {
        System.out.println("Drawing " + color + " " + name + " with " + style + " style");
    }
    
    public void draw(String style, int thickness) {
        System.out.println("Drawing " + color + " " + name + " with " + style + 
                          " style and " + thickness + "px thickness");
    }
    
    // Template method using polymorphism
    public void displayComplete() {
        System.out.println("=== " + name + " Analysis ===");
        System.out.println("Color: " + color);
        System.out.println("Area: " + String.format("%.2f", calculateArea()));
        System.out.println("Perimeter: " + String.format("%.2f", calculatePerimeter()));
        draw(); // Polymorphic call
        System.out.println("========================\n");
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(String color, double radius) {
        super("Circle", color);
        this.radius = radius;
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
        System.out.println("⭕ Drawing circular " + color + " circle with radius " + radius);
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
        System.out.println("🔺 Drawing triangular " + color + " triangle");
    }
}

// Main class to demonstrate Polymorphism
public class Polymorphism {
    
    // Static method demonstrating polymorphic parameter passing
    public static void performAnimalActions(Animal animal) {
        System.out.println("\n🎭 Polymorphic Animal Actions:");
        animal.displayInfo();
        animal.performDailyRoutine();
    }
    
    public static void testVehicle(Vehicle vehicle) {
        System.out.println("\n🚗 Polymorphic Vehicle Test:");
        vehicle.displayStatus();
        vehicle.completeJourney();
    }
    
    public static void analyzeShape(Shape shape) {
        System.out.println("\n🔷 Polymorphic Shape Analysis:");
        shape.displayComplete();
    }
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                    POLYMORPHISM DEMO                    ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        // ===============================
        // RUNTIME POLYMORPHISM - ANIMALS
        // ===============================
        System.out.println("\n🦁 RUNTIME POLYMORPHISM - ANIMAL KINGDOM:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Create different animals
        Animal[] animals = {
            new Lion("Simba", true),
            new Elephant("Dumbo", 4.5),
            new Dolphin("Flipper", "Blue Ocean Pod"),
            new Lion("Nala", false)
        };
        
        System.out.println("\n--- Polymorphic Animal Array Processing ---");
        for (Animal animal : animals) {
            performAnimalActions(animal); // Same method, different behaviors
        }
        
        // ===============================
        // RUNTIME POLYMORPHISM - VEHICLES
        // ===============================
        System.out.println("\n🚗 RUNTIME POLYMORPHISM - VEHICLE SYSTEM:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Create different vehicles
        Vehicle[] vehicles = {
            new Car("Toyota", "Camry", 4),
            new Motorcycle("Harley", "Street 750", false),
            new Airplane("Boeing", "747", 400)
        };
        
        System.out.println("\n--- Polymorphic Vehicle Testing ---");
        for (Vehicle vehicle : vehicles) {
            testVehicle(vehicle); // Same interface, different implementations
        }
        
        // Special airplane operations
        System.out.println("\n--- Airplane-Specific Operations ---");
        Airplane plane = (Airplane) vehicles[2]; // Downcasting
        plane.startEngine();
        plane.accelerate();
        plane.accelerate(); // Build up speed
        plane.takeOff();
        plane.fly(35000);
        plane.land();
        
        // ===============================
        // COMPILE-TIME POLYMORPHISM
        // ===============================
        System.out.println("\n🔷 COMPILE-TIME POLYMORPHISM - METHOD OVERLOADING:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        Shape[] shapes = {
            new Circle("Red", 5.0),
            new Triangle("Blue", 3.0, 4.0, 5.0, 4.0, 3.0),
            new Circle("Green", 7.5)
        };
        
        System.out.println("\n--- Shape Drawing Overloading Examples ---");
        for (Shape shape : shapes) {
            // Method overloading examples (compile-time polymorphism)
            shape.draw();                        // No parameters
            shape.draw("solid");                 // One parameter
            shape.draw("dashed", 2);            // Two parameters
            System.out.println();
        }
        
        System.out.println("\n--- Polymorphic Shape Analysis ---");
        for (Shape shape : shapes) {
            analyzeShape(shape); // Runtime polymorphism
        }
        
        // ===============================
        // POLYMORPHIC COLLECTIONS
        // ===============================
        System.out.println("\n📊 POLYMORPHIC COLLECTIONS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Mixed collection demonstrating polymorphism
        java.util.ArrayList<Animal> animalCollection = new java.util.ArrayList<>();
        animalCollection.add(new Lion("King", true));
        animalCollection.add(new Elephant("Jumbo", 5.0));
        animalCollection.add(new Dolphin("Echo", "Pacific Pod"));
        
        System.out.println("\n--- Processing Mixed Animal Collection ---");
        for (Animal animal : animalCollection) {
            System.out.print("🎵 ");
            animal.makeSound(); // Each animal makes its own sound
        }
        
        // ===============================
        // DYNAMIC METHOD DISPATCH DEMO
        // ===============================
        System.out.println("\n⚡ DYNAMIC METHOD DISPATCH:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Reference type vs Object type demonstration
        Animal animalRef;
        
        System.out.println("\n--- Same Reference, Different Objects ---");
        
        animalRef = new Lion("Leo", true);
        System.out.println("Animal reference pointing to Lion:");
        animalRef.makeSound(); // Calls Lion's makeSound()
        
        animalRef = new Elephant("Ellie", 3.0);
        System.out.println("\nSame reference now pointing to Elephant:");
        animalRef.makeSound(); // Calls Elephant's makeSound()
        
        animalRef = new Dolphin("Splash", "Atlantic Pod");
        System.out.println("\nSame reference now pointing to Dolphin:");
        animalRef.makeSound(); // Calls Dolphin's makeSound()
        
        // ===============================
        // UPCASTING AND DOWNCASTING
        // ===============================
        System.out.println("\n🔄 UPCASTING AND DOWNCASTING:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Upcasting (implicit)
        Lion lion = new Lion("Mufasa", true);
        Animal upcastedAnimal = lion; // Upcasting - implicit
        
        System.out.println("\n--- Upcasting Example ---");
        upcastedAnimal.makeSound(); // Still calls Lion's method
        // upcastedAnimal.leadPride(); // ❌ This would cause compilation error
        
        // Downcasting (explicit)
        System.out.println("\n--- Downcasting Example ---");
        if (upcastedAnimal instanceof Lion) {
            Lion downcastedLion = (Lion) upcastedAnimal; // Downcasting - explicit
            downcastedLion.leadPride(); // Now we can call Lion-specific methods
            System.out.println("✅ Successful downcast to Lion");
        }
        
        // ============================
        // KEY CONCEPTS SUMMARY
        // ============================
        System.out.println("\n🎯 KEY POLYMORPHISM CONCEPTS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("🎭 RUNTIME POLYMORPHISM: Method calls resolved at runtime");
        System.out.println("⚡ DYNAMIC METHOD DISPATCH: JVM chooses correct method to call");
        System.out.println("🔄 METHOD OVERRIDING: Subclasses provide specific implementations");
        System.out.println("📝 METHOD OVERLOADING: Same name, different parameters");
        System.out.println("🔗 INTERFACE IMPLEMENTATION: Multiple classes, same contract");
        System.out.println("📊 POLYMORPHIC COLLECTIONS: Different objects in same collection");
        System.out.println("🎯 LATE BINDING: Method resolution happens at runtime");
        
        System.out.println("\n💡 POLYMORPHISM BENEFITS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("• Code reusability and flexibility");
        System.out.println("• Easier maintenance and extension");
        System.out.println("• Uniform interface for different objects");
        System.out.println("• Supports Open/Closed Principle");
        System.out.println("• Enables generic programming patterns");
        System.out.println("• Facilitates loose coupling");
        
        System.out.println("\n🎓 Ready to move to 09_Abstraction.java!");
    }
}

/*
 * POLYMORPHISM TYPES SUMMARY:
 * 
 * ╔══════════════════════╦═══════════════════════╦═══════════════════════╗
 * ║ Aspect               ║ Compile-time          ║ Runtime               ║
 * ║                      ║ (Static)              ║ (Dynamic)             ║
 * ╠══════════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ Examples             ║ Method Overloading    ║ Method Overriding     ║
 * ║                      ║ Constructor           ║ Interface             ║
 * ║                      ║ Overloading           ║ Implementation        ║
 * ╠══════════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ Resolution Time      ║ Compile time          ║ Runtime               ║
 * ╠══════════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ Binding Type         ║ Early Binding         ║ Late Binding          ║
 * ╠══════════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ Performance          ║ Faster                ║ Slightly slower       ║
 * ╠══════════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ Flexibility          ║ Less flexible         ║ More flexible         ║
 * ╚══════════════════════╩═══════════════════════╩═══════════════════════╝
 */