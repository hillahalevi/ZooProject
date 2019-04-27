package main;

import DataBases.UserThread;
import DataBases.UsersDataBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Parser parser = Parser.getInstance();
        Lexer lexer = Lexer.getInstance();
        //menu
        parser.getCommands();
        while (true) {
            //read input
            String line = reader.readLine();
            if (line.equals("exit")) {
                //TODO exit threads ? - handle leave

                System.out.println("system closed safely");
                break;
            }
            if(line.equals("menu")){
                parser.getCommands();
                continue;

            }
            //split the line into command parts
            List<String> command = lexer.splitCMD(line);
            //register user or get its thread
            UserThread userThread= UsersDataBase.getInstance().getUserThread(command.remove(0));
            //set command
            userThread.setCmdLine(command);
            //start and run
            userThread.start();
        }

    }
}
