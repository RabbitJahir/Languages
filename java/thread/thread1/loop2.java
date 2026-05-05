public class loop2{
    // volatile makes the while loop see that ifLoop has turned false, across CPU and all other threads
    static volatile boolean ifLoop = true;

    
    public static void main(String[] args) throws Exception{

        Thread loop = new Thread(() -> {
                System.out.println("Looping started");

                long count = 0;
                while(ifLoop){
                    count++;
                }
                System.out.println("Looping finished, count: "+ count);
            }
        );

        loop.start();
        Thread.sleep(100);
        ifLoop = false;

        loop.join();
    }
}