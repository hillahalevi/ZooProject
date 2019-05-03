package main;

import databases.UsersDataBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.Executors;

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
                System.out.println("system closed safely");
                break;
            }
            if (line.equals("menu")) {
                parser.getCommands();
                continue;

            }
            //split the line into command parts
            List<String> command = lexer.splitCMD(line);
            UsersDataBase.getInstance().addUser(command.remove(0));
            Executors.newCachedThreadPool().execute(() ->
                    {
                        try {
                            parser.runCommand(command);
                        } catch (Exception e) {
                            // print error description
                            System.out.println(e.getMessage());
                        }
                    }
            );


        }

    }

    public void runThread() {


    }
}

