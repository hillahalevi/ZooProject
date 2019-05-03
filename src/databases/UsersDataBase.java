package databases;



import java.util.LinkedList;
import java.util.List;


public class UsersDataBase {
    private static UsersDataBase ourInstance = new UsersDataBase();

    private List<String> usersList;


    private UsersDataBase() {
        usersList =new LinkedList<>();
    }

    public static UsersDataBase getInstance() {
        return ourInstance;
    }


    public String getUsers() {
        if (usersList.isEmpty()) {
            return "no users";
        }
        StringBuilder result = new StringBuilder("Users: ");
        for (String user : usersList) {
            result.append(user).append(" | ");

        }
        return result.toString();
    }

    public void addUser(String user){
        if(!usersList.contains(user)){
            usersList.add(user);
        }

    }


    public void exit(){
      //  while (usersList.values().)
    }
}
