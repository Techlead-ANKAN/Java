/*
 * ===============================================================
 *                    JAVA OOP CONCEPTS - PART 6
 *                        INHERITANCE
 * ===============================================================
 * 
 * WHAT IS INHERITANCE?
 * - Inheritance is a mechanism where a new class (child/subclass) acquires properties 
 *   and behaviors of an existing class (parent/superclass)
 * - It's one of the four fundamental OOP principles
 * - Promotes code reusability and establishes "IS-A" relationship
 * - Java uses 'extends' keyword for inheritance
 * 
 * TYPES OF INHERITANCE:
 * 1. Single Inheritance - One child class extends one parent class
 * 2. Multilevel Inheritance - Chain of inheritance (A → B → C)
 * 3. Hierarchical Inheritance - Multiple children from one parent
 * 4. Multiple Inheritance - NOT supported in Java (use interfaces)
 * 5. Hybrid Inheritance - Combination of above types
 * 
 * KEY TERMS:
 * - Superclass/Parent Class: The class being inherited from
 * - Subclass/Child Class: The class that inherits
 * - IS-A Relationship: Child IS-A type of Parent
 * - Code Reusability: Reuse existing code without duplication
 * 
 * INHERITANCE SYNTAX:
 * class ParentClass {
 *     // parent class members
 * }
 * 
 * class ChildClass extends ParentClass {
 *     // child class members + inherited members
 * }
 */

// Example 1: Single Inheritance - Vehicle Hierarchy
class Vehicle {
    // Protected members can be accessed by subclasses
    protected String brand;
    protected String model;
    protected int year;
    protected String color;
    protected double price;
    protected boolean isRunning;
    
    // Constructor
    public Vehicle(String brand, String model, int year, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.isRunning = false;
        System.out.println("🚗 Vehicle created: " + brand + " " + model);
    }
    
    // Methods that can be inherited
    public void startEngine() {
        if (!isRunning) {
            isRunning = true;
            System.out.println("🔥 " + brand + " " + model + " engine started!");
        } else {
            System.out.println("⚡ Engine is already running!");
        }
    }
    
    public void stopEngine() {
        if (isRunning) {
            isRunning = false;
            System.out.println("🛑 " + brand + " " + model + " engine stopped!");
        } else {
            System.out.println("😴 Engine is already stopped!");
        }
    }
    
    public void displayInfo() {
        System.out.println("=== Vehicle Information ===");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Color: " + color);
        System.out.println("Price: $" + price);
        System.out.println("Status: " + (isRunning ? "Running 🟢" : "Stopped 🔴"));
        System.out.println("===========================");
    }
    
    public void honk() {
        System.out.println("🔊 BEEP BEEP! " + brand + " is honking!");
    }
    
    public int calculateAge() {
        return 2024 - year;
    }
}

// Child class 1: Car inherits from Vehicle
class Car extends Vehicle {
    // Additional properties specific to Car
    private int numberOfDoors;
    private String fuelType;
    private boolean hasAirConditioning;
    
    // Constructor - must call parent constructor
    public Car(String brand, String model, int year, String color, double price, 
               int doors, String fuel, boolean ac) {
        // Call parent constructor using super()
        super(brand, model, year, color, price);
        this.numberOfDoors = doors;
        this.fuelType = fuel;
        this.hasAirConditioning = ac;
        System.out.println("🚙 Car features added: " + doors + " doors, " + fuel + " fuel");
    }
    
    // Car-specific methods
    public void openTrunk() {
        System.out.println("📦 " + brand + " " + model + " trunk opened!");
    }
    
    public void closeTrunk() {
        System.out.println("📦 " + brand + " " + model + " trunk closed!");
    }
    
    public void turnOnAC() {
        if (hasAirConditioning) {
            System.out.println("❄️ Air conditioning turned ON!");
        } else {
            System.out.println("❌ This car doesn't have air conditioning!");
        }
    }
    
