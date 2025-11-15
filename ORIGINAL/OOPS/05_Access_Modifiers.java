/*
 * ===============================================================
 *                    JAVA OOP CONCEPTS - PART 5
 *                      ACCESS MODIFIERS
 * ===============================================================
 * 
 * WHAT ARE ACCESS MODIFIERS?
 * - Access modifiers control the visibility and accessibility of classes, methods, and variables
 * - They determine who can access what parts of your code
 * - Java has 4 access modifiers: public, private, protected, and package-private (default)
 * 
 * TYPES OF ACCESS MODIFIERS:
 * 
 * 1. PUBLIC (+)
 *    - Accessible from anywhere (same class, same package, different package, subclass)
 *    - Most permissive access level
 * 
 * 2. PRIVATE (-)
 *    - Accessible only within the same class
 *    - Most restrictive access level
 * 
 * 3. PROTECTED (#)
 *    - Accessible within same package AND by subclasses (even in different packages)
 *    - Used for inheritance scenarios
 * 
 * 4. PACKAGE-PRIVATE (default) (~)
 *    - No modifier specified
 *    - Accessible within the same package only
 * 
 * ACCESS LEVEL TABLE:
 * ┌─────────────┬───────────┬─────────┬─────────────┬───────────────┐
 * │ Modifier    │ Same Class│ Package │ Subclass    │ Different Pkg │
 * ├─────────────┼───────────┼─────────┼─────────────┼───────────────┤
 * │ public      │    ✅     │   ✅    │     ✅      │      ✅       │
 * │ protected   │    ✅     │   ✅    │     ✅      │      ❌       │
 * │ default     │    ✅     │   ✅    │     ❌      │      ❌       │
 * │ private     │    ✅     │   ❌    │     ❌      │      ❌       │
 * └─────────────┴───────────┴─────────┴─────────────┴───────────────┘
 */

// Example 1: Demonstrating All Access Modifiers
class Employee {
    // PUBLIC - Accessible from anywhere
    public String employeeId;
    public String companyName;
    
    // PRIVATE - Accessible only within this class
    private double salary;
    private String socialSecurityNumber;
    private int loginAttempts;
    
    // PROTECTED - Accessible within package and by subclasses
    protected String department;
    protected String managerId;
    
    // PACKAGE-PRIVATE (default) - Accessible within same package only
    String officeLocation;
    String phoneExtension;
    
    // Constructor
    public Employee(String id, String name, double sal, String dept, String company) {
        this.employeeId = id;
        this.companyName = company;
        this.salary = sal;
        this.department = dept;
        this.officeLocation = "HQ Building";
        this.phoneExtension = "1234";
        this.loginAttempts = 0;
        System.out.println("👨‍💼 Employee created: " + name + " (ID: " + id + ")");
    }
    
    // PUBLIC METHODS - Can be called from anywhere
    public void displayPublicInfo() {
        System.out.println("=== Public Employee Information ===");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Company: " + companyName);
        System.out.println("===================================");
    }
    
    public double calculateAnnualBonus() {
        // Private method can be called within same class
        return calculateBonusPercentage() * salary;
    }
    
    public void clockIn() {
        System.out.println("🕐 " + employeeId + " clocked in at " + getCurrentTime());
        resetLoginAttempts(); // Calling private method
    }
    
    // PRIVATE METHODS - Only accessible within this class
    private double calculateBonusPercentage() {
        // Complex business logic hidden from outside
        if (salary > 100000) return 0.15;      // 15% for high earners
        else if (salary > 75000) return 0.10;  // 10% for mid-level
        else if (salary > 50000) return 0.08;  // 8% for entry-level
        else return 0.05;                      // 5% minimum
    }
    
    private void resetLoginAttempts() {
        this.loginAttempts = 0;
        System.out.println("🔓 Login attempts reset for " + employeeId);
    }
    
    private String getCurrentTime() {
        return "09:00 AM"; // Simplified for demo
    }
    
    // PROTECTED METHODS - Accessible by subclasses and same package
    protected void updateDepartment(String newDept) {
        this.department = newDept;
        System.out.println("🏢 Department updated to: " + newDept);
    }
    
    protected void assignManager(String managerId) {
        this.managerId = managerId;
        System.out.println("👔 Manager assigned: " + managerId);
    }
    
    protected String getDepartment() {
        return department;
    }
    
    // PACKAGE-PRIVATE METHODS - Accessible within same package
    void updateOfficeLocation(String location) {
        this.officeLocation = location;
        System.out.println("🏢 Office location updated to: " + location);
    }
    
    void setPhoneExtension(String extension) {
        this.phoneExtension = extension;
        System.out.println("📞 Phone extension set to: " + extension);
    }
    
