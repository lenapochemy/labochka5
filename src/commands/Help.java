package commands;

import exceptions.ArgumentException;
import manager.ConsoleManager;

public class Help extends Command{

    public Help(){
        super("help", "displays help for available commands");
    }


    public boolean execute(String command){
        try{
            if(command.isEmpty()) throw new ArgumentException();
            ConsoleManager.printInfo("Command '" + command + );
            return true;
        } catch (ArgumentException e){
            ConsoleManager.printError("Incorrect use of command" + getName());
        }
        return false;
    }
}
