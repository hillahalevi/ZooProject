import java.util.Collection;
import java.util.HashMap;

public class AnimalDataBase {
    private static AnimalDataBase ourInstance = new AnimalDataBase();

    public static AnimalDataBase getInstance() {
        return ourInstance;
    }

    private HashMap<String,IAnimal> animalHashMap;

    private AnimalDataBase() {
        animalHashMap=new HashMap<>();

    }

    public void addAnimal(IAnimal animal) throws Exception {
        if(animalHashMap.containsValue(animal)){
            throw new Exception("animal already defined in the system");
        }
        animalHashMap.put(animal.getName(),animal);
    }

    public void removeAnimal(String name) throws Exception {
        if(animalHashMap.containsKey(name)) {
            animalHashMap.remove(name);
        }else {
            throw new Exception("animal is not in the system");
        }
    }

    public IAnimal getAnimal(String name) throws Exception {
        if(animalHashMap.containsKey(name)) {
            return animalHashMap.get(name);
        }else {
            throw new Exception("animal is not in the system");
        }

    }

    public Collection<IAnimal> getAllAnimals(){
        return animalHashMap.values();
    }
}
