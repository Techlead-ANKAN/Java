// 5. Write a Java program to create a class called "Book" with attributes for title, author, and ISBN, and methods to add and remove books from a collection.

package PRACTICE.CONSTRUCTOR;

import java.util.ArrayList;

public class Q5 {
    String title;
    String author;
    String isbn;

    Q5(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    void display(){
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
    }

    public static void main(String [] args){
        ArrayList<Q5> collection = new ArrayList<>();

        collection.add(new Q5("Title1", "Author1", "ISBN1"));
        collection.add(new Q5("Title2", "Author2", "ISBN2"));
        collection.add(new Q5("Title3", "Author3", "ISBN3"));


        for (Q5 i : collection){
            i.display();
        }
    }
}