    // Override parent method to add car-specific information
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method first
        System.out.println("--- Car Specific Info ---");
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Air Conditioning: " + (hasAirConditioning ? "Yes" : "No"));
        System.out.println("========================");
    }
    
    // Car-specific honk sound
    @Override
    public void honk() {
        System.out.println("🚗 HONK HONK! " + brand + " car is honking!");
    }
}

// Child class 2: Motorcycle inherits from Vehicle  
class Motorcycle extends Vehicle {
    private boolean hasSidecar;
    private String engineType;
    
    public Motorcycle(String brand, String model, int year, String color, double price,
                     boolean sidecar, String engineType) {
        super(brand, model, year, color, price);
        this.hasSidecar = sidecar;
        this.engineType = engineType;
        System.out.println("🏍️ Motorcycle features: " + engineType + " engine");
    }
    
    public void performWheelstand() {
        if (isRunning) {
            System.out.println("🤸 " + brand + " " + model + " performing wheelstand!");
        } else {
            System.out.println("❌ Start the engine first to perform wheelstand!");
        }
    }
    
    public void attachSidecar() {
        if (!hasSidecar) {
            hasSidecar = true;
            System.out.println("🛵 Sidecar attached to " + brand + " " + model);
        } else {
            System.out.println("ℹ️ Sidecar already attached!");
        }
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("--- Motorcycle Specific Info ---");
        System.out.println("Engine Type: " + engineType);
        System.out.println("Sidecar: " + (hasSidecar ? "Yes" : "No"));
        System.out.println("==============================");
    }
    
    @Override
    public void honk() {
        System.out.println("🏍️ BEEP BEEP! " + brand + " motorcycle is honking!");
    }
}

// Example 2: Multilevel Inheritance
class Animal {
    protected String name;
    protected String species;
    protected int age;
    
    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
        System.out.println("🦁 Animal created: " + name + " (" + species + ")");
    }
    
    public void eat() {
        System.out.println("🍽️ " + name + " is eating...");
    }
    
    public void sleep() {
        System.out.println("😴 " + name + " is sleeping...");
    }
    
    public void makeSound() {
        System.out.println("🔊 " + name + " makes a sound!");
    }
    
    public void displayInfo() {
        System.out.println("Animal: " + name + ", Species: " + species + ", Age: " + age);
    }
}

class Mammal extends Animal {
    protected boolean hasFur;
    protected String bloodType;
    
    public Mammal(String name, String species, int age, boolean hasFur) {
        super(name, species, age);
        this.hasFur = hasFur;
        this.bloodType = "Warm-blooded";
        System.out.println("🐾 Mammal characteristics added");
    }
    
    public void giveBirth() {
        System.out.println("👶 " + name + " gives birth to live young!");
    }
    
    public void produceMilk() {
        System.out.println("🥛 " + name + " produces milk for offspring!");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fur: " + (hasFur ? "Yes" : "No") + ", Blood: " + bloodType);
    }
}

class Dog extends Mammal {
    private String breed;
    private boolean isTrained;
    
    public Dog(String name, int age, String breed, boolean trained) {
        super(name, "Canis lupus", age, true);
        this.breed = breed;
        this.isTrained = trained;
        System.out.println("🐕 Dog breed: " + breed);
    }
    
    public void bark() {
        System.out.println("🐕 WOOF WOOF! " + name + " is barking!");
    }
    
    public void wagTail() {
        System.out.println("🐕 " + name + " is wagging tail happily!");
    }
    
    public void fetch() {
        if (isTrained) {
            System.out.println("🎾 " + name + " fetches the ball!");
        } else {
            System.out.println("🤔 " + name + " doesn't know how to fetch yet!");
        }
    }
    
    @Override
    public void makeSound() {
        bark(); // Dog-specific sound
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed + ", Trained: " + (isTrained ? "Yes" : "No"));
    }
}

