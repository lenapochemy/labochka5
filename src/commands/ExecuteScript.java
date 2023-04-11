package commands;

import exceptions.ArgumentException;
import manager.ConsoleManager;

import java.io.IOException;

/**
 * Command 'execute_script', executes commands from the file
 */
public class ExecuteScript extends Command{
    private final ConsoleManager consoleManager;
    public ExecuteScript(ConsoleManager consoleManager){
        super("execute_script <file_name>", "execute script from file");
        this.consoleManager = consoleManager;
    }

    /**
     * Executing the command 'execute_script'
     * @param script string containing the name of the script file
     */
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
