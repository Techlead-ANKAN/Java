// 4. Chaining Constructors
// Write a Java program to create a class called Student with instance variables studentId, studentName, and grade. Implement a default constructor and a parameterized constructor that takes all three instance variables. Use constructor chaining to initialize the variables. Print the values of the variables.

package PRACTICE.CONSTRUCTOR;

public class Q4 {
    String studentId;
    String studentName;
    String grade;

    Q4(){
        this("Std1001", "Ankan Maity", "A");
    }

    Q4(String studentId, String studentName, String grade){
        this.studentId = studentId;
        this.studentName = studentId;
        this.grade = grade;
    }

    void displayDetails(){
        System.out.println("Student Id: " + studentId + ", Student Name: " + studentName + ", Grade: " + grade + "\n");
    }

    public static void main(String [] args){
        Q4 s1 = new Q4();
        s1.displayDetails();

        Q4 s2 = new Q4("std2002", "John Doe", "B");
        s2.displayDetails();
    }

    
}
