/*
 * ===============================================================
 *                    JAVA OOP CONCEPTS - PART 2
 *                        CONSTRUCTORS
 * ===============================================================
 * 
 * WHAT IS A CONSTRUCTOR?
 * - A constructor is a special method that is called when an object is created
 * - It has the same name as the class
 * - It has no return type (not even void)
 * - It's used to initialize the object's state (instance variables)
 * - Every class has at least one constructor (default if not defined)
 * 
 * TYPES OF CONSTRUCTORS:
 * 1. Default Constructor (No parameters)
 * 2. Parameterized Constructor (With parameters)
 * 3. Copy Constructor (Not directly available in Java, but can be implemented)
 * 
 * CONSTRUCTOR OVERLOADING:
 * - Having multiple constructors with different parameters
 * - Allows creating objects in different ways
 * 
 * CONSTRUCTOR CHAINING:
 * - Calling one constructor from another using this()
 * - Must be the first statement in constructor
 */

// Example 1: Basic Constructor Example
class Person {
    // Instance variables
    String name;
    int age;
    String city;
    String profession;
    
    // 1. DEFAULT CONSTRUCTOR (No parameters)
    Person() {
        System.out.println("🏗️ Default constructor called!");
        name = "Unknown";
        age = 0;
        city = "Unknown";
        profession = "Unemployed";
    }
    
    // 2. PARAMETERIZED CONSTRUCTOR (With parameters)
    Person(String personName, int personAge) {
        System.out.println("🏗️ Parameterized constructor (2 params) called!");
        name = personName;
        age = personAge;
        city = "Unknown";
        profession = "Unknown";
    }
    
    // 3. ANOTHER PARAMETERIZED CONSTRUCTOR (Different parameters)
    Person(String personName, int personAge, String personCity) {
        System.out.println("🏗️ Parameterized constructor (3 params) called!");
        name = personName;
        age = personAge;
        city = personCity;
        profession = "Unknown";
    }
    
    // 4. FULLY PARAMETERIZED CONSTRUCTOR
    Person(String personName, int personAge, String personCity, String personProfession) {
        System.out.println("🏗️ Fully parameterized constructor called!");
        name = personName;
        age = personAge;
        city = personCity;
        profession = personProfession;
    }
    
    // Method to display person information
    void displayInfo() {
        System.out.println("=== Person Information ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
        System.out.println("Profession: " + profession);
        System.out.println("==========================\n");
    }
}

// Example 2: Constructor Chaining Example
class BankAccount {
    String accountNumber;
    String accountHolder;
    double balance;
    String accountType;
    
    // Constructor chaining using this()
    // 1. Default constructor calls parameterized constructor
    BankAccount() {
        this("ACC000000", "Anonymous", 0.0, "Savings");
        System.out.println("✅ Default account created successfully!");
    }
    
    // 2. Constructor with account holder name
    BankAccount(String holderName) {
        this("ACC" + System.currentTimeMillis(), holderName, 1000.0, "Savings");
        System.out.println("✅ Account created for: " + holderName);
    }
    
    // 3. Constructor with name and initial balance
    BankAccount(String holderName, double initialBalance) {
        this("ACC" + System.currentTimeMillis(), holderName, initialBalance, "Savings");
        System.out.println("✅ Account created for: " + holderName + " with balance: $" + initialBalance);
    }
    
    // 4. Master constructor (called by all other constructors)
    BankAccount(String accNum, String holderName, double initialBalance, String accType) {
        System.out.println("🏗️ Master constructor called!");
        accountNumber = accNum;
        accountHolder = holderName;
        balance = initialBalance;
        accountType = accType;
    }
    
    void displayAccountInfo() {
        System.out.println("=== Bank Account Details ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
        System.out.println("Account Type: " + accountType);
        System.out.println("============================\n");
    }
    
    void deposit(double amount) {
        balance += amount;
        System.out.println("💰 Deposited $" + amount + ". New balance: $" + balance);
    }
    
    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("💸 Withdrew $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("❌ Insufficient funds! Current balance: $" + balance);
        }
    }
}

// Example 3: Copy Constructor Implementation
class Book {
    String title;
    String author;
    double price;
    int pages;
    
    // Regular constructor
    Book(String bookTitle, String bookAuthor, double bookPrice, int bookPages) {
        title = bookTitle;
        author = bookAuthor;
        price = bookPrice;
        pages = bookPages;
    }
    
    // Copy constructor (takes another Book object as parameter)
    Book(Book originalBook) {
        System.out.println("📚 Copy constructor called!");
        this.title = originalBook.title;
        this.author = originalBook.author;
        this.price = originalBook.price;
        this.pages = originalBook.pages;
    }
    
