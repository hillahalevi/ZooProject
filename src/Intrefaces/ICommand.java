package Intrefaces;

import java.util.List;

public interface ICommand {
    void execute(List<String> details) throws Exception;

    void printDescription();


}
