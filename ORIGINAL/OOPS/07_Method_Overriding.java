/*
 * ===============================================================
 *                    JAVA OOP CONCEPTS - PART 7
 *                      METHOD OVERRIDING
 * ===============================================================
 * 
 * WHAT IS METHOD OVERRIDING?
 * - Method overriding occurs when a subclass provides a specific implementation 
 *   for a method that is already defined in its parent class
 * - The subclass method "overrides" the parent class method
 * - It's a key feature for achieving Runtime Polymorphism
 * - Also known as "Dynamic Method Dispatch"
 * 
 * RULES FOR METHOD OVERRIDING:
 * 1. Method name, return type, and parameters must be exactly the same
 * 2. Access modifier can be same or more accessible (not less)
 * 3. Cannot override static, final, or private methods
 * 4. Constructors cannot be overridden
 * 5. Use @Override annotation (recommended but not mandatory)
 * 
 * METHOD OVERRIDING vs METHOD OVERLOADING:
 * 
 * METHOD OVERRIDING:
 * - Same method signature in parent and child
 * - Runtime polymorphism (dynamic binding)
 * - "IS-A" relationship required
 * - One method per class in hierarchy
 * 
 * METHOD OVERLOADING:
 * - Same method name, different parameters
 * - Compile-time polymorphism (static binding)
 * - Can be in same class
 * - Multiple methods with same name
 * 
 * @Override ANNOTATION:
 * - Helps catch errors at compile time
 * - Improves code readability
 * - IDE support for refactoring
 * - Documents intent clearly
 */

// Example 1: Animal Sound System - Basic Method Overriding
class Animal {
    protected String name;
    protected String species;
    protected int age;
    
    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
        System.out.println("🦁 Animal created: " + name);
    }
    
    // Method to be overridden by subclasses
    public void makeSound() {
        System.out.println("🔊 " + name + " makes some generic animal sound");
    }
    
    public void eat() {
        System.out.println("🍽️ " + name + " is eating food");
    }
    
    public void sleep() {
        System.out.println("😴 " + name + " is sleeping");
    }
    
    // Method that will be overridden to show different behaviors
    public void move() {
        System.out.println("🚶 " + name + " is moving around");
    }
    
    public void displayInfo() {
        System.out.println("Animal: " + name + " (" + species + "), Age: " + age);
    }
}

// Child class 1: Dog overrides parent methods
class Dog extends Animal {
    private String breed;
    
    public Dog(String name, int age, String breed) {
        super(name, "Canis lupus", age);
        this.breed = breed;
        System.out.println("🐕 Dog breed: " + breed);
    }
    
    // Override makeSound() - Dog-specific sound
    @Override
    public void makeSound() {
        System.out.println("🐕 WOOF WOOF! " + name + " is barking loudly!");
    }
    
    // Override eat() - Dog-specific eating behavior
    @Override
    public void eat() {
        System.out.println("🦴 " + name + " is eating dog food and bones");
    }
    
    // Override move() - Dog-specific movement
    @Override
    public void move() {
        System.out.println("🏃 " + name + " is running and wagging tail");
    }
    
    // Override displayInfo() - Add dog-specific information
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call parent method first
        System.out.println("Breed: " + breed);
        System.out.println("Special abilities: Barking, Loyalty, Fetching");
    }
    
    // Dog-specific method (not overriding)
    public void wagTail() {
        System.out.println("🐕 " + name + " is wagging tail happily!");
    }
}

// Child class 2: Cat overrides parent methods differently
class Cat extends Animal {
    private boolean isIndoor;
    
    public Cat(String name, int age, boolean isIndoor) {
        super(name, "Felis catus", age);
        this.isIndoor = isIndoor;
        System.out.println("🐱 Cat type: " + (isIndoor ? "Indoor" : "Outdoor"));
    }
    
    // Override makeSound() - Cat-specific sound
    @Override
    public void makeSound() {
        System.out.println("🐱 MEOW MEOW! " + name + " is meowing softly");
    }
    
    // Override eat() - Cat-specific eating behavior
    @Override
    public void eat() {
        System.out.println("🐟 " + name + " is eating cat food and fish");
    }
    
    // Override move() - Cat-specific movement
    @Override
    public void move() {
        System.out.println("🦋 " + name + " is walking gracefully and stealthily");
    }
    