// Example 3: Hierarchical Inheritance - Multiple children from one parent
class Shape {
    protected String color;
    protected boolean filled;
    
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        System.out.println("🔷 Shape created with color: " + color);
    }
    
    public void displayProperties() {
        System.out.println("Color: " + color + ", Filled: " + filled);
    }
    
    // Abstract-like method to be overridden
    public double calculateArea() {
        return 0.0;
    }
    
    public double calculatePerimeter() {
        return 0.0;
    }
}

class Circle extends Shape {
    private double radius;
    
    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
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
    
    public void displayCircleInfo() {
        System.out.println("=== Circle Information ===");
        displayProperties();
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + String.format("%.2f", calculateArea()));
        System.out.println("Perimeter: " + String.format("%.2f", calculatePerimeter()));
        System.out.println("=========================");
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(String color, boolean filled, double length, double width) {
        super(color, filled);
        this.length = length;
        this.width = width;
        System.out.println("🔲 Rectangle created: " + length + " x " + width);
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
    
    public void displayRectangleInfo() {
        System.out.println("=== Rectangle Information ===");
        displayProperties();
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + String.format("%.2f", calculateArea()));
        System.out.println("Perimeter: " + String.format("%.2f", calculatePerimeter()));
        System.out.println("============================");
    }
}

