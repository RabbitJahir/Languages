import java.util.Scanner;
import java.util.HashMap;
public class save{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> login = new HashMap<>();

        while(true){

            System.out.println("1. create account\n2. see accounts\n3. exit \n\n");
            int choose = sc.nextInt();
            sc.nextLine();

            if(choose ==1){
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();

                login.put(username, password);
            } else if(choose==2){
                System.out.println(login);
            }
            else if(choose ==3){
                break;
            }
            else{
                continue;
            }
        }
        sc.close();
    }
}