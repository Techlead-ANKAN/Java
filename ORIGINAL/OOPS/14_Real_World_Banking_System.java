/*
 * ===============================================================
 *                    JAVA OOP CONCEPTS - PART 14
 *                    REAL-WORLD EXAMPLE
 *                  BANKING SYSTEM PROJECT
 * ===============================================================
 * 
 * COMPREHENSIVE OOP EXAMPLE:
 * This file demonstrates ALL major OOP concepts in a practical, real-world scenario
 * - A complete Banking System that shows how OOP principles work together
 * - Demonstrates: Classes, Objects, Inheritance, Polymorphism, Encapsulation, Abstraction
 * - Shows: Constructors, Method Overriding, Access Modifiers, Static members, Interfaces
 * - Includes: Exception Handling, Collections, Design Patterns
 * 
 * PROJECT OVERVIEW:
 * 🏦 Banking System with multiple account types
 * 👤 Customer management with different customer categories
 * 💳 Transaction processing with history tracking
 * 🔒 Security features and validation
 * 📊 Reporting and analytics functionality
 */

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// ===============================
// INTERFACES (Abstraction)
// ===============================

interface Transferable {
    boolean transfer(Account toAccount, double amount);
    double getTransferLimit();
}

interface InterestBearing {
    void calculateInterest();
    double getInterestRate();
    void applyInterest();
}

interface Reportable {
    void generateStatement();
    List<Transaction> getTransactionHistory();
}

// ===============================
// ENUMS AND UTILITY CLASSES
// ===============================

enum TransactionType {
    DEPOSIT("Deposit", "💰"),
    WITHDRAWAL("Withdrawal", "💸"),
    TRANSFER_IN("Transfer In", "⬅️💰"),
    TRANSFER_OUT("Transfer Out", "➡️💸"),
    INTEREST("Interest", "📈"),
    FEE("Fee", "💳");
    
    private final String displayName;
    private final String emoji;
    
    TransactionType(String displayName, String emoji) {
        this.displayName = displayName;
        this.emoji = emoji;
    }
    
    public String getDisplayName() { return displayName; }
    public String getEmoji() { return emoji; }
}

enum CustomerType {
    REGULAR("Regular Customer", 0.95),
    PREMIUM("Premium Customer", 0.90),
    VIP("VIP Customer", 0.85);
    
    private final String description;
    private final double feeMultiplier;
    
    CustomerType(String description, double feeMultiplier) {
        this.description = description;
        this.feeMultiplier = feeMultiplier;
    }
    
    public String getDescription() { return description; }
    public double getFeeMultiplier() { return feeMultiplier; }
}

// ===============================
// TRANSACTION CLASS (Encapsulation)
// ===============================

class Transaction {
    private static long transactionCounter = 1000;
    
    private final long transactionId;
    private final LocalDateTime timestamp;
    private final TransactionType type;
    private final double amount;
    private final double balanceAfter;
    private final String description;
    private final String accountNumber;
    
    public Transaction(TransactionType type, double amount, double balanceAfter, 
                      String description, String accountNumber) {
        this.transactionId = ++transactionCounter;
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.description = description;
        this.accountNumber = accountNumber;
    }
    
    // Getters (Encapsulation - controlled access)
    public long getTransactionId() { return transactionId; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public TransactionType getType() { return type; }
    public double getAmount() { return amount; }
    public double getBalanceAfter() { return balanceAfter; }
    public String getDescription() { return description; }
    public String getAccountNumber() { return accountNumber; }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("%s | %s %s | $%.2f | Balance: $%.2f | %s",
                timestamp.format(formatter),
                type.getEmoji(),
                type.getDisplayName(),
                amount,
                balanceAfter,
                description);
    }
}

// ===============================
// PERSON CLASS (Base Class)
// ===============================

abstract class Person {
    protected String name;
    protected String email;
    protected String phone;
    protected LocalDateTime createdDate;
    
    public Person(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.createdDate = LocalDateTime.now();
        System.out.println("👤 Person created: " + name);
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract void displayInfo();
    
    // Concrete methods available to all subclasses
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public LocalDateTime getCreatedDate() { return createdDate; }
    
    protected void updateContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
        System.out.println("📞 Contact info updated for " + name);
    }
}

// ===============================
// CUSTOMER CLASS (Inheritance)
// ===============================

