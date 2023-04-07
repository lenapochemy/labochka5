package commands;

import manager.ConsoleManager;

public class Exit extends Command{
    public Exit(){
        super("exit", "finish program without saving");
    }

    public void execute(){
        ConsoleManager.printSuccess("Program is finished!");
        System.exit(0);
    }
}
