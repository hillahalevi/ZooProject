package Commands.BasicCommand;

import Intrefaces.ICommand;


public abstract class BaseCommand implements ICommand {

    protected abstract String getDescription();


    @Override
    public void printDescription() {
        System.out.println(getDescription());

    }



}