class Customer extends Person {
    private static int customerIdCounter = 1000;
    
    private final int customerId;
    private CustomerType customerType;
    private List<Account> accounts;
    private double totalBalance;
    
    public Customer(String name, String email, String phone, CustomerType type) {
        super(name, email, phone); // Call parent constructor
        this.customerId = ++customerIdCounter;
        this.customerType = type;
        this.accounts = new ArrayList<>();
        this.totalBalance = 0.0;
        
        System.out.println("🏦 Customer ID " + customerId + " created: " + type.getDescription());
    }
    
    // Implementing abstract method from Person
    @Override
    public void displayInfo() {
        System.out.println("\n👤 CUSTOMER INFORMATION:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Type: " + customerType.getDescription());
        System.out.println("Total Accounts: " + accounts.size());
        System.out.println("Total Balance: $" + String.format("%.2f", totalBalance));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Member Since: " + createdDate.format(formatter));
    }
    
    public void addAccount(Account account) {
        accounts.add(account);
        updateTotalBalance();
        System.out.println("📋 Account " + account.getAccountNumber() + " added to customer " + name);
    }
    
    private void updateTotalBalance() {
        totalBalance = accounts.stream().mapToDouble(Account::getBalance).sum();
    }
    
    public void upgradeCustomerType(CustomerType newType) {
        if (newType.ordinal() > this.customerType.ordinal()) {
            CustomerType oldType = this.customerType;
            this.customerType = newType;
            System.out.println("⬆️ Customer " + name + " upgraded from " + 
                              oldType.getDescription() + " to " + newType.getDescription());
        } else {
            System.out.println("❌ Cannot downgrade customer type");
        }
    }
    
    // Getters
    public int getCustomerId() { return customerId; }
    public CustomerType getCustomerType() { return customerType; }
    public List<Account> getAccounts() { return new ArrayList<>(accounts); } // Return copy for encapsulation
    public double getTotalBalance() { 
        updateTotalBalance(); 
        return totalBalance; 
    }
}

// ===============================
// ACCOUNT CLASSES (Inheritance Hierarchy)
// ===============================

// Abstract base Account class
abstract class Account implements Reportable {
    protected static long accountNumberCounter = 100000;
    
    protected final String accountNumber;
    protected final Customer owner;
    protected double balance;
    protected final LocalDateTime openDate;
    protected List<Transaction> transactionHistory;
    protected boolean isActive;
    
    public Account(Customer owner, double initialDeposit) {
        this.accountNumber = String.valueOf(++accountNumberCounter);
        this.owner = owner;
        this.balance = 0.0; // Initialize to 0, then deposit
        this.openDate = LocalDateTime.now();
        this.transactionHistory = new ArrayList<>();
        this.isActive = true;
        
        System.out.println("🏦 Account " + accountNumber + " created for " + owner.getName());
        
        // Make initial deposit
        if (initialDeposit > 0) {
            deposit(initialDeposit);
        }
    }
    
    // Template method pattern - defines algorithm, subclasses can override steps
    public final boolean withdraw(double amount) {
        if (!validateWithdrawal(amount)) {
            return false;
        }
        
        double fee = calculateWithdrawalFee(amount);
        double totalDeduction = amount + fee;
        
        if (balance >= totalDeduction) {
            balance -= totalDeduction;
            
            // Record withdrawal transaction
            addTransaction(TransactionType.WITHDRAWAL, amount, 
                          "Withdrawal - " + getAccountType());
            
            // Record fee if applicable
            if (fee > 0) {
                addTransaction(TransactionType.FEE, fee, "Withdrawal fee");
            }
            
            System.out.println("✅ Withdrawal successful: $" + String.format("%.2f", amount));
            if (fee > 0) {
                System.out.println("💳 Fee charged: $" + String.format("%.2f", fee));
            }
            return true;
        } else {
            System.out.println("❌ Insufficient funds for withdrawal");
            return false;
        }
    }
    
