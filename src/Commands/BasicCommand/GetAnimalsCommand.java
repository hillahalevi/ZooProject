package Commands.BasicCommand;

import Animals.SeaAnimal;
import DataBases.AnimalDataBase;
import Intrefaces.IAnimal;

import java.util.List;

public class GetAnimalsCommand extends BaseCommand {
    public static void main(String[] args) throws Exception {

        int counter = 0;
        while (counter < 72) {
            IAnimal animal2 = new SeaAnimal("hilla" + counter, "" + counter, "" + counter,""+counter, "zebra");
            AnimalDataBase.getInstance().addAnimal(animal2);
            counter++;

        }
        System.out.println(AnimalDataBase.getInstance().getAllAnimals());
        System.out.println("done");
    }
    @Override
    protected String getDescription() {
        return "Get all registered animals : userName--Get-all-registered-animals ";
    }

    @Override
    public void execute(List<String> details) throws Exception {
        System.out.println(AnimalDataBase.getInstance().getAllAnimals());

    }


}
