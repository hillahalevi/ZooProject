import java.util.List;

public interface Command {
    void execute(List<String> details) throws Exception;

    void validate(List<String> cmdLine) throws Exception;
}
