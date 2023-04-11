package commands;

import manager.ConsoleManager;

/**
 * Command 'exit', ends the program without saving collection
 */
public class Exit extends Command{
    public Exit(){
        super("exit", "finish program without saving");
    }

    /**
     * Executing the command 'exit'
     */
    public void execute(){
        ConsoleManager.printSuccess("Program is finished!");
        System.exit(0);
    }
}
