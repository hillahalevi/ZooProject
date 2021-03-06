package databases;

import animals.SeaAnimal;
import intrefaces.IAnimal;


import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DaysPlanner {
    private HashMap<IAnimal, Day> animalDayHashMap;
    private List<Day> normalDays;
    private Day seaAnimalDay;
    private static DaysPlanner ourInstance = new DaysPlanner();

    private DaysPlanner() {
        animalDayHashMap = new HashMap<>();
        normalDays = new LinkedList<>();
        setdays();
    }

    public static DaysPlanner getInstance() {
        return ourInstance;
    }



    public static void main(String[] args) throws Exception {
        DaysPlanner dayPlanner = new DaysPlanner();
        int counter = 0;
        while (counter < 72) {
            IAnimal animal2 = new SeaAnimal("hilla" + counter, "" + counter, "" + counter,""+counter, "zebra");
            dayPlanner.addAnimal(animal2);
            counter++;

        }
        System.out.println("done");
    }


    private void setdays() {
        normalDays.add(new Day("Sunday"));
        normalDays.add(new Day("Monday"));
        normalDays.add(new Day("Tuesday"));
        normalDays.add(new Day("Thursday"));
        normalDays.add(new Day("Friday"));
        normalDays.add(new Day("Saturday"));
        this.seaAnimalDay = new Day("Wednesday");
    }

    /**
     * add animal to the system
     *
     * @param animal specific animal
     */
    public void addAnimal(IAnimal animal) {
        if (animal instanceof SeaAnimal) {
            seaAnimalDay.addAnimal(animal);
            animalDayHashMap.put(animal, seaAnimalDay);
            return;
        }
        sort();
        Day day = normalDays.get(0);
        day.addAnimal(animal);
        sort();
        animalDayHashMap.put(animal, day);
    }

    /**
     * removes an animal from the day its assigns to
     *
     * @param animal specific animal
     */
    public void removeAnimal(IAnimal animal) {
        Day day = animalDayHashMap.get(animal);
        animalDayHashMap.remove(animal);
        day.removeAnimal(animal);
        if (!(animal instanceof SeaAnimal)) {
            balance(day);
        }

    }

    /**
     * balance the list of normalDays after one day reduction bu reassign animal
     * from the day with most animals
     *
     * @param day the day we reduce
     */
    private void balance(Day day) {
        sort();
        Day fullDay = normalDays.get(5);
        if (normalDays.get(0) == day && day.getNumnerOfAnimals() < fullDay.getNumnerOfAnimals()) {
            IAnimal animal = fullDay.removeFirstAnimal();
            day.addAnimal(animal);
            animalDayHashMap.replace(animal, day);
            sort();
            //TODO test that its does the switch + does it really balance?
        }


    }

    private void sort() {
        normalDays.sort(Comparator.comparingInt(Day::getNumnerOfAnimals));
    }

    public String getSpecificDay(String day) throws Exception {
        if(seaAnimalDay.getName().equals(day)) {
            return seaAnimalDay.toString();
        }
        for(Day day1:normalDays){
            if(day1.getName().equals(day)){
                return day1.toString();
            }
        }
        throw new Exception("illegal day ");
    }

    public String getSpecificAnimalFeedingTime(IAnimal animal) throws Exception {
        if(animalDayHashMap.containsKey(animal)){
            Day day= animalDayHashMap.get(animal);
            return day.getAnimalTime(animal);

        }else {
            throw new Exception("animal is not in the system");
        }

    }
}
