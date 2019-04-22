package Commands.SpecificCommands;

import DataBases.AnimalDataBase;

import java.util.List;

public class GetSpecificAnimalCommand extends SpecificCommand {


    @Override
    public void doCommand(List<String> details) throws Exception {
        System.out.println(AnimalDataBase.getInstance().getAnimal(details.get(0)));

    }

  @Override
   public String getDescription() {
        return "Get specific animal : Get-specific-animal--userName--ANIMAL_WANTED";
    }


}
