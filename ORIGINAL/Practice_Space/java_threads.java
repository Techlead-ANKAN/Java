/* Creating Threads */

// There are two ways of creating Threads in java: 

// 1) By extending Thread class

// Steps: 
// 1. Create a class that extends Thread class
// 2. Override the run() method
// 3. Create an object of the class and call start() method


public class java_threads extends Thread{
    public void run(){
        System.out.println("Thread is running...");
    }

    public static void main(String args[]){
        java_threads th1 = new java_threads();
        th1.start();
    }
}




// 2) By implementing the Runnable interface

// Steps:
// 1. Create a class that implements Runnable interface
// 2. Override the run() method
// 3. Create an object of the class and pass it to Thread constructor
// 4. Call start() method on the Thread object

public class java_threads implements Runnable {
    public void run(){
        System.out.println("Thread is running...");
    }

    public static void main(String args[]){
        Thread th2 = new Thread(new java_threads());
        th2.start();
    }
}