/*
 * ===============================================================
 *                    JAVA OOP CONCEPTS - PART 13
 *                       SUPER KEYWORD
 * ===============================================================
 * 
 * WHAT IS SUPER KEYWORD?
 * - 'super' is a reference variable in Java that refers to the immediate parent class object
 * - Used to access parent class members (variables, methods, constructors) from child class
 * - Resolves naming conflicts between parent and child class members
 * - Essential for inheritance and method overriding scenarios
 * 
 * USES OF SUPER KEYWORD:
 * 1. super.variable - Access parent class instance variables
 * 2. super.method() - Call parent class methods
 * 3. super() - Call parent class constructor
 * 4. Method overriding - Access overridden parent methods
 * 
 * KEY CHARACTERISTICS:
 * - Must be used within child class context
 * - super() must be first statement in constructor (if used)
 * - Cannot be used in static methods or static blocks
 * - Helps maintain inheritance chain integrity
 */

import java.util.ArrayList;
import java.util.List;

// Example 1: Basic Super Usage - Variables and Methods
class Animal {
    protected String name;
    protected String species;
    protected int age;
    protected double weight;
    
    // Parent class constructor
    public Animal(String name, String species, int age, double weight) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.weight = weight;
        System.out.println("🐾 Animal constructor: " + name + " (" + species + ")");
    }
    
    // Parent class methods
    public void eat() {
        System.out.println("🍃 " + name + " is eating...");
    }
    
    public void sleep() {
        System.out.println("😴 " + name + " is sleeping peacefully");
    }
    
    public void makeSound() {
        System.out.println("🔊 " + name + " makes a generic animal sound");
    }
    
    public void displayInfo() {
        System.out.println("📋 Animal Info:");
        System.out.println("   Name: " + name);
        System.out.println("   Species: " + species);
        System.out.println("   Age: " + age + " years");
        System.out.println("   Weight: " + weight + " kg");
    }
    
    protected void breathe() {
        System.out.println("💨 " + name + " is breathing normally");
    }
}

class Dog extends Animal {
    private String breed;
    private boolean isVaccinated;
    // Variable with same name as parent - demonstrates super usage
    private String name; // Shadows parent's name variable
    
    // Child class constructor using super()
    public Dog(String name, String breed, int age, double weight, boolean vaccinated) {
        // super() must be first statement in constructor
        super(name, "Canine", age, weight); // Calls parent constructor
        
        this.breed = breed;
        this.isVaccinated = vaccinated;
        this.name = name + " (Dog)"; // Child class name variable
        
        System.out.println("🐕 Dog constructor: " + breed + " breed");
    }
    
    // Method demonstrating super for variable access
    public void displayNames() {
        System.out.println("\n🏷️ NAME COMPARISON:");
        System.out.println("Child class name: " + this.name);        // Dog's name
        System.out.println("Parent class name: " + super.name);      // Animal's name
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }
    
    // Overriding parent method and using super
    @Override
    public void makeSound() {
        // Call parent method first
        super.makeSound(); // Calls Animal's makeSound()
        
        // Add child-specific behavior
        System.out.println("🐕 " + super.name + " barks: Woof! Woof!");
    }
    
    @Override
    public void eat() {
        System.out.println("🦴 " + super.name + " is eating dog food");
        super.breathe(); // Call protected parent method
    }
    
    // Method using super to call parent method and extend functionality
    @Override
    public void displayInfo() {
        // Call parent's displayInfo first
        super.displayInfo();
        
        // Add child-specific information
        System.out.println("   Breed: " + breed);
        System.out.println("   Vaccinated: " + (isVaccinated ? "Yes ✅" : "No ❌"));
    }
    
    // New method specific to Dog
    public void wagTail() {
        System.out.println("🐕 " + super.name + " is wagging tail happily!");
    }
    
    public void fetch() {
        System.out.println("🎾 " + super.name + " is fetching the ball");
        super.breathe(); // Using parent's protected method
    }
}

