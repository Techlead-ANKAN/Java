// 1. Default Constructor:
// Write a Java program to create a class called "Cat" with instance variables name and age. Implement a default constructor that initializes the name to "Unknown" and the age to 0. Print the values of the variables.


package PRACTICE.CONSTRUCTOR;

public class Q1 {
    
    String name;
    int age;

    Q1(){
        this.name = "Unknown";
        this.age = 0;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }


    public static void main(String [] args ){
        Q1 obj1 = new Q1();
        String name = obj1.getName();
        int age = obj1.getAge();
        System.out.println("Name = "+name);
        System.out.println("Age = "+age);
    }

}