    void displayBookInfo() {
        System.out.println("=== Book Information ===");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Pages: " + pages);
        System.out.println("=======================\n");
    }
}

// Main class to demonstrate Constructors
public class Constructors {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                    CONSTRUCTORS DEMO                    ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        // ===============================
        // CONSTRUCTOR OVERLOADING EXAMPLE
        // ===============================
        System.out.println("\n👤 PERSON CONSTRUCTOR EXAMPLES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Using default constructor
        System.out.println("\n1. Creating person with DEFAULT constructor:");
        Person person1 = new Person();
        person1.displayInfo();
        
        // Using parameterized constructor (2 parameters)
        System.out.println("2. Creating person with 2 parameters:");
        Person person2 = new Person("John Doe", 25);
        person2.displayInfo();
        
        // Using parameterized constructor (3 parameters)
        System.out.println("3. Creating person with 3 parameters:");
        Person person3 = new Person("Jane Smith", 30, "New York");
        person3.displayInfo();
        
        // Using fully parameterized constructor
        System.out.println("4. Creating person with ALL parameters:");
        Person person4 = new Person("Mike Johnson", 35, "California", "Software Engineer");
        person4.displayInfo();
        
        // ================================
        // CONSTRUCTOR CHAINING EXAMPLE
        // ================================
        System.out.println("🏦 BANK ACCOUNT CONSTRUCTOR CHAINING:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("\n1. Creating account with DEFAULT constructor:");
        BankAccount account1 = new BankAccount();
        account1.displayAccountInfo();
        
        System.out.println("2. Creating account with NAME only:");
        BankAccount account2 = new BankAccount("Alice Brown");
        account2.displayAccountInfo();
        
        System.out.println("3. Creating account with NAME and BALANCE:");
        BankAccount account3 = new BankAccount("Bob Wilson", 5000.0);
        account3.displayAccountInfo();
        
        // Demonstrate account operations
        System.out.println("--- Account Operations ---");
        account3.deposit(500.0);
        account3.withdraw(200.0);
        account3.withdraw(6000.0); // This should fail
        System.out.println();
        
        // =============================
        // COPY CONSTRUCTOR EXAMPLE
        // =============================
        System.out.println("📚 COPY CONSTRUCTOR EXAMPLE:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Create original book
        System.out.println("\n1. Creating original book:");
        Book originalBook = new Book("Java Programming", "Oracle Press", 49.99, 500);
        originalBook.displayBookInfo();
        
        // Create copy of the book
        System.out.println("2. Creating copy of the book:");
        Book copyBook = new Book(originalBook);
        copyBook.displayBookInfo();
        
        // Verify they are separate objects
        System.out.println("3. Modifying copy to verify independence:");
        copyBook.title = "Advanced Java Programming";
        copyBook.price = 59.99;
        
        System.out.println("Original book after modification:");
        originalBook.displayBookInfo();
        System.out.println("Copy book after modification:");
        copyBook.displayBookInfo();
        
        // ============================
        // KEY CONCEPTS DEMONSTRATION
        // ============================
        System.out.println("🎯 KEY CONCEPTS ABOUT CONSTRUCTORS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ Constructor name must match class name exactly");
        System.out.println("✅ Constructors have no return type (not even void)");
        System.out.println("✅ Constructors are called automatically when object is created");
        System.out.println("✅ You can have multiple constructors (overloading)");
        System.out.println("✅ If no constructor is defined, Java provides default constructor");
        System.out.println("✅ Constructor chaining uses this() and must be first statement");
        System.out.println("✅ Copy constructor helps create object from existing object");
        System.out.println("✅ Constructors are used to initialize object state");
        
        // ================================
        // COMMON MISTAKES AND SOLUTIONS
        // ================================
        System.out.println("\n⚠️  COMMON MISTAKES TO AVOID:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("❌ Don't add return type to constructor");
        System.out.println("❌ Don't forget to call this() as first statement in chaining");
        System.out.println("❌ Don't assume default constructor exists if you define any constructor");
        System.out.println("❌ Don't create circular constructor calls");
        
        System.out.println("\n🎓 Ready to move to 03_Methods.java!");
    }
}

/*
 * EXPECTED OUTPUT SAMPLE:
 * ═══════════════════════════════════════════════════════════
 *                     CONSTRUCTORS DEMO
 * ═══════════════════════════════════════════════════════════
 * 
 * 👤 PERSON CONSTRUCTOR EXAMPLES:
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * 
 * 1. Creating person with DEFAULT constructor:
 * 🏗️ Default constructor called!
 * === Person Information ===
 * Name: Unknown
 * Age: 0
 * City: Unknown
 * Profession: Unemployed
 * ==========================
 * 
 * 2. Creating person with 2 parameters:
 * 🏗️ Parameterized constructor (2 params) called!
 * === Person Information ===
 * Name: John Doe
 * Age: 25
 * City: Unknown
 * Profession: Unknown
 * ==========================
 * 
 * ... and so on
 */