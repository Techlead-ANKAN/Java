class thread_1 extends Thread{
    public void run() {
        for(int i = 1; i <= 5; i++){
            System.out.println("Thread - 1, Task - "+i);
        }
        System.out.println("Thread - 1 finished");
    }
}


class thread_2 implements Runnable{
    public void run() {
        for(int i = 1; i <= 5; i++){
            System.out.println("Thread - 2, Task - "+i);
        }
        System.out.println("Thread - 2 finished");
    }
}

public class multithread{
    public static void main(String args[]){
        thread_1 t1 = new thread_1();
        Thread t2 = new Thread(new thread_2());
    
        t1.start();
        t2.start();
    }
}