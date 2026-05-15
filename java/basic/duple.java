public class duple{
    public static void main(String[] args){
        String user = "oi";
        check Check = new check();

        String currentUser,currentAccount = Check.checking(user);
        System.out.println(currentUser);
    }
}

class check{
    String checking(String user){
        String username="oi";
        String currentAccount="saving";
        if(user.Equals(username)){
            return username;
        } else {
            return null;
        }
    }
}

