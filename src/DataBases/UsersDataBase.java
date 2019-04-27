package DataBases;



import java.util.HashMap;


public class UsersDataBase {
    private static UsersDataBase ourInstance = new UsersDataBase();

    private HashMap<String, UserThread> userThreadHashMap;


    private UsersDataBase() {
        userThreadHashMap=new HashMap<>();
    }

    public static UsersDataBase getInstance() {
        return ourInstance;
    }

    private boolean isUser(String name) {
        return userThreadHashMap.containsKey(name);
    }

    public String getUsers() {
        if (userThreadHashMap.isEmpty()) {
            return "no users";
        }
        StringBuilder result = new StringBuilder("Users: ");
        for (String user : userThreadHashMap.keySet()) {
            result.append(user).append(" | ");

        }
        return result.toString();
    }

    public UserThread getUserThread(String name){
            // create a new thread and register the user
            UserThread userThread=new UserThread();
            userThreadHashMap.put(name,userThread);
            return userThread;

    }

    public void exit(){
      //  while (userThreadHashMap.values().)
    }
}
