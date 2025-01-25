// 3. Constructor Overloading
// Write a Java program to create a class called "Book" with instance variables title, author, and price. Implement a default constructor and two parameterized constructors:
// One constructor takes title and author as parameters.
// The other constructor takes title, author, and price as parameters.
// Print the values of the variables for each constructor.

package PRACTICE.CONSTRUCTOR;

public class Q3 {
    String title;
    String author;
    double price;

    Q3(){
        System.out.println("Default Constructor - 1");
    }

    Q3(String title, String author){
        System.out.println("Parameterized Constructor - 2");
        this.title = title;
        this.author = author;
    }

    Q3(String title, String author, double price){
        System.out.println("Parameterized Constructor - 2");
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void getInfo(){
        System.out.println("Title: " + title + "\nAuthor: " + author + "\nPrice: " + price);
    }


    public static void main(String [] args){
        Q3 obj1 = new Q3();
        Q3 obj2 = new Q3("ABC", "XYZ");
        Q3 obj3 = new Q3("ABC", "XYZ", 1000);

        obj2.getInfo();
        obj3.getInfo();
    }
}
