package main;

import java.util.LinkedList;
import java.util.List;

public class Lexer {

    // static variable single_instance of type Singleton
    private static Lexer single_instance = null;

    private Lexer(){

    }

    public static Lexer getInstance(){
        if (single_instance == null)
            single_instance = new Lexer();

        return single_instance;
    }

    public List<String> splitCMD(String line) {
        String[] parts = line.split("--");

        return cleanSpaces(parts);

    }

    private List<String> cleanSpaces(String[] parts) {
        List<String> result = new LinkedList<>();
        for (String p : parts) {
            result.add(p.trim());
        }
        return result;
    }
}
