package DataBases;

import java.util.LinkedList;
import java.util.List;

public class UsersDataBase {
    private static UsersDataBase ourInstance = new UsersDataBase();
    private List<String> users;

    private UsersDataBase() {
        users = new LinkedList<>();
    }

    public static UsersDataBase getInstance() {
        return ourInstance;
    }

    public void addUser(String name) throws Exception {
        if (isUser(name)) {
            throw new Exception("user already defined in the system");
        }
        users.add(name);
    }

    private boolean isUser(String name) {
        return users.contains(name);
    }

    public String getUsers() {
        if (users.isEmpty()) {
            return "no users";
        }
        StringBuilder result = new StringBuilder("Users: ");
        for (String user : users) {
            result.append(user).append(" ");

        }
        return result.toString();
    }
}
