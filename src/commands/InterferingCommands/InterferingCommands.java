package commands.InterferingCommands;

import commands.SpecificCommands.SpecificCommand;

import java.util.List;

abstract class InterferingCommands extends SpecificCommand {

    public void execute(List<String> details) throws Exception {
        Object lock = new Object();
        try {
            synchronized (lock) {
                validate(details);
                doCommand(details);
                printsucsses();
            }

        } catch (Exception e) {
            printFailure();
            System.out.println(e.getMessage());
        }

    }


    public abstract void validate(List<String> cmdLine) throws Exception;

    public abstract void printsucsses();

    public abstract void printFailure();

}
