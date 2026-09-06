class Music extends Thread{

    @Override
    public void run(){
        for (int i=0; i<5;i++){
            System.out.println("playing music");
        }
    }
}
class Download extends Thread{
    public void run(){
        for (int i=0; i<5;i++){
            System.out.println("downloading music");
        }
    }
}

public class threading{
    public static void main(String[] a){
        Music m = new Music();
        Download d = new Download();

        m.start();
        d.start();
    }
}