    public final boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("❌ Deposit amount must be positive");
            return false;
        }
        
        balance += amount;
        addTransaction(TransactionType.DEPOSIT, amount, "Deposit - " + getAccountType());
        System.out.println("✅ Deposit successful: $" + String.format("%.2f", amount));
        return true;
    }
    
    // Abstract methods - must be implemented by subclasses
    protected abstract boolean validateWithdrawal(double amount);
    protected abstract double calculateWithdrawalFee(double amount);
    public abstract String getAccountType();
    
    // Protected method for subclasses
    protected void addTransaction(TransactionType type, double amount, String description) {
        Transaction transaction = new Transaction(type, amount, balance, description, accountNumber);
        transactionHistory.add(transaction);
    }
    
    // Interface implementation
    @Override
    public void generateStatement() {
        System.out.println("\n📄 ACCOUNT STATEMENT - " + getAccountType().toUpperCase());
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Account: " + accountNumber + " | Owner: " + owner.getName());
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
        System.out.println("\nTransaction History:");
        
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            transactionHistory.stream()
                .sorted((t1, t2) -> t2.getTimestamp().compareTo(t1.getTimestamp()))
                .limit(10) // Show last 10 transactions
                .forEach(System.out::println);
        }
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }
    
    @Override
    public List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory); // Return copy for encapsulation
    }
    
    // Getters
    public String getAccountNumber() { return accountNumber; }
    public Customer getOwner() { return owner; }
    public double getBalance() { return balance; }
    public LocalDateTime getOpenDate() { return openDate; }
    public boolean isActive() { return isActive; }
}

// Savings Account - implements InterestBearing
class SavingsAccount extends Account implements InterestBearing {
    private static final double INTEREST_RATE = 0.025; // 2.5% annual
    private static final double MIN_BALANCE = 100.0;
    private static final double WITHDRAWAL_FEE = 2.0;
    private static final int FREE_WITHDRAWALS_PER_MONTH = 3;
    
    private int withdrawalsThisMonth;
    private LocalDateTime lastInterestApplication;
    
    public SavingsAccount(Customer owner, double initialDeposit) {
        super(owner, initialDeposit);
        this.withdrawalsThisMonth = 0;
        this.lastInterestApplication = LocalDateTime.now();
        System.out.println("💰 Savings Account features: 2.5% interest, min balance $100");
    }
    
    @Override
    protected boolean validateWithdrawal(double amount) {
        if (!isActive) {
            System.out.println("❌ Account is not active");
            return false;
        }
        
        if (amount <= 0) {
            System.out.println("❌ Withdrawal amount must be positive");
            return false;
        }
        
        double fee = calculateWithdrawalFee(amount);
        if (balance - amount - fee < MIN_BALANCE) {
            System.out.println("❌ Withdrawal would bring balance below minimum $" + MIN_BALANCE);
            return false;
        }
        
        return true;
    }
    
    @Override
    protected double calculateWithdrawalFee(double amount) {
        // Apply customer type discount
        double baseFee = (withdrawalsThisMonth >= FREE_WITHDRAWALS_PER_MONTH) ? WITHDRAWAL_FEE : 0.0;
        return baseFee * owner.getCustomerType().getFeeMultiplier();
    }
    
    @Override
    public String getAccountType() {
        return "Savings Account";
    }
    
    // InterestBearing interface implementation
    @Override
    public void calculateInterest() {
        double monthlyInterest = balance * (INTEREST_RATE / 12);
        System.out.println("📈 Monthly interest calculated: $" + String.format("%.2f", monthlyInterest));
    }
    
    @Override
    public double getInterestRate() {
        return INTEREST_RATE;
    }
    
    @Override
    public void applyInterest() {
        double monthlyInterest = balance * (INTEREST_RATE / 12);
        if (monthlyInterest > 0) {
            balance += monthlyInterest;
            addTransaction(TransactionType.INTEREST, monthlyInterest, 
                          "Monthly interest (" + String.format("%.2f", INTEREST_RATE * 100) + "% APR)");
            lastInterestApplication = LocalDateTime.now();
            System.out.println("📈 Interest applied: $" + String.format("%.2f", monthlyInterest));
        }
    }
}

// Checking Account - implements Transferable
class CheckingAccount extends Account implements Transferable {
    private static final double OVERDRAFT_LIMIT = 500.0;
    private static final double OVERDRAFT_FEE = 35.0;
    private static final double TRANSFER_LIMIT = 10000.0;
    
    private boolean overdraftProtection;
    
    public CheckingAccount(Customer owner, double initialDeposit, boolean overdraftProtection) {
        super(owner, initialDeposit);
        this.overdraftProtection = overdraftProtection;
        System.out.println("💳 Checking Account features: Overdraft protection: " + overdraftProtection);
    }
    
