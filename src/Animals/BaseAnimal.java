package Animals;

import Commands.InterferingCommands.CommandException;
import Intrefaces.IAnimal;

public abstract class BaseAnimal implements IAnimal {
    private String name;
    private double hight;
    private double weight;
    private String species;

    BaseAnimal(String name, String height, String weight, String species)throws CommandException{
        this.name=name;
        this.hight=evaluateNumber(height);
        this.weight=evaluateNumber(weight);
        this.species=species;


    }

    public double getHight() {
        return hight;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public double evaluateNumber(String num) throws CommandException {
        double number=Double.parseDouble(num);
        if(number<0){
            throw new CommandException("negative number not allowed");
        }
        return number;
    }




    public final String toString() {
        String div = " | ";
        return "name:" +name + div + "species:"+ species + div +"height:"+ hight + div +"weight:"+weight + div+advancedInfo();

    }

    abstract String advancedInfo();




}
