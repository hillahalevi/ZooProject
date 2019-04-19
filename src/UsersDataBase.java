import java.util.LinkedList;
import java.util.List;

public class UsersDataBase {
    private static UsersDataBase ourInstance = new UsersDataBase();

    public static UsersDataBase getInstance() {
        return ourInstance;
    }

    private List<String> users;

    private UsersDataBase() {
        users=new LinkedList<>();
    }

    public void addUser(String name) throws Exception {
        if(isUser(name)){
            throw new Exception("user already defined in the system");
        }
        users.add(name);
    }

    private boolean isUser(String name){
        return users.contains(name);
    }

    public List<String> getUsers(){
        return users;
    }
}