    @Override
    protected boolean validateWithdrawal(double amount) {
        if (!isActive) {
            System.out.println("❌ Account is not active");
            return false;
        }
        
        if (amount <= 0) {
            System.out.println("❌ Withdrawal amount must be positive");
            return false;
        }
        
        double availableBalance = overdraftProtection ? balance + OVERDRAFT_LIMIT : balance;
        double fee = calculateWithdrawalFee(amount);
        
        if (amount + fee > availableBalance) {
            System.out.println("❌ Insufficient funds (including overdraft protection)");
            return false;
        }
        
        return true;
    }
    
    @Override
    protected double calculateWithdrawalFee(double amount) {
        double fee = 0.0;
        
        // Check if withdrawal would cause overdraft
        if (balance < amount && overdraftProtection) {
            fee = OVERDRAFT_FEE * owner.getCustomerType().getFeeMultiplier();
            System.out.println("⚠️ Overdraft fee will be charged: $" + String.format("%.2f", fee));
        }
        
        return fee;
    }
    
    @Override
    public String getAccountType() {
        return "Checking Account";
    }
    
    // Transferable interface implementation
    @Override
    public boolean transfer(Account toAccount, double amount) {
        if (amount > TRANSFER_LIMIT) {
            System.out.println("❌ Transfer amount exceeds limit of $" + String.format("%.2f", TRANSFER_LIMIT));
            return false;
        }
        
        if (withdraw(amount)) {
            // Remove the withdrawal transaction and add transfer out
            transactionHistory.remove(transactionHistory.size() - 1);
            addTransaction(TransactionType.TRANSFER_OUT, amount, 
                          "Transfer to account " + toAccount.getAccountNumber());
            
            if (toAccount.deposit(amount)) {
                // Update recipient's last transaction to show transfer in
                toAccount.transactionHistory.remove(toAccount.transactionHistory.size() - 1);
                toAccount.addTransaction(TransactionType.TRANSFER_IN, amount, 
                                       "Transfer from account " + this.accountNumber);
                
                System.out.println("✅ Transfer successful: $" + String.format("%.2f", amount) + 
                                 " to account " + toAccount.getAccountNumber());
                return true;
            }
        }
        
        System.out.println("❌ Transfer failed");
        return false;
    }
    
    @Override
    public double getTransferLimit() {
        return TRANSFER_LIMIT;
    }
    
    public void setOverdraftProtection(boolean enabled) {
        this.overdraftProtection = enabled;
        System.out.println("🔒 Overdraft protection " + (enabled ? "enabled" : "disabled"));
    }
}

// Business Account - extends CheckingAccount with additional features
class BusinessAccount extends CheckingAccount implements InterestBearing {
    private static final double BUSINESS_INTEREST_RATE = 0.015; // 1.5% annual
    private static final double MONTHLY_FEE = 25.0;
    private static final double HIGH_BALANCE_THRESHOLD = 50000.0;
    
    private String businessName;
    private String taxId;
    private LocalDateTime lastFeeCharge;
    
    public BusinessAccount(Customer owner, double initialDeposit, String businessName, String taxId) {
        super(owner, initialDeposit, true); // Business accounts have overdraft protection
        this.businessName = businessName;
        this.taxId = taxId;
        this.lastFeeCharge = LocalDateTime.now();
        System.out.println("🏢 Business Account for: " + businessName);
    }
    
    @Override
    public String getAccountType() {
        return "Business Account";
    }
    
    // InterestBearing implementation for business accounts
    @Override
    public void calculateInterest() {
        if (balance >= HIGH_BALANCE_THRESHOLD) {
            double monthlyInterest = balance * (BUSINESS_INTEREST_RATE / 12);
            System.out.println("📈 Business account interest calculated: $" + String.format("%.2f", monthlyInterest));
        } else {
            System.out.println("📊 Balance below threshold for business interest");
        }
    }
    
    @Override
    public double getInterestRate() {
        return BUSINESS_INTEREST_RATE;
    }
    
