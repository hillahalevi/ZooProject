package DataBases;


import Commands.InterferingCommands.CommandException;
import Intrefaces.IAnimal;

import java.util.HashMap;

public class AnimalDataBase {
    private static AnimalDataBase ourInstance = new AnimalDataBase();
    private HashMap<String, IAnimal> animalHashMap;

    private AnimalDataBase() {
        animalHashMap = new HashMap<>();

    }

    public static AnimalDataBase getInstance() {
        return ourInstance;
    }

    public void addAnimal(IAnimal animal) throws CommandException {
        if (animalHashMap.containsValue(animal)) {
            throw new CommandException("animal already defined in the system");
        }
        animalHashMap.put(animal.getName(), animal);
    }

    public void removeAnimal(String name) throws CommandException {
        if (animalHashMap.containsKey(name)) {
            animalHashMap.remove(name);
        } else {
            throw new CommandException("animal is not in the system");
        }
    }

    public IAnimal getAnimal(String name) throws CommandException {
        if (animalHashMap.containsKey(name)) {
            return animalHashMap.get(name);
        } else {
            throw new CommandException("animal is not in the system");
        }

    }

    public IAnimal getAnimal2(String name) throws CommandException {
        if (!animalHashMap.containsKey(name)) {
            throw new CommandException("animal is not in the system");
        }
        return animalHashMap.get(name);
    }

    public String getAllAnimals(){
        {
            if (animalHashMap.isEmpty()) {
                return "no Animals";
            }
            StringBuilder result = new StringBuilder("Animals:\n");
            for (IAnimal animal : animalHashMap.values()) {

                result.append(animal.toString()).append("\n");

            }
            return result.toString();
        }

    }
}
