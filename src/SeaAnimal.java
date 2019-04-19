public class SeaAnimal extends BaseAnimal {
    private double depth;

    public SeaAnimal(String name, String height, String weight, String depth, String species) throws Exception {
        super(name, height, weight, species);
        this.depth = evaluateNumber(depth);


    }

    @Override
    String advancedInfo() {
        String div = " | ";
        return "Sea Animal" + div + "depth:" + depth;
    }
}
