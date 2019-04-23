package Commands.SpecificCommands;

import Commands.BasicCommand.*;
import Commands.InterferingCommands.CommandException;

import java.util.List;

public abstract class SpecificCommand extends BaseCommand {
    public void execute(List<String> details) throws Exception {
        if(details.isEmpty()){
            throw new Exception("no specific request found");
        }
        if (details.size() > 1) {
            throw new Exception("too many arguments");
        }
        doCommand(details);

    }



   public abstract void doCommand(List<String> details) throws CommandException;
}
