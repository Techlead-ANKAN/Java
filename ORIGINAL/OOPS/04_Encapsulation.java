/*
 * ===============================================================
 *                    JAVA OOP CONCEPTS - PART 4
 *                        ENCAPSULATION
 * ===============================================================
 * 
 * WHAT IS ENCAPSULATION?
 * - Encapsulation is the bundling of data (variables) and methods that operate on that data into a single unit (class)
 * - It's the concept of hiding the internal implementation details from the outside world
 * - Also known as "Data Hiding" or "Information Hiding"
 * - One of the four fundamental OOP principles (Encapsulation, Inheritance, Polymorphism, Abstraction)
 * 
 * HOW TO ACHIEVE ENCAPSULATION?
 * 1. Make instance variables private
 * 2. Provide public getter and setter methods to access and modify the data
 * 3. Add validation logic in setter methods
 * 
 * BENEFITS OF ENCAPSULATION:
 * - Data Security: Prevents direct access to sensitive data
 * - Data Validation: Can validate data before setting
 * - Flexibility: Can change internal implementation without affecting outside code
 * - Maintainability: Easier to maintain and debug code
 * - Code Reusability: Well-encapsulated classes can be reused
 */

// Example 1: Bank Account with Proper Encapsulation
class BankAccount {
    // Private instance variables (Data Hiding)
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;
    private int pinNumber;
    private boolean isAccountActive;
    
    // Constructor
    public BankAccount(String accNum, String holderName, double initialBalance, String accType, int pin) {
        this.accountNumber = accNum;
        this.accountHolderName = holderName;
        this.balance = initialBalance;
        this.accountType = accType;
        this.pinNumber = pin;
        this.isAccountActive = true;
        System.out.println("🏦 Bank account created successfully for: " + holderName);
    }
    
    // =================================
    // GETTER METHODS (Read-only access)
    // =================================
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public boolean isAccountActive() {
        return isAccountActive;
    }
    
    // Special getter with validation
    public double getBalance(int pin) {
        if (validatePin(pin)) {
            return balance;
        } else {
            System.out.println("❌ Invalid PIN! Cannot access balance.");
            return -1;
        }
    }
    
    // =================================
    // SETTER METHODS (Controlled access)
    // =================================
    
    public void setAccountHolderName(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            this.accountHolderName = newName;
            System.out.println("✅ Account holder name updated to: " + newName);
        } else {
            System.out.println("❌ Invalid name! Name cannot be empty.");
        }
    }
    
    public void setAccountType(String newType) {
        if (newType.equals("Savings") || newType.equals("Current") || newType.equals("Fixed")) {
            this.accountType = newType;
            System.out.println("✅ Account type updated to: " + newType);
        } else {
            System.out.println("❌ Invalid account type! Valid types: Savings, Current, Fixed");
        }
    }
    
    public void setPinNumber(int oldPin, int newPin) {
        if (validatePin(oldPin)) {
            if (String.valueOf(newPin).length() == 4) {
                this.pinNumber = newPin;
                System.out.println("✅ PIN changed successfully!");
            } else {
                System.out.println("❌ New PIN must be 4 digits!");
            }
        } else {
            System.out.println("❌ Invalid old PIN! Cannot change PIN.");
        }
    }
    
    // =================================
    // BUSINESS LOGIC METHODS
    // =================================
    
    public void deposit(double amount) {
        if (!isAccountActive) {
            System.out.println("❌ Account is inactive! Cannot deposit.");
            return;
        }
        
        if (amount > 0) {
            balance += amount;
            System.out.println("💰 Deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("❌ Invalid deposit amount! Amount must be positive.");
        }
    }
    
    public void withdraw(double amount, int pin) {
        if (!isAccountActive) {
            System.out.println("❌ Account is inactive! Cannot withdraw.");
            return;
        }
        
        if (!validatePin(pin)) {
            System.out.println("❌ Invalid PIN! Transaction cancelled.");
            return;
        }
        
        if (amount <= 0) {
            System.out.println("❌ Invalid withdrawal amount!");
            return;
        }
        
        if (amount > balance) {
            System.out.println("❌ Insufficient funds! Current balance: $" + balance);
            return;
        }
        
        balance -= amount;
        System.out.println("💸 Withdrew $" + amount + ". New balance: $" + balance);
    }
    
    public void transfer(BankAccount targetAccount, double amount, int pin) {
        if (!validatePin(pin)) {
            System.out.println("❌ Invalid PIN! Transfer cancelled.");
            return;
        }
        
        if (amount <= 0) {
            System.out.println("❌ Invalid transfer amount!");
            return;
        }
        
        if (amount > balance) {
            System.out.println("❌ Insufficient funds for transfer!");
            return;
        }
        
        if (!targetAccount.isAccountActive()) {
            System.out.println("❌ Target account is inactive!");
            return;
        }
        
        // Deduct from current account
        balance -= amount;
        // Add to target account
        targetAccount.balance += amount;
        
        System.out.println("💸 Transferred $" + amount + " to " + targetAccount.getAccountHolderName());
        System.out.println("Your new balance: $" + balance);
    }
    
    public void deactivateAccount(int pin) {
        if (validatePin(pin)) {
            isAccountActive = false;
            System.out.println("🔒 Account deactivated successfully!");
        } else {
            System.out.println("❌ Invalid PIN! Cannot deactivate account.");
        }
    }
    
    // =================================
    // PRIVATE HELPER METHODS (Internal use only)
    // =================================
    
    private boolean validatePin(int enteredPin) {
        return this.pinNumber == enteredPin;
    }
    
    // Public method to display account info (without sensitive data)
    public void displayAccountInfo() {
        System.out.println("=== Account Information ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Status: " + (isAccountActive ? "Active ✅" : "Inactive ❌"));
        System.out.println("Balance: [Protected - Use PIN to view]");
        System.out.println("===========================\n");
    }
}

