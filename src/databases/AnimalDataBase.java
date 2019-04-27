package databases;


import intrefaces.IAnimal;

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

    public void addAnimal(IAnimal animal) throws Exception {
        if (animalHashMap.containsKey(animal.getName())) {
            throw new Exception("animal already defined in the system");
        }
        animalHashMap.put(animal.getName(), animal);
    }

    public void removeAnimal(String name) throws Exception {
        if (animalHashMap.containsKey(name)) {
            animalHashMap.remove(name);
        } else {
            throw new Exception("animal is not in the system");
        }
    }

    public IAnimal getAnimal(String name) throws Exception {
        if (animalHashMap.containsKey(name)) {
            return animalHashMap.get(name);
        } else {
            throw new Exception("animal is not in the system");
        }

    }

    public String getAllAnimals() {
        {
            if (animalHashMap.isEmpty()) {
                return "no animals";
            }
            StringBuilder result = new StringBuilder("animals:\n");
            for (IAnimal animal : animalHashMap.values()) {

                result.append(animal.toString()).append("\n");

            }
            return result.toString();
        }

    }
}
