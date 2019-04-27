package DataBases;

import main.Parser;

import java.util.List;

public class UserThread extends Thread {

    private List<String> cmdLine;
    private String name;


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        Parser parser = Parser.getInstance();
        try {
            parser.runCommand(cmdLine);
        } catch (Exception e) {
            // print error description
            System.out.println(e.getMessage());
        }

    }


    public void setCmdLine(List<String> cmdLine) {
        this.cmdLine = cmdLine;
    }
}
