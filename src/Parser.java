import Commands.BasicCommand.GetAnimalsCommand;
import Commands.BasicCommand.GetUsersCommand;
import Commands.InterferingCommands.AddAnimal;
import Commands.InterferingCommands.RemoveAnimal;
import Commands.SpecificCommands.GetSpecificAnimalCommand;
import Commands.SpecificCommands.GetSpecificAnimalFeedingTimeCommand;
import Commands.SpecificCommands.GetSpecificDayCommand;
import Intrefaces.ICommand;

import java.util.HashMap;
import java.util.List;

public class Parser {
    // static variable single_instance of type Singleton
    private static Parser single_instance = null;
    private HashMap<String, ICommand> commandHashMap;

    private Parser() {
        commandHashMap = new HashMap<>();
        setCommandHashMap();
    }

    public static Parser getInstance() {
        if (single_instance == null)
            single_instance = new Parser();

        return single_instance;
    }

    private void setCommandHashMap() {
        commandHashMap.put("remove-animal", new RemoveAnimal());
        commandHashMap.put("Get-specific-animal", new GetSpecificAnimalCommand());
        commandHashMap.put("Get-specific-animal-feeding-time", new GetSpecificAnimalFeedingTimeCommand());
        commandHashMap.put("Get-specific-day", new GetSpecificDayCommand());
        commandHashMap.put("add-animal", new AddAnimal());
        commandHashMap.put("Get-all-registered-animals", new GetAnimalsCommand());
        commandHashMap.put("Get-all-registered-users", new GetUsersCommand());
    }

    public void runCommand(List<String> cmdLine) throws Exception {
        if (commandHashMap.containsKey(cmdLine.get(0))) {
            ICommand command = commandHashMap.get(cmdLine.get(0));
            cmdLine.remove(0); //removes command
            //TODO cmdline[0] now holds the user name  - register + thread
            if (cmdLine.contains("help")) {
                //TODO CHECK FOR THE HELP FLAG
                command.printDescription();
            }
            try {
                command.execute(cmdLine);
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }

        } else {
            throw new Exception("illegal command");
        }
    }

}
