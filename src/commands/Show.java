package commands;

import exceptions.NullCollectionException;
import manager.CollectionManager;
import manager.ConsoleManager;

public class Show extends Command{
    private final CollectionManager collectionManager;

    public Show(CollectionManager collectionManager){
        super("show", "display all elements from collection");
        this.collectionManager = collectionManager;
    }

    public void execute(){
        try{
            if(collectionManager.collectionSize() == 0) throw new NullCollectionException();
            collectionManager.printCollection();
        } catch (NullCollectionException e){
            ConsoleManager.printInfo("Collection is empty");
        }
    }
}
