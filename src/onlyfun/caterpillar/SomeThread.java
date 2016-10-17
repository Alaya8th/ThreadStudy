package onlyfun.caterpillar;

public class SomeThread implements Runnable {
    public void run() { 
        System.out.println("sleep....�� not runnable ���A"); 
        try { 
            Thread.sleep(9999); 
        } 
        catch(InterruptedException e) { 
            System.out.println("I am interrupted...."); 
        } 
    } 

    public static void main(String[] args) { 
        Thread thread = 
                 new Thread(new SomeThread()); 
        thread.start(); 
        thread.interrupt(); 
    } 
}