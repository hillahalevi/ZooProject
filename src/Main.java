import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parser parser = Parser.getInstance();
        Lexer lexer = Lexer.getInstance();
        while (true) {
            // Reading data using readLine
            String name = reader.readLine();

            try {
                List<String> command = lexer.splitCMD(name);
                IAnimal animal = new LandAnimal(command.get(0),command.get(1),command.get(2),command.get(3));
                System.out.println(animal.toString());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            // Printing the read line
            System.out.println(name);
            List<String> command = lexer.splitCMD(name);
            try {
                parser.runCommand(command);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
