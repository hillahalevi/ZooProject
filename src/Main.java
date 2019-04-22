import Animals.LandAnimal;
import Animals.SeaAnimal;
import Intrefaces.IAnimal;

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
            String name = "jo--1.6--60--1.5--whale";

            try {
                List<String> command = lexer.splitCMD(name);


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