    @Override
    public void applyInterest() {
        if (balance >= HIGH_BALANCE_THRESHOLD) {
            double monthlyInterest = balance * (BUSINESS_INTEREST_RATE / 12);
            balance += monthlyInterest;
            addTransaction(TransactionType.INTEREST, monthlyInterest, 
                          "Business account interest (" + String.format("%.2f", BUSINESS_INTEREST_RATE * 100) + "% APR)");
            System.out.println("📈 Business interest applied: $" + String.format("%.2f", monthlyInterest));
        }
    }
    
    public void chargeMonthlyFee() {
        double fee = MONTHLY_FEE * owner.getCustomerType().getFeeMultiplier();
        if (balance >= fee) {
            balance -= fee;
            addTransaction(TransactionType.FEE, fee, "Monthly business account fee");
            lastFeeCharge = LocalDateTime.now();
            System.out.println("💳 Monthly fee charged: $" + String.format("%.2f", fee));
        } else {
            System.out.println("⚠️ Insufficient funds for monthly fee");
        }
    }
    
    // Business-specific methods
    public String getBusinessName() { return businessName; }
    public String getTaxId() { return taxId; }
}

// ===============================
// BANK CLASS (Singleton Pattern)
// ===============================

class Bank {
    private static Bank instance;
    private static final String BANK_NAME = "Java OOP Banking System";
    
    private Map<Integer, Customer> customers;
    private Map<String, Account> accounts;
    private List<Transaction> allTransactions;
    
    // Singleton pattern - private constructor
    private Bank() {
        this.customers = new HashMap<>();
        this.accounts = new HashMap<>();
        this.allTransactions = new ArrayList<>();
        System.out.println("🏦 " + BANK_NAME + " initialized");
    }
    
    // Singleton pattern - get instance
    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
    
    public Customer createCustomer(String name, String email, String phone, CustomerType type) {
        Customer customer = new Customer(name, email, phone, type);
        customers.put(customer.getCustomerId(), customer);
        System.out.println("✅ Customer registered with bank");
        return customer;
    }
    
    public Account createAccount(Customer customer, String accountType, double initialDeposit, Object... params) {
        Account account = null;
        
        switch (accountType.toLowerCase()) {
            case "savings":
                account = new SavingsAccount(customer, initialDeposit);
                break;
            case "checking":
                boolean overdraft = params.length > 0 ? (Boolean) params[0] : false;
                account = new CheckingAccount(customer, initialDeposit, overdraft);
                break;
            case "business":
                String businessName = params.length > 0 ? (String) params[0] : "Business";
                String taxId = params.length > 1 ? (String) params[1] : "000-00-0000";
                account = new BusinessAccount(customer, initialDeposit, businessName, taxId);
                break;
            default:
                System.out.println("❌ Unknown account type: " + accountType);
                return null;
        }
        
        if (account != null) {
            accounts.put(account.getAccountNumber(), account);
            customer.addAccount(account);
            System.out.println("✅ Account created and linked to customer");
        }
        
        return account;
    }
    
