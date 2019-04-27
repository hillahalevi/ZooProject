package animals;

public class LandAnimal extends BaseAnimal {
    public LandAnimal(String name, String height, String weight, String species) throws Exception {
        super(name, height, weight, species);
    }

    @Override
    String advancedInfo() {
        return "Land Animal";
    }
}