    String getOfficeLocation() {
        return officeLocation;
    }
    
    // Method to demonstrate access within same class
    public void demonstrateInternalAccess() {
        System.out.println("\n🔍 ACCESSING MEMBERS WITHIN SAME CLASS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("✅ Public field: " + employeeId);
        System.out.println("✅ Private field: $" + salary);
        System.out.println("✅ Protected field: " + department);
        System.out.println("✅ Package field: " + officeLocation);
        
        // All methods accessible within same class
        calculateBonusPercentage();
        resetLoginAttempts();
        updateDepartment("IT");
        setPhoneExtension("5678");
    }
}

// Example 2: Manager class extending Employee (Inheritance)
class Manager extends Employee {
    private int teamSize;
    public String managementLevel;
    
    public Manager(String id, String name, double sal, String dept, String company, int teamSize) {
        super(id, name, sal, dept, company);
        this.teamSize = teamSize;
        this.managementLevel = "Mid-Level";
        System.out.println("👔 Manager role assigned with team size: " + teamSize);
    }
    
    public void demonstrateInheritanceAccess() {
        System.out.println("\n🔍 ACCESSING PARENT CLASS MEMBERS FROM SUBCLASS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // PUBLIC - Accessible ✅
        System.out.println("✅ Public field from parent: " + employeeId);
        System.out.println("✅ Public field from parent: " + companyName);
        
        // PROTECTED - Accessible ✅ (key benefit of protected)
        System.out.println("✅ Protected field from parent: " + department);
        updateDepartment("Management"); // Protected method accessible
        
        // PACKAGE-PRIVATE - Accessible ✅ (if in same package)
        System.out.println("✅ Package field from parent: " + officeLocation);
        updateOfficeLocation("Executive Floor"); // Package method accessible
        
        // PRIVATE - NOT accessible ❌
        // System.out.println(salary); // ❌ This would cause compilation error
        // calculateBonusPercentage(); // ❌ This would cause compilation error
        
        System.out.println("❌ Private fields/methods from parent are NOT accessible");
    }
    
    public void conductMeeting() {
        System.out.println("📋 " + employeeId + " is conducting a team meeting");
        // Can access protected members from parent
        System.out.println("Meeting for department: " + getDepartment());
    }
}

// Example 3: HR Department class (same package)
class HRDepartment {
    
    public void processEmployee(Employee emp) {
        System.out.println("\n🏢 HR DEPARTMENT PROCESSING EMPLOYEE:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // PUBLIC - Accessible ✅
        System.out.println("✅ Employee ID: " + emp.employeeId);
        System.out.println("✅ Company: " + emp.companyName);
        emp.displayPublicInfo();
        
        // PROTECTED - Accessible ✅ (same package)
        System.out.println("✅ Department: " + emp.department);
        emp.updateDepartment("HR-Updated");
        
        // PACKAGE-PRIVATE - Accessible ✅ (same package)
        System.out.println("✅ Office Location: " + emp.officeLocation);
        emp.updateOfficeLocation("HR Building");
        
        // PRIVATE - NOT accessible ❌
        // System.out.println(emp.salary); // ❌ Compilation error
        // emp.calculateBonusPercentage(); // ❌ Compilation error
        
        System.out.println("❌ Private members are NOT accessible from other classes");
    }
    
    // Package-private method
    void updateEmployeeRecords(Employee emp) {
        System.out.println("📋 Updating records for: " + emp.employeeId);
        emp.setPhoneExtension("HR-1000");
    }
}

// Example 4: Demonstrating Access Levels
class AccessLevelDemo {
    
    public void demonstrateAccessLevels() {
        System.out.println("\n📊 ACCESS LEVEL DEMONSTRATION:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        Employee emp = new Employee("EMP001", "Alice Johnson", 75000, "Engineering", "TechCorp");
        Manager mgr = new Manager("MGR001", "Bob Smith", 95000, "Engineering", "TechCorp", 5);
        HRDepartment hr = new HRDepartment();
        
        // Demonstrate access from different contexts
        System.out.println("\n1. Access from same package (HRDepartment):");
        hr.processEmployee(emp);
        
        System.out.println("\n2. Access from subclass (Manager):");
        mgr.demonstrateInheritanceAccess();
        
        System.out.println("\n3. Access from same class (Employee):");
        emp.demonstrateInternalAccess();
        
        // Public methods can be called from anywhere
        System.out.println("\n4. Public methods accessible from anywhere:");
        emp.clockIn();
        mgr.conductMeeting();
        double bonus = emp.calculateAnnualBonus();
        System.out.println("Annual bonus: $" + bonus);
    }
}

// Main class to demonstrate Access Modifiers
public class Access_Modifiers {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                   ACCESS MODIFIERS DEMO                 ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        AccessLevelDemo demo = new AccessLevelDemo();
        demo.demonstrateAccessLevels();
        
