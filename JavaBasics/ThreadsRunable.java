package JavaBasics;

public class ThreadsRunable implements Runnable{
	public void run() { 
        try{ // Displaying the thread that is running 
            System.out.println ("Thread " + Thread.currentThread().getId() + " is running"); 
        } 
        catch (Exception e) { // Throwing an exception 
            System.out.println ("Exception is caught"); 
        } 
    } 
// Main Class 
    public static void main(String[] args) { 
        for (int i=0; i<8; i++) { 
            Thread object = new Thread(new ThreadsRunable()); 
            object.start(); 
        } 
    } 
}
