package Commands.InterferingCommands;

import Animals.LandAnimal;
import Animals.SeaAnimal;
import DataBases.AnimalDataBase;
import DataBases.DaysPlanner;
import Intrefaces.IAnimal;

import java.util.List;

public class AddAnimal extends InterferingCommands {


    @Override
    public void validate(List<String> cmdLine) throws ValidationException {
        if (cmdLine.isEmpty()) {
            throw new ValidationException("no animal to add"); //specific exceptions
        }
        if (cmdLine.size() < 5) {
            throw new ValidationException("no specific kind of animal");
        }
        if (cmdLine.size() > 6) {
            throw new ValidationException("too many arguments");
        }


    }

    @Override
    public void printFailure() {
        System.out.println("failed adding Animal");
    }

    @Override
    public void printsucsses() {
        System.out.println("You have successfully added this Animal");
    }

    @Override
    public String getDescription() {
        return "Add animal : add-animal--userName--AnimalName--Height--Weight--OPTIONAL:depth--species--animal-kind(0-LandAnimal,1-SeaAnimal)";
    }

    @Override
    public void doCommand(List<String> details) throws CommandException {
        IAnimal animal;
        int kind = Integer.parseInt(details.get(details.size()-1)); //think maybe use string then turn to enum
        /**
         * easy to add new kinds  adding cases and support on main menu
         */
        switch (kind) {
            case 0: //read baout factory and builder design patterns/ validator class
                animal = new LandAnimal(details.get(0), details.get(1), details.get(2), details.get(3));
                break;
            case 1:
                animal = new SeaAnimal(details.get(0), details.get(1), details.get(2), details.get(3), details.get(5));
                break;
            default:
                throw new CommandException("illegal kind of animal");
        }

        AnimalDataBase.getInstance().addAnimal(animal);
        DaysPlanner.getInstance().addAnimal(animal);

    }
}
