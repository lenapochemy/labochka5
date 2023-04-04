package commands;

import exceptions.ArgumentException;
import manager.ConsoleManager;

public class ExecuteScript extends Command{
    public ExecuteScript(){
        super("execute_script <file_name>", "execute script from file");
    }

    @Override
    public boolean execute(String script){
        try{
            if(script.isEmpty()) throw new ArgumentException();
            ConsoleManager.printSuccess();
        }
    }
}
