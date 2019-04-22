package DataBases;

import Animals.LandAnimal;
import Intrefaces.IAnimal;

import java.util.LinkedList;
import java.util.List;

public class Day {
    private final String name;
    private List<IAnimal> animalsToFeed;


    Day(String name) {
        this.name = name;
        animalsToFeed = new LinkedList<>();
    }

    public static void main(String[] args) throws Exception {
        Day day = new Day("Sunday");
        int counter = 0;
        while (counter < 2) {
            IAnimal animal2 = new LandAnimal("hilla" + counter, "" + counter, "" + counter, "zebra");
            day.addAnimal(animal2);
            counter++;

        }
        System.out.println(day.toString());
    }

    private void sort() {
        animalsToFeed.sort((o1, o2) -> {
            if (o1.getWeight() > o2.getWeight()) {
                return 1;
            }
            if (o1.getWeight() == o2.getWeight() && o1.getHight() > o2.getHight()) {
                return 1;
            }
            if (o1.getWeight() == o2.getWeight() && o1.getHight() == o2.getHight()) {
                return 0;
            }
            return -1;

        });
    }

    public String getName() {
        return name;
    }

    public void removeAnimal(IAnimal animal) {
        animalsToFeed.remove(animal);
    }

    public void addAnimal(IAnimal animal) {
        animalsToFeed.add(animal);
    }

    public int getNumnerOfAnimals() {
        return animalsToFeed.size();
    }

    private int getAnimalRate(IAnimal animal) {
        sort();
        return animalsToFeed.indexOf(animal);

    }

    public String getAnimalTime(IAnimal animal) {
        int startFeed = 0;        //07:00 am
        double portionTime = 24.0 * 60 / getNumnerOfAnimals();
        int rate = getAnimalRate(animal);
        int hours = startFeed + (int) (rate * portionTime / 60);
        int mins = (int) (rate * portionTime % 60);
        return "Feeding Time: " + timeFormat(hours) + ":" + timeFormat(mins);

    }

    private String timeFormat(int time){
        if(time<10){
            return "0"+time;
        }
        return String.valueOf(time);
    }

    public IAnimal removeFirstAnimal() {
        sort();
        return animalsToFeed.remove(0);
    }

    @Override
    public String toString() {
        sort();
        String div = " | ";
        StringBuilder animals = new StringBuilder();
        for (IAnimal animal : animalsToFeed) {
            animals.append(div).append(animal.toString());
            animals.append(div).append(getAnimalTime(animal));
            animals.append("\n");
        }
        return name + ":" + "\n" + animals.toString();
    }
}
