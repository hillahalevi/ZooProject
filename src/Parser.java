import java.util.HashMap;
import java.util.List;

public class Parser {
    // static variable single_instance of type Singleton
    private static Parser single_instance = null;

    private Parser() {
        commandHashMap=new HashMap<>();
        setCommandHashMap();
    }
    public static Parser getInstance(){
        if (single_instance == null)
            single_instance = new Parser();

        return single_instance;
    }

    private HashMap<String,Command> commandHashMap;

    private void setCommandHashMap(){
       /* commandHashMap.put("Add-animal",);
        commandHashMap.put("register",);
        commandHashMap.put("Remove-animal",);
        commandHashMap.put("Get-specific-animal",);
        commandHashMap.put("Get-animal-feeding-Time-in-the-week",);
        commandHashMap.put("Get-all-animal-for-feeding-for-a-specific-day",);
        commandHashMap.put("Get-all-registered-users",);
        */
    }

    public void runCommand(List<String> cmdLine) throws Exception {
        if(commandHashMap.containsKey(cmdLine.get(0))){
            Command command =commandHashMap.get(cmdLine.get(0));
            cmdLine.remove(0); //removes command
            //TODO cmdline[0] now holds the user name  - register + thread
            command.validate(cmdLine);
            command.execute(cmdLine);
        }else {
            throw new Exception("illegal command");
        }
    }

}