    // Override sleep() - Cats sleep a lot!
    @Override
    public void sleep() {
        System.out.println("😴 " + name + " is taking a cat nap (12-16 hours a day!)");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Living: " + (isIndoor ? "Indoor" : "Outdoor"));
        System.out.println("Special abilities: Climbing, Night vision, Purring");
    }
    
    // Cat-specific method
    public void purr() {
        System.out.println("🐱 " + name + " is purring contentedly");
    }
}

// Child class 3: Bird overrides parent methods with flying behavior
class Bird extends Animal {
    private boolean canFly;
    private double wingspan;
    
    public Bird(String name, int age, boolean canFly, double wingspan) {
        super(name, "Aves", age);
        this.canFly = canFly;
        this.wingspan = wingspan;
        System.out.println("🐦 Bird wingspan: " + wingspan + " inches");
    }
    
    @Override
    public void makeSound() {
        System.out.println("🐦 CHIRP CHIRP! " + name + " is singing beautiful songs");
    }
    
    @Override
    public void eat() {
        System.out.println("🌱 " + name + " is eating seeds, worms, and insects");
    }
    
    @Override
    public void move() {
        if (canFly) {
            System.out.println("🕊️ " + name + " is flying gracefully through the sky");
        } else {
            System.out.println("🚶 " + name + " is walking and hopping on the ground");
        }
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Can fly: " + (canFly ? "Yes" : "No"));
        System.out.println("Wingspan: " + wingspan + " inches");
        System.out.println("Special abilities: " + (canFly ? "Flying, Singing" : "Ground movement, Singing"));
    }
    
    public void buildNest() {
        System.out.println("🏠 " + name + " is building a nest");
    }
}

// Example 2: Vehicle System - Advanced Method Overriding
class Vehicle {
    protected String brand;
    protected String model;
    protected int maxSpeed;
    protected String fuelType;
    
    public Vehicle(String brand, String model, int maxSpeed, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
        System.out.println("🚗 Vehicle created: " + brand + " " + model);
    }
    
    // Method to be overridden
    public void startEngine() {
        System.out.println("🔥 " + brand + " " + model + " engine started");
    }
    
    public void accelerate() {
        System.out.println("⚡ " + brand + " " + model + " is accelerating");
    }
    
    public void brake() {
        System.out.println("🛑 " + brand + " " + model + " is braking");
    }
    
    // Method that calculates efficiency differently for each vehicle type
    public double calculateFuelEfficiency() {
        return 25.0; // Generic efficiency
    }
    
    public void displaySpecs() {
        System.out.println("=== Vehicle Specs ===");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " mph");
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Fuel Efficiency: " + calculateFuelEfficiency() + " mpg");
        System.out.println("====================");
    }
}

class ElectricCar extends Vehicle {
    private int batteryCapacity;
    
    public ElectricCar(String brand, String model, int maxSpeed, int batteryCapacity) {
        super(brand, model, maxSpeed, "Electric");
        this.batteryCapacity = batteryCapacity;
        System.out.println("🔋 Electric car battery: " + batteryCapacity + " kWh");
    }
    
    @Override
    public void startEngine() {
        System.out.println("🔋 " + brand + " " + model + " electric motor activated silently");
    }
    
    @Override
    public void accelerate() {
        System.out.println("⚡ " + brand + " " + model + " accelerating instantly with electric power");
    }
    
    @Override
    public double calculateFuelEfficiency() {
        // Electric cars: efficiency in miles per kWh equivalent
        return batteryCapacity * 3.5; // Simplified calculation
    }
    
    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Charging Type: Fast charging capable");
    }
    
    public void chargeBattery() {
        System.out.println("🔌 " + name + " is charging battery");
    }
}

class SportsCar extends Vehicle {
    private boolean hasTurbo;
    
    public SportsCar(String brand, String model, int maxSpeed, boolean hasTurbo) {
        super(brand, model, maxSpeed, "Gasoline");
        this.hasTurbo = hasTurbo;
        System.out.println("🏎️ Sports car turbo: " + (hasTurbo ? "Yes" : "No"));
    }
    
    @Override
    public void startEngine() {
        System.out.println("🔥 " + brand + " " + model + " powerful engine ROARS to life!");
    }
    
    @Override
    public void accelerate() {
        if (hasTurbo) {
            System.out.println("🚀 " + brand + " " + model + " TURBO kicks in! Incredible acceleration!");
        } else {
            System.out.println("🏎️ " + brand + " " + model + " accelerating with sports performance");
        }
    }
    
