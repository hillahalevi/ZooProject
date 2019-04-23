package Commands.InterferingCommands;

import DataBases.AnimalDataBase;
import DataBases.DaysPlanner;
import Intrefaces.IAnimal;

import java.util.List;

public class RemoveAnimal extends InterferingCommands {
    @Override
    public void validate(List<String> cmdLine) throws ValidationException {
        if(cmdLine.isEmpty()){
            throw new ValidationException("no specific request found");
        }
        if (cmdLine.size() > 1) {
            throw new ValidationException("too many arguments");
        }


    }

    @Override
    public void printsucsses() {
        System.out.println("removal was done successfully");
    }

    @Override
    public void printFailure() {
        System.out.println("removal failed");
    }

    @Override
    public String getDescription() {
        return  "Remove animal : remove-animal--userName--ANIMAL_WANTED";
    }

    @Override
    public void doCommand(List<String> details) throws CommandException {
       IAnimal animal = AnimalDataBase.getInstance().getAnimal(details.get(0));
       AnimalDataBase.getInstance().removeAnimal(details.get(0));
       DaysPlanner.getInstance().removeAnimal(animal);

    }
}