// Example 2: Student Management with Encapsulation
class Student {
    // Private data members
    private String studentId;
    private String name;
    private int age;
    private String email;
    private double gpa;
    private String course;
    private boolean isEnrolled;
    
    // Constructor
    public Student(String id, String studentName, int studentAge, String studentEmail, String studentCourse) {
        this.studentId = id;
        this.name = studentName;
        setAge(studentAge); // Use setter for validation
        setEmail(studentEmail); // Use setter for validation
        this.course = studentCourse;
        this.gpa = 0.0;
        this.isEnrolled = true;
        System.out.println("👨‍🎓 Student enrolled: " + studentName);
    }
    
    // =================================
    // GETTER METHODS
    // =================================
    
    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
    public double getGpa() { return gpa; }
    public String getCourse() { return course; }
    public boolean isEnrolled() { return isEnrolled; }
    
    // =================================
    // SETTER METHODS WITH VALIDATION
    // =================================
    
    public void setName(String newName) {
        if (newName != null && newName.trim().length() >= 2) {
            this.name = newName;
            System.out.println("✅ Name updated to: " + newName);
        } else {
            System.out.println("❌ Invalid name! Name must be at least 2 characters.");
        }
    }
    
    public void setAge(int newAge) {
        if (newAge >= 16 && newAge <= 100) {
            this.age = newAge;
            System.out.println("✅ Age updated to: " + newAge);
        } else {
            System.out.println("❌ Invalid age! Age must be between 16 and 100.");
        }
    }
    
    public void setEmail(String newEmail) {
        if (newEmail != null && newEmail.contains("@") && newEmail.contains(".")) {
            this.email = newEmail;
            System.out.println("✅ Email updated to: " + newEmail);
        } else {
            System.out.println("❌ Invalid email format!");
        }
    }
    
    public void setCourse(String newCourse) {
        if (newCourse != null && !newCourse.trim().isEmpty()) {
            this.course = newCourse;
            System.out.println("✅ Course updated to: " + newCourse);
        } else {
            System.out.println("❌ Invalid course name!");
        }
    }
    
    // =================================
    // BUSINESS LOGIC METHODS
    // =================================
    
    public void updateGPA(double[] marks) {
        if (marks == null || marks.length == 0) {
            System.out.println("❌ No marks provided!");
            return;
        }
        
        double total = 0;
        for (double mark : marks) {
            if (mark < 0 || mark > 100) {
                System.out.println("❌ Invalid mark: " + mark + ". Marks must be between 0-100.");
                return;
            }
            total += mark;
        }
        
        this.gpa = total / marks.length;
        System.out.println("📊 GPA updated to: " + String.format("%.2f", gpa));
    }
    
    public void enrollStudent() {
        if (!isEnrolled) {
            isEnrolled = true;
            System.out.println("✅ Student re-enrolled successfully!");
        } else {
            System.out.println("ℹ️ Student is already enrolled.");
        }
    }
    
    public void withdrawStudent() {
        if (isEnrolled) {
            isEnrolled = false;
            System.out.println("❌ Student withdrawn from course.");
        } else {
            System.out.println("ℹ️ Student is already withdrawn.");
        }
    }
    
    public String getPerformanceLevel() {
        if (gpa >= 90) return "Excellent";
        else if (gpa >= 80) return "Very Good";
        else if (gpa >= 70) return "Good";
        else if (gpa >= 60) return "Average";
        else if (gpa >= 50) return "Below Average";
        else return "Poor";
    }
    
    public void displayStudentInfo() {
        System.out.println("=== Student Information ===");
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("GPA: " + String.format("%.2f", gpa));
        System.out.println("Performance: " + getPerformanceLevel());
        System.out.println("Status: " + (isEnrolled ? "Enrolled ✅" : "Withdrawn ❌"));
        System.out.println("===========================\n");
    }
}