    public void processMonthlyInterest() {
        System.out.println("\n📅 PROCESSING MONTHLY INTEREST:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        accounts.values().stream()
            .filter(account -> account instanceof InterestBearing)
            .forEach(account -> {
                InterestBearing interestAccount = (InterestBearing) account;
                interestAccount.applyInterest();
            });
    }
    
    public void processMonthlyFees() {
        System.out.println("\n💳 PROCESSING MONTHLY FEES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        accounts.values().stream()
            .filter(account -> account instanceof BusinessAccount)
            .forEach(account -> {
                BusinessAccount businessAccount = (BusinessAccount) account;
                businessAccount.chargeMonthlyFee();
            });
    }
    
    public void generateBankReport() {
        System.out.println("\n📊 BANK SYSTEM REPORT:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Bank: " + BANK_NAME);
        System.out.println("Total Customers: " + customers.size());
        System.out.println("Total Accounts: " + accounts.size());
        
        double totalDeposits = accounts.values().stream()
            .mapToDouble(Account::getBalance)
            .sum();
        System.out.println("Total Deposits: $" + String.format("%.2f", totalDeposits));
        
        long savingsAccounts = accounts.values().stream()
            .filter(account -> account instanceof SavingsAccount)
            .count();
        long checkingAccounts = accounts.values().stream()
            .filter(account -> account instanceof CheckingAccount)
            .filter(account -> !(account instanceof BusinessAccount))
            .count();
        long businessAccounts = accounts.values().stream()
            .filter(account -> account instanceof BusinessAccount)
            .count();
        
        System.out.println("Savings Accounts: " + savingsAccounts);
        System.out.println("Checking Accounts: " + checkingAccounts);
        System.out.println("Business Accounts: " + businessAccounts);
    }
    
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
    
    public Customer getCustomer(int customerId) {
        return customers.get(customerId);
    }
}

// ===============================
// MAIN CLASS - DEMONSTRATION
// ===============================

public class Real_World_Banking_System {
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║              REAL-WORLD OOP BANKING SYSTEM              ║");
        System.out.println("║            Complete Java OOP Demonstration              ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        // Get bank instance (Singleton pattern)
        Bank bank = Bank.getInstance();
        
        // ===============================
        // CREATE CUSTOMERS
        // ===============================
        System.out.println("\n👥 CREATING CUSTOMERS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
        
        Customer alice = bank.createCustomer("Alice Johnson", "alice@email.com", 
                                           "555-0101", CustomerType.PREMIUM);
        Customer bob = bank.createCustomer("Bob Smith", "bob@email.com", 
                                         "555-0102", CustomerType.REGULAR);
        Customer charlie = bank.createCustomer("Charlie Brown", "charlie@business.com", 
                                             "555-0103", CustomerType.VIP);
        
        // ===============================
        // CREATE ACCOUNTS
        // ===============================
        System.out.println("\n🏦 CREATING ACCOUNTS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━");
        
        // Alice - Premium customer with savings and checking
        Account aliceSavings = bank.createAccount(alice, "savings", 5000.0);
        Account aliceChecking = bank.createAccount(alice, "checking", 2000.0, true);
        
        // Bob - Regular customer with basic checking
        Account bobChecking = bank.createAccount(bob, "checking", 1500.0, false);
        
        // Charlie - VIP customer with business account
        Account charlieBusiness = bank.createAccount(charlie, "business", 50000.0, 
                                                   "Charlie's Consulting LLC", "12-3456789");
        
        // ===============================
        // BANKING OPERATIONS
        // ===============================
        System.out.println("\n💰 BANKING OPERATIONS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Deposits and withdrawals
        System.out.println("\n--- Deposits ---");
        aliceSavings.deposit(1000.0);
        bobChecking.deposit(500.0);
        charlieBusiness.deposit(10000.0);
        
        System.out.println("\n--- Withdrawals ---");
        aliceChecking.withdraw(300.0);
        bobChecking.withdraw(200.0);
        
        // Transfers (Polymorphism - CheckingAccount implements Transferable)
        System.out.println("\n--- Transfers ---");
        if (aliceChecking instanceof Transferable) {
            Transferable transferAccount = (Transferable) aliceChecking;
            transferAccount.transfer(aliceSavings, 500.0);
        }
        
        if (charlieBusiness instanceof Transferable) {
            Transferable businessTransfer = (Transferable) charlieBusiness;
            businessTransfer.transfer(bobChecking, 1000.0);
        }
        
        // ===============================
        // INTEREST CALCULATIONS
        // ===============================
        System.out.println("\n📈 INTEREST OPERATIONS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        // Apply interest to interest-bearing accounts (Polymorphism)
        List<Account> allAccounts = Arrays.asList(aliceSavings, aliceChecking, 
                                                 bobChecking, charlieBusiness);
        
        for (Account account : allAccounts) {
            if (account instanceof InterestBearing) {
                InterestBearing interestAccount = (InterestBearing) account;
                System.out.println("\n" + account.getAccountType() + " - " + account.getAccountNumber());
                interestAccount.calculateInterest();
                interestAccount.applyInterest();
            }
        }
        
        // ===============================
        // MONTHLY PROCESSING
        // ===============================
        System.out.println("\n📅 MONTHLY PROCESSING:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        bank.processMonthlyInterest();
        bank.processMonthlyFees();
        
        // ===============================
        // CUSTOMER UPGRADES
        // ===============================
        System.out.println("\n⬆️ CUSTOMER UPGRADES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
        
        bob.upgradeCustomerType(CustomerType.PREMIUM);
        
        // ===============================
        // ACCOUNT STATEMENTS
        // ===============================
        System.out.println("\n📄 ACCOUNT STATEMENTS:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        aliceSavings.generateStatement();
        aliceChecking.generateStatement();
        charlieBusiness.generateStatement();
        
        // ===============================
        // CUSTOMER INFORMATION
        // ===============================
        System.out.println("\n👤 CUSTOMER PROFILES:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━");
        
        alice.displayInfo();
        bob.displayInfo();
        charlie.displayInfo();
        
        // ===============================
        // BANK REPORT
        // ===============================
        bank.generateBankReport();
        
        // ===============================
        // OOP CONCEPTS DEMONSTRATED
        // ===============================
        System.out.println("\n🎓 OOP CONCEPTS DEMONSTRATED:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        
        System.out.println("✅ CLASSES & OBJECTS:");
        System.out.println("   • Person, Customer, Account, Transaction, Bank classes");
        System.out.println("   • Multiple object instances with different states");
        
        System.out.println("\n✅ INHERITANCE:");
        System.out.println("   • Customer extends Person (IS-A relationship)");
        System.out.println("   • SavingsAccount, CheckingAccount extend Account");
        System.out.println("   • BusinessAccount extends CheckingAccount");
        
        System.out.println("\n✅ POLYMORPHISM:");
        System.out.println("   • InterestBearing interface implemented by multiple classes");
        System.out.println("   • Transferable interface with different implementations");
        System.out.println("   • Method overriding in account types");
        
        System.out.println("\n✅ ENCAPSULATION:");
        System.out.println("   • Private fields with controlled access through methods");
        System.out.println("   • Data validation in setters and business methods");
        System.out.println("   • Internal state protection");
        
        System.out.println("\n✅ ABSTRACTION:");
        System.out.println("   • Abstract Person class and Account class");
        System.out.println("   • Interfaces define contracts (InterestBearing, Transferable)");
        System.out.println("   • Template method pattern in Account.withdraw()");
        
        System.out.println("\n✅ ADDITIONAL PATTERNS:");
        System.out.println("   • Singleton pattern in Bank class");
        System.out.println("   • Strategy pattern for fee calculations");
        System.out.println("   • Observer pattern potential for notifications");
        System.out.println("   • Factory pattern for account creation");
        
        System.out.println("\n✅ ADVANCED FEATURES:");
        System.out.println("   • Collections (List, Map) for data management");
        System.out.println("   • Enums for type safety (TransactionType, CustomerType)");
        System.out.println("   • Stream API for data processing");
        System.out.println("   • Date/Time handling with LocalDateTime");
        System.out.println("   • Exception handling concepts");
        
        System.out.println("\n🎉 CONGRATULATIONS!");
        System.out.println("You've successfully studied a complete OOP system in Java!");
        System.out.println("This example demonstrates how all OOP concepts work together");
        System.out.println("in a real-world application. Practice by extending this system!");
    }
}

/*
 * COMPLETE OOP CONCEPTS SUMMARY:
 * 
 * ╔═══════════════════════════════════════════════════════════════════════════╗
 * ║                         BANKING SYSTEM ARCHITECTURE                      ║
 * ╠═══════════════════════════════════════════════════════════════════════════╣
 * ║                                                                           ║
 * ║    Person (Abstract)                    Bank (Singleton)                  ║
 * ║         ↓                                   ↓                             ║
 * ║    Customer ←─────── manages ──────────→ Account (Abstract)               ║
 * ║                                             ↓                             ║
 * ║                          ┌─────────────────┼─────────────────┐             ║
 * ║                          ↓                 ↓                 ↓             ║
 * ║                   SavingsAccount   CheckingAccount   BusinessAccount      ║
 * ║                        ↑                  ↑                 ↑             ║
 * ║                InterestBearing      Transferable     InterestBearing      ║
 * ║                                                    & Transferable         ║
 * ║                                                                           ║
 * ║    Additional Components:                                                 ║
 * ║    • Transaction (Encapsulation)                                          ║
 * ║    • Enums (TransactionType, CustomerType)                               ║
 * ║    • Interfaces (Transferable, InterestBearing, Reportable)              ║
 * ║                                                                           ║
 * ╚═══════════════════════════════════════════════════════════════════════════╝
 * 
 * This system demonstrates:
 * - All 4 OOP pillars working together
 * - Design patterns (Singleton, Template Method, Strategy)
 * - Clean separation of concerns
 * - Extensible and maintainable code structure
 * - Real-world business logic implementation
 * - Professional software development practices
 */