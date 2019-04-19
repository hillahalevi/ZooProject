import java.util.List;

abstract class BaseCommand implements Command {
    public boolean isValidNumber(String num ){
        return Integer.parseInt(num)>0;
    }


}
