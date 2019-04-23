package Commands.InterferingCommands;// package names should be lowecase

import Commands.SpecificCommands.SpecificCommand;

import java.util.List;

abstract class InterferingCommands extends SpecificCommand {//class name with abstract
    public void execute(List<String> details){
        try {
            validate(details);
            doCommand(details);
            printsucsses();

        } catch (ValidationException e) {
            printFailure();
            System.out.println(e.getMessage());
        }
        catch (CommandException e) {
            //relevant warnings
        }


    }

    //test

    public abstract void validate(List<String> cmdLine) throws ValidationException; // should be specific exception

    public abstract void printsucsses();

    public abstract void printFailure();

}
