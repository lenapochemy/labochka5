package commands;

import manager.CollectionManager;
import manager.ConsoleManager;

/**
 * Command 'clear', clears the collection
 */
public class Clear extends Command{
    private final CollectionManager collectionManager;

    public Clear(CollectionManager collectionManager){
        super("clear", "clear collection");
        this.collectionManager = collectionManager;
    }

    /**
     * Executing the command 'clear'
     */
    public void execute(){
        collectionManager.clearCollection();
        ConsoleManager.printSuccess("Collection is cleared!");
    }
}