    @Override
    public double calculateFuelEfficiency() {
        // Sports cars typically have lower efficiency
        return hasTurbo ? 18.0 : 22.0;
    }
    
    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Turbo: " + (hasTurbo ? "Yes" : "No"));
        System.out.println("Performance: High-performance sports vehicle");
    }
    
    public void activateSportMode() {
        System.out.println("🏁 " + brand + " " + model + " SPORT MODE activated!");
    }
}

// Example 3: Shape Calculation System
class Shape {
    protected String color;
    protected String name;
    
    public Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }
    
    // Methods to be overridden by specific shapes
    public double calculateArea() {
        System.out.println("⚠️ Generic shape area calculation not implemented");
        return 0.0;
    }
    
    public double calculatePerimeter() {
        System.out.println("⚠️ Generic shape perimeter calculation not implemented");
        return 0.0;
    }
    
    public void displayInfo() {
        System.out.println("Shape: " + name + ", Color: " + color);
    }
    
    // Method that uses overridden methods (demonstrates polymorphism)
    public void printCalculations() {
        System.out.println("=== " + name + " Calculations ===");
        displayInfo();
        System.out.println("Area: " + String.format("%.2f", calculateArea()));
        System.out.println("Perimeter: " + String.format("%.2f", calculatePerimeter()));
        System.out.println("==============================");
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
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Radius: " + radius);
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(String color, double length, double width) {
        super("Rectangle", color);
        this.length = length;
        this.width = width;
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
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Length: " + length + ", Width: " + width);
    }
}

