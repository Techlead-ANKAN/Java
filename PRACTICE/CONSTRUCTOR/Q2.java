// 2. Parameterized Constructor:
// Write a Java program to create a class called Dog with instance variables name and color. Implement a parameterized constructor that takes name and color as parameters and initializes the instance variables. Print the values of the variables.

package PRACTICE.CONSTRUCTOR;

import java.util.*;

public class Q2 {
    String name;
    String color;

    Q2(String name, String color){
        this.name = name;
        this.color = color;
    }

    void getName(){
        System.out.println("Name = " + name);
    }

    void getColor(){
        System.out.println("Color = " + color);
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Q2 obj1 = new Q2(sc.next(), sc.next());
        obj1.getName();
        obj1.getColor();
        sc.close();
    }
}