// Example 2: Multi-level Inheritance with Super
class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected double price;
    
    public Vehicle(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        System.out.println("🚗 Vehicle created: " + brand + " " + model);
    }
    
    public void start() {
        System.out.println("🔥 " + brand + " " + model + " is starting...");
    }
    
    public void stop() {
        System.out.println("🛑 " + brand + " " + model + " has stopped");
    }
    
    public double calculateTax() {
        return price * 0.10; // 10% tax
    }
    
    public void displayVehicleInfo() {
        System.out.println("🚗 Vehicle: " + brand + " " + model + " (" + year + ")");
        System.out.println("💰 Price: $" + String.format("%.2f", price));
    }
}

class Car extends Vehicle {
    protected int numberOfDoors;
    protected String fuelType;
    
    public Car(String brand, String model, int year, double price, int doors, String fuel) {
        super(brand, model, year, price); // Call parent constructor
        this.numberOfDoors = doors;
        this.fuelType = fuel;
        System.out.println("🚙 Car specific: " + doors + " doors, " + fuel + " fuel");
    }
    
    @Override
    public void start() {
        System.out.println("🔑 Inserting key for " + super.brand + " " + super.model);
        super.start(); // Call parent's start method
        System.out.println("🚙 Car-specific systems initialized");
    }
    
    @Override
    public double calculateTax() {
        double baseTax = super.calculateTax(); // Get parent's tax calculation
        double carTax = baseTax * 1.2; // 20% additional tax for cars
        System.out.println("📊 Base tax: $" + String.format("%.2f", baseTax));
        System.out.println("📊 Car tax (with 20% extra): $" + String.format("%.2f", carTax));
        return carTax;
    }
    
    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo(); // Call parent's display method
        System.out.println("🚪 Doors: " + numberOfDoors);
        System.out.println("⛽ Fuel: " + fuelType);
    }
}

class SportsCar extends Car {
    private int topSpeed;
    private boolean hasTurbo;
    
    public SportsCar(String brand, String model, int year, double price, 
                    int doors, String fuel, int speed, boolean turbo) {
        super(brand, model, year, price, doors, fuel); // Call parent (Car) constructor
        this.topSpeed = speed;
        this.hasTurbo = turbo;
        System.out.println("🏎️ Sports car: Top speed " + speed + " mph, Turbo: " + turbo);
    }
    
    @Override
    public void start() {
        System.out.println("🏁 Sports car startup sequence initiated...");
        super.start(); // Calls Car's start(), which calls Vehicle's start()
        
        if (hasTurbo) {
            System.out.println("🚀 Turbo system activated!");
        }
        System.out.println("🏎️ Ready for high-performance driving!");
    }
    
    @Override
    public double calculateTax() {
        double carTax = super.calculateTax(); // Get Car's tax calculation
        double sportsTax = carTax * 1.5; // 50% additional luxury tax
        
        System.out.println("📊 Sports car luxury tax (50% extra): $" + 
                          String.format("%.2f", sportsTax - carTax));
        System.out.println("📊 Total sports car tax: $" + String.format("%.2f", sportsTax));
        return sportsTax;
    }
    
    @Override
    public void displayVehicleInfo() {
        super.displayVehicleInfo(); // Call Car's display method
        System.out.println("🏎️ Top Speed: " + topSpeed + " mph");
        System.out.println("🚀 Turbo: " + (hasTurbo ? "Yes" : "No"));
    }
    
    public void activateSportMode() {
        System.out.println("🏁 " + super.brand + " " + super.model + " SPORT MODE ACTIVATED!");
        System.out.println("⚡ Enhanced performance, tighter suspension, louder exhaust!");
    }
}

// Example 3: Super with Method Overriding Chain
class Employee {
    protected String name;
    protected int id;
    protected double salary;
    protected String department;
    
    public Employee(String name, int id, double salary, String department) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.department = department;
        System.out.println("👤 Employee created: " + name + " (ID: " + id + ")");
    }
    
    public double calculateBonus() {
        double bonus = salary * 0.05; // 5% bonus
        System.out.println("💰 Base employee bonus (5%): $" + String.format("%.2f", bonus));
        return bonus;
    }
    
    public void work() {
        System.out.println("💼 " + name + " is working in " + department + " department");
    }
    
    public void displayEmployeeInfo() {
        System.out.println("👤 Employee: " + name + " (ID: " + id + ")");
        System.out.println("🏢 Department: " + department);
        System.out.println("💰 Salary: $" + String.format("%.2f", salary));
    }
}

