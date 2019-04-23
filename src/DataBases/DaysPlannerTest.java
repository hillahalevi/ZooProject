package DataBases;

import Animals.LandAnimal;
import Animals.SeaAnimal;
import Commands.InterferingCommands.CommandException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DaysPlannerTest {

    @Before
    public void before()
    {
        DaysPlanner.getInstance().removeAllAnimals();
    }

    @Test
    public void addNewSeaAnimalExpectSuccess() throws CommandException {
        SeaAnimal animal = new SeaAnimal("sea animal","1.89","88","45","bla");
        DaysPlanner.getInstance().addAnimal(animal);
        assertThat(DaysPlanner.getInstance().getSpecificDay("wednesday"),is("sea animal"));
    }

//    @Test
//    public void addNewSeaAnimalExpectSuccess() throws CommandException { //any other day expect not there
//        SeaAnimal animal = new SeaAnimal("sea animal","1.89","88","45","bla");
//        DaysPlanner.getInstance().addAnimal(animal);
//        assertThat(DaysPlanner.getInstance().getSpecificDay("wednesday"),is("sea animal"));
//    }

    @Test //factory unitest
    public void createNewSeaAnimalBadHeightExpectFaliure() throws CommandException {
        SeaAnimal animal = new SeaAnimal("sea animal","haha","88","45","bla");
    }

    @Test
    public void addNewLandAnimalExpectFaliureOnWensday() throws CommandException {
        LandAnimal animal = new LandAnimal("sea animal","1.89","88","bla");
        DaysPlanner.getInstance().addAnimal(animal);
        DaysPlanner.getInstance().getSpecificDay("Wednesday");
    }


}