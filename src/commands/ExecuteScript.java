package commands;

import exceptions.ArgumentException;
import manager.ConsoleManager;

import java.io.IOException;

public class ExecuteScript extends Command{
    private final ConsoleManager consoleManager;
    public ExecuteScript(ConsoleManager consoleManager){
        super("execute_script <file_name>", "execute script from file");
        this.consoleManager = consoleManager;
    }


    public void execute(String script){
        try{
            if(script.isEmpty()) throw new ArgumentException();
            consoleManager.scriptMode(script);
            ConsoleManager.printSuccess("Script is executed!");
        } catch (ArgumentException e){
            ConsoleManager.printError("Incorrect use of command " + getName());
        } catch (IOException e){
            ConsoleManager.printError("Script is incorrect");
        }
    }
}