class Manager extends Employee {
    private int teamSize;
    private String managementLevel;
    
    public Manager(String name, int id, double salary, String department, 
                  int teamSize, String level) {
        super(name, id, salary, department); // Call parent constructor
        this.teamSize = teamSize;
        this.managementLevel = level;
        System.out.println("👔 Manager: " + level + " level, managing " + teamSize + " people");
    }
    
    @Override
    public double calculateBonus() {
        double baseBonus = super.calculateBonus(); // Get employee bonus
        double managementBonus = baseBonus + (teamSize * 1000); // $1000 per team member
        
        System.out.println("💼 Management bonus (+$1000 per team member): $" + 
                          String.format("%.2f", managementBonus - baseBonus));
        System.out.println("💰 Total manager bonus: $" + String.format("%.2f", managementBonus));
        return managementBonus;
    }
    
    @Override
    public void work() {
        super.work(); // Call parent's work method
        System.out.println("👔 Additionally managing " + teamSize + " team members");
        System.out.println("📋 Conducting meetings and performance reviews");
    }
    
    @Override
    public void displayEmployeeInfo() {
        super.displayEmployeeInfo(); // Call parent's display method
        System.out.println("👔 Management Level: " + managementLevel);
        System.out.println("👥 Team Size: " + teamSize);
    }
    
    public void conductMeeting() {
        System.out.println("📅 " + super.name + " is conducting a team meeting");
    }
}

class Director extends Manager {
    private List<String> businessUnits;
    private double budgetAuthority;
    
    public Director(String name, int id, double salary, String department,
                   int teamSize, String level, double budget) {
        super(name, id, salary, department, teamSize, level); // Call Manager constructor
        this.businessUnits = new ArrayList<>();
        this.budgetAuthority = budget;
        System.out.println("🎯 Director with $" + String.format("%.0f", budget) + " budget authority");
    }
    
    @Override
    public double calculateBonus() {
        double managerBonus = super.calculateBonus(); // Get Manager's bonus calculation
        double directorBonus = managerBonus + (budgetAuthority * 0.01); // 1% of budget authority
        
        System.out.println("🎯 Director bonus (1% of budget): $" + 
                          String.format("%.2f", directorBonus - managerBonus));
        System.out.println("💰 Total director bonus: $" + String.format("%.2f", directorBonus));
        return directorBonus;
    }
    
    @Override
    public void work() {
        super.work(); // Call Manager's work method (which calls Employee's work)
        System.out.println("🎯 Making strategic decisions for business units");
        System.out.println("💼 Overseeing budget of $" + String.format("%.0f", budgetAuthority));
    }
    
    @Override
    public void displayEmployeeInfo() {
        super.displayEmployeeInfo(); // Call Manager's display method
        System.out.println("🎯 Budget Authority: $" + String.format("%.0f", budgetAuthority));
        System.out.println("🏢 Business Units: " + businessUnits.size());
    }
    
    public void addBusinessUnit(String unit) {
        businessUnits.add(unit);
        System.out.println("🏢 Added business unit: " + unit);
    }
    
    public void approveExpense(double amount) {
        if (amount <= budgetAuthority) {
            System.out.println("✅ " + super.name + " approved expense: $" + 
                              String.format("%.2f", amount));
        } else {
            System.out.println("❌ Expense exceeds budget authority: $" + 
                              String.format("%.2f", amount));
        }
    }
}

// Example 4: Super in Constructor Chaining
class Shape {
    protected String color;
    protected boolean filled;
    
    // Default constructor
    public Shape() {
        this.color = "white";
        this.filled = false;
        System.out.println("🔷 Default Shape constructor: white, not filled");
    }
    
