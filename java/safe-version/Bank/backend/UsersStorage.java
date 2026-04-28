package backend;

public class UsersStorage {

    private User[] users = {
    new User("kamrul", "1035"),
    new User("Rabbit", "1006"),
    new User("Mamunur", "1031"),
    new User("Ismail", "1003")
};

    class User {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
    // main theke input niye macthing
   public String login(String username, String password){
    for(User u : users){
        if(u.username.equals(username) && u.password.equals(password)){
            return username;
        }
    }
    return null;
}

}
