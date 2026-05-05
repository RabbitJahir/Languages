package thread.thread1;
import java.util.Scanner;

// Runnable is a fixed interface from java standard library
class running implements Runnable{

    // run() is a fixed method from Runnable interface
    @Override
    public void run(){
        for(int i=1; i <=5; i++){
            // using thread can be dangerous, so try and catch error
            //thred runs on its own, dosent follow order, runs when program starts
            try{    
                Thread.sleep(1000);  
            } catch(InterruptedException e){
                System.out.println("Thread interrupted");
            }

            if(i==5){
                System.out.println("\nTime is up");
            }
        }
    }
}

public class loop1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        // making object from class
        running running = new running(); 

        // java.lang.Thread, a class from java package 
        Thread thread = new Thread(running);

        // thread method is set to be daemon, if the code finishes, stop this thread too
        thread.setDaemon(true);

        // .start() is a method from Thread class
        thread.start(); 

        System.out.print("10 seconds to enter name: ");
        String name = sc.nextLine();
        System.out.println("Hello" + name);

        sc.close();
    }
}