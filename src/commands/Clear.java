package commands;

import exceptions.ArgumentException;
import manager.CollectionManager;
import manager.ConsoleManager;

public class Clear extends Command{
    private final CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager){
        super("clear", "clear collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument){
        try{
            if(!argument.isEmpty()) throw new ArgumentException();
            collectionManager.clearCollection();
            ConsoleManager.printSuccess("Collection is cleared");
            return true;
        } catch (ArgumentException e){
            ConsoleManager.printError("Incorrect use of command" + getName());
        }
        return false;
    }
}