// Main class to demonstrate Encapsulation
public class Encapsulation {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                   ENCAPSULATION DEMO                    ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        // ===============================
        // BANK ACCOUNT ENCAPSULATION DEMO
        // ===============================
        System.out.println("\n🏦 BANK ACCOUNT ENCAPSULATION:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Create bank accounts
        BankAccount account1 = new BankAccount("ACC001", "Alice Johnson", 5000.0, "Savings", 1234);
        BankAccount account2 = new BankAccount("ACC002", "Bob Smith", 3000.0, "Current", 5678);
        
        // Display account info (sensitive data is hidden)
        account1.displayAccountInfo();
        account2.displayAccountInfo();
        
        // Try to access balance without PIN (will fail)
        System.out.println("--- Attempting to access balance without PIN ---");
        double balance = account1.getBalance(9999); // Wrong PIN
        
        // Access balance with correct PIN
        System.out.println("--- Accessing balance with correct PIN ---");
        balance = account1.getBalance(1234); // Correct PIN
        System.out.println("Alice's balance: $" + balance);
        
        // Perform banking operations
        System.out.println("\n--- Banking Operations ---");
        account1.deposit(500.0);
        account1.withdraw(200.0, 1234);
        account1.withdraw(200.0, 9999); // Wrong PIN
        
        // Transfer money
        System.out.println("\n--- Money Transfer ---");
        account1.transfer(account2, 1000.0, 1234);
        
        // Try to change sensitive data
        System.out.println("\n--- Changing Account Settings ---");
        account1.setAccountHolderName("Alice Johnson-Smith");
        account1.setAccountType("Fixed");
        account1.setPinNumber(1234, 4567);
        
        // ===============================
        // STUDENT ENCAPSULATION DEMO
        // ===============================
        System.out.println("\n👨‍🎓 STUDENT ENCAPSULATION:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Create students
        Student student1 = new Student("STU001", "John Doe", 20, "john.doe@email.com", "Computer Science");
        Student student2 = new Student("STU002", "Jane Smith", 19, "jane.smith@email.com", "Mathematics");
        
        // Display initial info
        student1.displayStudentInfo();
        
        // Update student information with validation
        System.out.println("--- Updating Student Information ---");
        student1.setAge(21);
        student1.setEmail("john.newemail@gmail.com");
        student1.setAge(150); // Invalid age
        student1.setEmail("invalid-email"); // Invalid email
        
        // Update GPA
        System.out.println("\n--- Updating GPA ---");
        double[] marks1 = {85.0, 92.0, 78.0, 88.0, 90.0};
        student1.updateGPA(marks1);
        
        double[] marks2 = {75.0, 82.0, 79.0, 85.0, 80.0};
        student2.updateGPA(marks2);
        
        // Display updated info
        System.out.println("\n--- Updated Student Information ---");
        student1.displayStudentInfo();
        student2.displayStudentInfo();
        
        // Test enrollment operations
        System.out.println("--- Enrollment Operations ---");
        student1.withdrawStudent();
        student1.enrollStudent();
        
        // ============================
        // DEMONSTRATING DATA SECURITY
        // ============================
        System.out.println("🔒 DATA SECURITY DEMONSTRATION:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ Private variables cannot be accessed directly:");
        System.out.println("   // account1.balance = 999999;  // ❌ This would cause compilation error");
        System.out.println("   // student1.gpa = 100;         // ❌ This would cause compilation error");
        
        System.out.println("\n✅ Data can only be modified through controlled methods:");
        System.out.println("   account1.deposit(100);   // ✅ Controlled access");
        System.out.println("   student1.setAge(22);     // ✅ With validation");
        
        System.out.println("\n✅ Sensitive operations require validation:");
        System.out.println("   account1.withdraw(100, PIN);  // ✅ Requires PIN");
        System.out.println("   account1.setPinNumber(old, new); // ✅ Requires old PIN");
        
        // ============================
        // KEY CONCEPTS DEMONSTRATION
        // ============================
        System.out.println("\n🎯 KEY BENEFITS OF ENCAPSULATION:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("🔐 DATA SECURITY: Private variables prevent unauthorized access");
        System.out.println("✅ DATA VALIDATION: Setter methods can validate input");
        System.out.println("🔧 FLEXIBILITY: Internal implementation can change without affecting users");
        System.out.println("🛡️ CONTROLLED ACCESS: Methods control how data is accessed/modified");
        System.out.println("📋 BUSINESS RULES: Logic can be enforced in methods");
        System.out.println("🐛 EASIER DEBUGGING: Centralized access points for data");
        
        System.out.println("\n💡 ENCAPSULATION BEST PRACTICES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("• Make instance variables private");
        System.out.println("• Provide public getter/setter methods");
        System.out.println("• Add validation in setter methods");
        System.out.println("• Use meaningful method names");
        System.out.println("• Hide implementation details");
        System.out.println("• Expose only necessary functionality");
        
        System.out.println("\n🎓 Ready to move to 05_Access_Modifiers.java!");
    }
}

/*
 * EXPECTED OUTPUT SAMPLE:
 * ═══════════════════════════════════════════════════════════
 *                    ENCAPSULATION DEMO
 * ═══════════════════════════════════════════════════════════
 * 
 * 🏦 BANK ACCOUNT ENCAPSULATION:
 * ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 * 🏦 Bank account created successfully for: Alice Johnson
 * 🏦 Bank account created successfully for: Bob Smith
 * === Account Information ===
 * Account Number: ACC001
 * Account Holder: Alice Johnson
 * Account Type: Savings
 * Status: Active ✅
 * Balance: [Protected - Use PIN to view]
 * ===========================
 * 
 * ... and so on
 */