    // Parameterized constructor
    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        System.out.println("🔷 Shape constructor: " + color + ", filled: " + filled);
    }
    
    public void draw() {
        System.out.println("🎨 Drawing a " + color + " shape");
    }
    
    public double getArea() {
        return 0.0; // Base implementation
    }
}

class Rectangle extends Shape {
    private double width;
    private double height;
    
    // Constructor using super() with parameters
    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled); // Call parent constructor with parameters
        this.width = width;
        this.height = height;
        System.out.println("📐 Rectangle constructor: " + width + "x" + height);
    }
    
    // Constructor using default parent constructor
    public Rectangle(double width, double height) {
        super(); // Call parent's default constructor
        this.width = width;
        this.height = height;
        System.out.println("📐 Rectangle with default color: " + width + "x" + height);
    }
    
    @Override
    public void draw() {
        super.draw(); // Call parent's draw method
        System.out.println("📐 Specifically drawing a rectangle " + width + "x" + height);
    }
    
    @Override
    public double getArea() {
        return width * height;
    }
    
    public void displayRectangleInfo() {
        System.out.println("📐 Rectangle - Color: " + super.color + 
                          ", Filled: " + super.filled);
        System.out.println("   Dimensions: " + width + "x" + height);
        System.out.println("   Area: " + getArea());
    }
}

// Main class to demonstrate Super Keyword
public class Super_Keyword {
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                     SUPER KEYWORD DEMO                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        // ===============================
        // BASIC SUPER USAGE
        // ===============================
        System.out.println("\n🐾 BASIC SUPER USAGE:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━");
        
        Dog dog = new Dog("Buddy", "Golden Retriever", 3, 30.5, true);
        
        // Demonstrate variable access with super
        dog.displayNames();
        
        // Method calls demonstrating super usage
        System.out.println("\n--- Method Calls ---");
        dog.makeSound();    // Uses super to call parent method first
        dog.eat();          // Uses super to access parent variables and methods
        dog.wagTail();      // Dog-specific method using super
        dog.fetch();        // Uses super to call protected parent method
        
        System.out.println("\n--- Information Display ---");
        dog.displayInfo();  // Uses super to call parent method then extends
        
        // ===============================
        // MULTI-LEVEL INHERITANCE
        // ===============================
        System.out.println("\n\n🏎️ MULTI-LEVEL INHERITANCE:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        SportsCar ferrari = new SportsCar("Ferrari", "488 GTB", 2023, 250000, 
                                         2, "Gasoline", 205, true);
        
        System.out.println("\n--- Startup Sequence (Super Chain) ---");
        ferrari.start(); // Calls through inheritance chain
        
        System.out.println("\n--- Tax Calculation (Super Chain) ---");
        double tax = ferrari.calculateTax(); // Each level adds to calculation
        
        System.out.println("\n--- Vehicle Information ---");
        ferrari.displayVehicleInfo(); // Calls through super chain
        
        ferrari.activateSportMode(); // Sports car specific method
        
