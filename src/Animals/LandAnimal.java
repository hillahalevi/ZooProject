package Animals;

import Commands.InterferingCommands.CommandException;

public class LandAnimal extends BaseAnimal {
    public LandAnimal(String name, String height, String weight, String species) throws CommandException {
        super(name, height, weight, species);
    }

    @Override
    String advancedInfo() {
        return "Land Animal";
    }
}