// Main class to demonstrate Method Overriding
public class Method_Overriding {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                  METHOD OVERRIDING DEMO                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        // ===============================
        // ANIMAL SOUND SYSTEM DEMO
        // ===============================
        System.out.println("\n🦁 ANIMAL SOUND SYSTEM - METHOD OVERRIDING:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Create different animals
        Animal genericAnimal = new Animal("Generic", "Unknown", 5);
        Dog dog = new Dog("Buddy", 3, "Golden Retriever");
        Cat cat = new Cat("Whiskers", 2, true);
        Bird bird = new Bird("Tweety", 1, true, 8.5);
        
        System.out.println("\n--- Method Overriding in Action ---");
        
        // Same method call, different behaviors (Runtime Polymorphism)
        System.out.println("\n🔊 Making Sounds:");
        genericAnimal.makeSound();
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
        
        System.out.println("\n🍽️ Eating Behaviors:");
        genericAnimal.eat();
        dog.eat();
        cat.eat();
        bird.eat();
        
        System.out.println("\n🚶 Movement Behaviors:");
        genericAnimal.move();
        dog.move();
        cat.move();
        bird.move();
        
        System.out.println("\n😴 Sleeping Behaviors:");
        genericAnimal.sleep();
        dog.sleep();
        cat.sleep(); // Cat overrides this method
        bird.sleep();
        
        // ===============================
        // RUNTIME POLYMORPHISM DEMO
        // ===============================
        System.out.println("\n🎭 RUNTIME POLYMORPHISM DEMONSTRATION:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Array of Animal references pointing to different objects
        Animal[] animals = {
            new Dog("Rex", 4, "German Shepherd"),
            new Cat("Fluffy", 3, false),
            new Bird("Eagle", 5, true, 15.0),
            new Dog("Poochy", 2, "Poodle")
        };
        
        System.out.println("\n--- Polymorphic Method Calls ---");
        for (int i = 0; i < animals.length; i++) {
            System.out.println("\nAnimal " + (i + 1) + ":");
            animals[i].displayInfo();
            animals[i].makeSound();
            animals[i].move();
        }
        
        // ===============================
        // VEHICLE SYSTEM DEMO
        // ===============================
        System.out.println("\n🚗 VEHICLE SYSTEM - ADVANCED METHOD OVERRIDING:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        Vehicle genericVehicle = new Vehicle("Generic", "Vehicle", 100, "Gasoline");
        ElectricCar tesla = new ElectricCar("Tesla", "Model S", 200, 100);
        SportsCar ferrari = new SportsCar("Ferrari", "488 GTB", 330, true);
        
        System.out.println("\n--- Vehicle Operations ---");
        
        System.out.println("\n🔥 Starting Engines:");
        genericVehicle.startEngine();
        tesla.startEngine();
        ferrari.startEngine();
        
        System.out.println("\n⚡ Acceleration:");
        genericVehicle.accelerate();
        tesla.accelerate();
        ferrari.accelerate();
        
        System.out.println("\n📊 Fuel Efficiency Comparison:");
        System.out.println("Generic Vehicle: " + genericVehicle.calculateFuelEfficiency() + " mpg");
        System.out.println("Tesla Model S: " + tesla.calculateFuelEfficiency() + " miles per kWh equivalent");
        System.out.println("Ferrari 488 GTB: " + ferrari.calculateFuelEfficiency() + " mpg");
        
        // Display detailed specifications
        System.out.println("\n--- Detailed Specifications ---");
        genericVehicle.displaySpecs();
        tesla.displaySpecs();
        ferrari.displaySpecs();
        
        // ===============================
        // SHAPE CALCULATION DEMO
        // ===============================
        System.out.println("\n🔷 SHAPE CALCULATION SYSTEM:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        Shape[] shapes = {
            new Circle("Red", 5.0),
            new Rectangle("Blue", 10.0, 6.0),
            new Circle("Green", 3.5),
            new Rectangle("Yellow", 8.0, 4.0)
        };
        
        System.out.println("\n--- Polymorphic Shape Calculations ---");
        for (Shape shape : shapes) {
            shape.printCalculations(); // Uses overridden methods
            System.out.println();
        }
        
        // ============================
        // METHOD OVERRIDING RULES DEMO
        // ============================
        System.out.println("📋 METHOD OVERRIDING RULES DEMONSTRATION:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ VALID Overriding Examples:");
        System.out.println("   • Same method signature: makeSound()");
        System.out.println("   • Same return type: void makeSound()");
        System.out.println("   • @Override annotation used for clarity");
        System.out.println("   • Access modifier same or more accessible");
        
        System.out.println("\n❌ INVALID Overriding (would cause errors):");
        System.out.println("   • Different method name: makeNoise() vs makeSound()");
        System.out.println("   • Different parameters: makeSound(int volume)");
        System.out.println("   • Different return type: int makeSound()");
        System.out.println("   • Less accessible modifier: private in child");
        
        // ============================
        // KEY CONCEPTS SUMMARY
        // ============================
        System.out.println("\n🎯 KEY METHOD OVERRIDING CONCEPTS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("🎭 RUNTIME POLYMORPHISM: Method called depends on object type");
        System.out.println("🔄 DYNAMIC BINDING: JVM decides which method to call at runtime");
        System.out.println("📝 @Override ANNOTATION: Compile-time safety and documentation");
        System.out.println("🏗️ IS-A RELATIONSHIP: Required for method overriding");
        System.out.println("🎨 BEHAVIORAL CUSTOMIZATION: Each class can implement differently");
        System.out.println("♻️ CODE REUSABILITY: Parent structure, child customization");
        
        System.out.println("\n💡 METHOD OVERRIDING BEST PRACTICES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("• Always use @Override annotation");
        System.out.println("• Keep method signature exactly the same");
        System.out.println("• Call super.method() when appropriate");
        System.out.println("• Document overriding behavior clearly");
        System.out.println("• Test polymorphic behavior thoroughly");
        System.out.println("• Consider Liskov Substitution Principle");
        
        System.out.println("\n🎓 Ready to move to 08_Polymorphism.java!");
    }
}

/*
 * METHOD OVERRIDING vs METHOD OVERLOADING COMPARISON:
 * 
 * ╔═══════════════════╦═══════════════════════╦═══════════════════════╗
 * ║ Aspect            ║ Method Overriding     ║ Method Overloading    ║
 * ╠═══════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ Definition        ║ Same signature in     ║ Same name, different  ║
 * ║                   ║ parent and child      ║ parameters           ║
 * ╠═══════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ Polymorphism      ║ Runtime (Dynamic)     ║ Compile-time (Static) ║
 * ╠═══════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ Inheritance       ║ Required (IS-A)       ║ Not required          ║
 * ╠═══════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ Method Resolution ║ At runtime            ║ At compile time       ║
 * ╠═══════════════════╬═══════════════════════╬═══════════════════════╣
 * ║ Performance       ║ Slightly slower       ║ Faster                ║
 * ╚═══════════════════╩═══════════════════════╩═══════════════════════╝
 */