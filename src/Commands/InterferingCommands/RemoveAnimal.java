package Commands.InterferingCommands;

import DataBases.AnimalDataBase;
import DataBases.DaysPlanner;
import Intrefaces.IAnimal;

import java.util.List;

public class RemoveAnimal extends InterferingCommands {
    @Override
    public void validate(List<String> cmdLine) throws Exception {
        if(cmdLine.isEmpty()){
            throw new Exception("no specific request found");
        }
        if (cmdLine.size() > 1) {
            throw new Exception("too many arguments");
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
        return  "Remove animal : userName--remove-animal--ANIMAL_WANTED";
    }

    @Override
    synchronized public void doCommand(List<String> details) throws Exception {
       IAnimal animal = AnimalDataBase.getInstance().getAnimal(details.get(0));
       AnimalDataBase.getInstance().removeAnimal(details.get(0));
       DaysPlanner.getInstance().removeAnimal(animal);

    }
}