// Main class to demonstrate Inheritance
public class Inheritance {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                    INHERITANCE DEMO                     ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        // ===============================
        // SINGLE INHERITANCE EXAMPLE
        // ===============================
        System.out.println("\n🚗 SINGLE INHERITANCE - VEHICLE HIERARCHY:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Create parent object
        System.out.println("\n--- Creating Parent Vehicle ---");
        Vehicle vehicle = new Vehicle("Generic", "Vehicle", 2020, "White", 25000);
        vehicle.displayInfo();
        vehicle.startEngine();
        vehicle.honk();
        vehicle.stopEngine();
        
        // Create child object (Car)
        System.out.println("\n--- Creating Child Car ---");
        Car car = new Car("Toyota", "Camry", 2022, "Blue", 35000, 4, "Gasoline", true);
        
        // Car inherits all Vehicle methods
        car.displayInfo(); // Overridden method
        car.startEngine();  // Inherited method
        car.honk();         // Overridden method
        
        // Car-specific methods
        car.openTrunk();
        car.turnOnAC();
        car.closeTrunk();
        car.stopEngine();   // Inherited method
        
        // Create another child object (Motorcycle)
        System.out.println("\n--- Creating Child Motorcycle ---");
        Motorcycle bike = new Motorcycle("Harley-Davidson", "Street 750", 2021, "Black", 8000, false, "V-Twin");
        
        bike.displayInfo();
        bike.startEngine();
        bike.performWheelstand();
        bike.attachSidecar();
        bike.honk();
        
        // ===============================
        // MULTILEVEL INHERITANCE EXAMPLE
        // ===============================
        System.out.println("\n🐕 MULTILEVEL INHERITANCE - ANIMAL HIERARCHY:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("\n--- Animal → Mammal → Dog inheritance chain ---");
        
        // Create Dog object (inherits from Mammal and Animal)
        Dog dog = new Dog("Buddy", 3, "Golden Retriever", true);
        
        // Methods from Animal (grandparent)
        dog.eat();
        dog.sleep();
        dog.makeSound(); // Overridden in Dog class
        
        // Methods from Mammal (parent)
        dog.giveBirth();
        dog.produceMilk();
        
        // Dog-specific methods
        dog.bark();
        dog.wagTail();
        dog.fetch();
        
        // Display complete information
        dog.displayInfo();
        
        // ===============================
        // HIERARCHICAL INHERITANCE EXAMPLE
        // ===============================
        System.out.println("\n🔷 HIERARCHICAL INHERITANCE - SHAPE HIERARCHY:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("\n--- Multiple children from Shape parent ---");
        
        // Create Circle object
        Circle circle = new Circle("Red", true, 5.0);
        circle.displayCircleInfo();
        
        // Create Rectangle object
        Rectangle rectangle = new Rectangle("Green", false, 10.0, 6.0);
        rectangle.displayRectangleInfo();
        
        // =============================
        // INHERITANCE RELATIONSHIPS
        // =============================
        System.out.println("\n🔗 INHERITANCE RELATIONSHIPS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ IS-A Relationships:");
        System.out.println("   • Car IS-A Vehicle: " + (car instanceof Vehicle));
        System.out.println("   • Motorcycle IS-A Vehicle: " + (bike instanceof Vehicle));
        System.out.println("   • Dog IS-A Mammal: " + (dog instanceof Mammal));
        System.out.println("   • Dog IS-A Animal: " + (dog instanceof Animal));
        System.out.println("   • Circle IS-A Shape: " + (circle instanceof Shape));
        System.out.println("   • Rectangle IS-A Shape: " + (rectangle instanceof Shape));
        
        System.out.println("\n❌ Invalid Relationships:");
        System.out.println("   • Car IS-A Motorcycle: " + (car instanceof Vehicle && !(car instanceof Motorcycle)));
        
        // =============================
        // CODE REUSABILITY DEMONSTRATION
        // =============================
        System.out.println("\n♻️  CODE REUSABILITY BENEFITS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ Vehicle methods reused in Car and Motorcycle:");
        System.out.println("   • startEngine() - inherited by both");
        System.out.println("   • stopEngine() - inherited by both");
        System.out.println("   • displayInfo() - inherited and overridden");
        
        System.out.println("\n✅ Animal methods reused in Mammal and Dog:");
        System.out.println("   • eat() - inherited through chain");
        System.out.println("   • sleep() - inherited through chain");
        System.out.println("   • makeSound() - inherited and overridden");
        
        // ============================
        // KEY CONCEPTS SUMMARY
        // ============================
        System.out.println("\n🎯 KEY INHERITANCE CONCEPTS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("🔄 CODE REUSABILITY: Child classes reuse parent code");
        System.out.println("🏗️ EXTENSIBILITY: Add new features to existing classes");
        System.out.println("🔗 IS-A RELATIONSHIP: Child IS-A type of Parent");
        System.out.println("🎭 METHOD OVERRIDING: Child can modify parent behavior");
        System.out.println("📞 super() KEYWORD: Access parent class members");
        System.out.println("🌳 INHERITANCE TREE: Hierarchical class relationships");
        
        System.out.println("\n💡 INHERITANCE BEST PRACTICES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("• Use inheritance for IS-A relationships only");
        System.out.println("• Keep inheritance hierarchy shallow and logical");
        System.out.println("• Use protected for members accessible to subclasses");
        System.out.println("• Override methods thoughtfully with @Override annotation");
        System.out.println("• Call super() appropriately in constructors");
        System.out.println("• Consider composition over inheritance when appropriate");
        
        System.out.println("\n🎓 Ready to move to 07_Method_Overriding.java!");
    }
}

/*
 * INHERITANCE TYPES SUPPORTED IN JAVA:
 * 
 * ✅ Single Inheritance:        Child extends Parent
 * ✅ Multilevel Inheritance:    A → B → C
 * ✅ Hierarchical Inheritance:  Multiple children from one parent
 * ❌ Multiple Inheritance:      Not supported (use interfaces)
 * ❌ Hybrid Inheritance:        Not directly supported
 * 
 * INHERITANCE HIERARCHY EXAMPLES:
 * 
 * Vehicle Hierarchy:
 * Vehicle
 * ├── Car
 * └── Motorcycle
 * 
 * Animal Hierarchy:
 * Animal
 * └── Mammal
 *     └── Dog
 * 
 * Shape Hierarchy:
 * Shape
 * ├── Circle
 * └── Rectangle
 */