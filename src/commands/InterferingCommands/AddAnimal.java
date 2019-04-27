package commands.InterferingCommands;

import animals.LandAnimal;
import animals.SeaAnimal;
import databases.AnimalDataBase;
import databases.DaysPlanner;
import intrefaces.IAnimal;

import java.util.List;

public class AddAnimal extends InterferingCommands {


    @Override
    public void validate(List<String> cmdLine) throws Exception {
        if (cmdLine.isEmpty()) {
            throw new Exception("no animal to add");
        }
        if (cmdLine.size() < 5) {
            throw new Exception("no specific kind of animal");
        }
        if (cmdLine.size() > 6) {
            throw new Exception("too many arguments");
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
        return "Add animal : userName--add-animal--AnimalName--Height--Weight--OPTIONAL:depth--species--animal-kind(0-LandAnimal,1-SeaAnimal)";
    }

    @Override
   synchronized public void doCommand(List<String> details) throws Exception {
        IAnimal animal;
        int kind = Integer.parseInt(details.get(details.size()-1));
        /**
         * easy to add new kinds  adding cases and support on main menu
         */
        switch (kind) {
            case 0:
                animal = new LandAnimal(details.get(0), details.get(1), details.get(2), details.get(3));
                break;
            case 1:
                animal = new SeaAnimal(details.get(0), details.get(1), details.get(2), details.get(3), details.get(5));
                break;
            default:
                throw new Exception("illegal kind of animal");
        }

        AnimalDataBase.getInstance().addAnimal(animal);
        DaysPlanner.getInstance().addAnimal(animal);

    }
}
