package Commands.SpecificCommands;

import DataBases.AnimalDataBase;
import DataBases.DaysPlanner;
import Intrefaces.IAnimal;

import java.util.List;

public class GetSpecificAnimalFeedingTimeCommand extends SpecificCommand {
    @Override
    public void doCommand(List<String> details) throws Exception {
        IAnimal animal = AnimalDataBase.getInstance().getAnimal(details.get(0));
        System.out.println(DaysPlanner.getInstance().getSpecificAnimalFeedingTime(animal));
    }

    @Override
    public String getDescription() {
        return "Get specific Animal Feeding Time :Get-specific-animal-feeding-time--Animal_WANTED";
    }
}
