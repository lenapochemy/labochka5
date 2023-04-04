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

    public void execute(){
        collectionManager.clearCollection();
        ConsoleManager.printSuccess("Collection is cleared");
    }
}