        // ============================
        // PRACTICAL ACCESS EXAMPLES
        // ============================
        System.out.println("\n💼 PRACTICAL ACCESS EXAMPLES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        Employee employee = new Employee("EMP002", "Carol Davis", 65000, "Marketing", "TechCorp");
        
        // What we CAN access (public)
        System.out.println("\n✅ What we CAN access from main method:");
        System.out.println("   Employee ID: " + employee.employeeId);
        System.out.println("   Company: " + employee.companyName);
        employee.displayPublicInfo();
        employee.clockIn();
        
        // What we CAN access (package-private - same package)
        System.out.println("\n✅ Package-private access (same package):");
        System.out.println("   Office Location: " + employee.getOfficeLocation());
        employee.updateOfficeLocation("Main Campus");
        
        // What we CANNOT access (would cause compilation errors)
        System.out.println("\n❌ What we CANNOT access (compilation errors):");
        System.out.println("   // employee.salary;                    // ❌ Private");
        System.out.println("   // employee.socialSecurityNumber;      // ❌ Private");
        System.out.println("   // employee.calculateBonusPercentage(); // ❌ Private");
        
        // ============================
        // BEST PRACTICES SUMMARY
        // ============================
        System.out.println("\n💡 ACCESS MODIFIER BEST PRACTICES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("🔐 PRIVATE - Use for:");
        System.out.println("   • Internal implementation details");
        System.out.println("   • Sensitive data (passwords, salary)");
        System.out.println("   • Helper methods not meant for external use");
        
        System.out.println("\n📦 PACKAGE-PRIVATE - Use for:");
        System.out.println("   • Classes/methods used within same package");
        System.out.println("   • Internal API between related classes");
        System.out.println("   • Default choice when no modifier specified");
        
        System.out.println("\n🛡️ PROTECTED - Use for:");
        System.out.println("   • Members that subclasses need to access");
        System.out.println("   • Inheritance-related functionality");
        System.out.println("   • Template method patterns");
        
        System.out.println("\n🌐 PUBLIC - Use for:");
        System.out.println("   • APIs meant to be used by external code");
        System.out.println("   • Main functionality of the class");
        System.out.println("   • Interfaces between different modules");
        
        // ============================
        // SECURITY IMPLICATIONS
        // ============================
        System.out.println("\n🔒 SECURITY IMPLICATIONS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ Proper access control prevents:");
        System.out.println("   • Unauthorized data modification");
        System.out.println("   • Breaking encapsulation");
        System.out.println("   • Unintended side effects");
        System.out.println("   • Security vulnerabilities");
        
        System.out.println("\n⚠️ Common mistakes:");
        System.out.println("   • Making everything public (breaks encapsulation)");
        System.out.println("   • Using protected when private is sufficient");
        System.out.println("   • Not considering inheritance in access design");
        System.out.println("   • Exposing internal implementation details");
        
        // ============================
        // REAL-WORLD USAGE GUIDELINES
        // ============================
        System.out.println("\n🎯 REAL-WORLD USAGE GUIDELINES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("1. Start with most restrictive (private)");
        System.out.println("2. Increase access only when necessary");
        System.out.println("3. Use public for well-defined APIs");
        System.out.println("4. Use protected for inheritance scenarios");
        System.out.println("5. Document access decisions in comments");
        System.out.println("6. Regular review of access modifiers");
        
        System.out.println("\n🎓 Ready to move to 06_Inheritance.java!");
    }
}

/*
 * COMPILATION NOTE:
 * The code showing "compilation errors" in comments would actually cause
 * compilation errors if uncommented. They are shown as comments to 
 * demonstrate what NOT to do.
 * 
 * ACCESS MODIFIER SUMMARY:
 * ┌─────────────┬───────────┬─────────┬─────────────┬───────────────┐
 * │ Modifier    │ Same Class│ Package │ Subclass    │ Different Pkg │
 * ├─────────────┼───────────┼─────────┼─────────────┼───────────────┤
 * │ public      │    ✅     │   ✅    │     ✅      │      ✅       │
 * │ protected   │    ✅     │   ✅    │     ✅      │      ❌       │
 * │ default     │    ✅     │   ✅    │     ❌      │      ❌       │
 * │ private     │    ✅     │   ❌    │     ❌      │      ❌       │
 * └─────────────┴───────────┴─────────┴─────────────┴───────────────┘
 */