        // ===============================
        // EMPLOYEE HIERARCHY
        // ===============================
        System.out.println("\n\n👔 EMPLOYEE HIERARCHY:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
        
        Director director = new Director("Sarah Johnson", 1001, 150000, 
                                       "Technology", 25, "Senior", 5000000);
        
        // Add some business units
        director.addBusinessUnit("Software Development");
        director.addBusinessUnit("Data Analytics");
        director.addBusinessUnit("AI Research");
        
        System.out.println("\n--- Work Activities (Super Chain) ---");
        director.work(); // Calls through inheritance chain
        
        System.out.println("\n--- Bonus Calculation (Super Chain) ---");
        double bonus = director.calculateBonus(); // Each level adds to calculation
        
        System.out.println("\n--- Employee Information ---");
        director.displayEmployeeInfo(); // Calls through super chain
        
        System.out.println("\n--- Director Activities ---");
        director.approveExpense(50000);  // Within budget
        director.approveExpense(6000000); // Exceeds budget
        
        // ===============================
        // CONSTRUCTOR CHAINING
        // ===============================
        System.out.println("\n\n📐 CONSTRUCTOR CHAINING:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("--- Rectangle with custom color ---");
        Rectangle rect1 = new Rectangle("blue", true, 10.0, 5.0);
        rect1.draw();
        rect1.displayRectangleInfo();
        
        System.out.println("\n--- Rectangle with default color ---");
        Rectangle rect2 = new Rectangle(8.0, 6.0);
        rect2.draw();
        rect2.displayRectangleInfo();
        
        // ===============================
        // SUPER KEYWORD RULES
        // ===============================
        System.out.println("\n\n📋 SUPER KEYWORD RULES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ VALID USES:");
        System.out.println("   • super() - Must be first statement in constructor");
        System.out.println("   • super.variable - Access parent class variables");
        System.out.println("   • super.method() - Call parent class methods");
        System.out.println("   • Used to resolve naming conflicts");
        System.out.println("   • Access overridden methods from parent");
        
        System.out.println("\n❌ INVALID USES:");
        System.out.println("   • Cannot use super in static context");
        System.out.println("   • super() cannot be used with this() in same constructor");
        System.out.println("   • Cannot access parent's private members");
        System.out.println("   • super() must be first line if used in constructor");
        
        // ===============================
        // SUPER vs THIS COMPARISON
        // ===============================
        System.out.println("\n🔄 SUPER vs THIS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("🔵 SUPER KEYWORD:");
        System.out.println("   • Refers to immediate parent class object");
        System.out.println("   • Used to access parent class members");
        System.out.println("   • Resolves inheritance-related conflicts");
        System.out.println("   • Cannot be used in static context");
        
        System.out.println("\n🟡 THIS KEYWORD:");
        System.out.println("   • Refers to current class object");
        System.out.println("   • Used to access current class members");
        System.out.println("   • Resolves local variable vs instance variable conflicts");
        System.out.println("   • Cannot be used in static context");
        
        // ===============================
        // BEST PRACTICES
        // ===============================
        System.out.println("\n💡 SUPER KEYWORD BEST PRACTICES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ RECOMMENDED:");
        System.out.println("   • Use super() to properly initialize parent class");
        System.out.println("   • Call super.method() when extending functionality");
        System.out.println("   • Use super.variable when both classes have same variable name");
        System.out.println("   • Document when super is used for clarity");
        System.out.println("   • Use super in overridden methods to preserve parent behavior");
        
        System.out.println("\n⚠️ BE CAREFUL:");
        System.out.println("   • Don't overuse super - may indicate poor design");
        System.out.println("   • Ensure proper constructor chaining");
        System.out.println("   • Consider composition over deep inheritance");
        System.out.println("   • Test inheritance hierarchies thoroughly");
        
        System.out.println("\n🎓 Ready to move to 14_This_Keyword.java!");
    }
}

/*
 * SUPER KEYWORD SUMMARY:
 * 
 * ╔═══════════════════════╦═══════════════════════════════════════════════════╗
 * ║ Usage                 ║ Description                                       ║
 * ╠═══════════════════════╬═══════════════════════════════════════════════════╣
 * ║ super()               ║ Calls parent class constructor                    ║
 * ╠═══════════════════════╬═══════════════════════════════════════════════════╣
 * ║ super.variable        ║ Accesses parent class instance variable          ║
 * ╠═══════════════════════╬═══════════════════════════════════════════════════╣
 * ║ super.method()        ║ Calls parent class method                         ║
 * ╠═══════════════════════╬═══════════════════════════════════════════════════╣
 * ║ Method Overriding     ║ Access overridden parent method                   ║
 * ╠═══════════════════════╬═══════════════════════════════════════════════════╣
 * ║ Constructor Chaining  ║ Ensure proper parent initialization               ║
 * ╠═══════════════════════╬═══════════════════════════════════════════════════╣
 * ║ Naming Conflicts      ║ Resolve same-named variables in inheritance       ║
 * ╚═══════════════════════╩═══════════════════════════════════════════════════╝
 * 
 * INHERITANCE CHAIN FLOW:
 * Child class method → super.method() → Parent class method → super.method() → Grandparent...
 */