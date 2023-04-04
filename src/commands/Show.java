package commands;

import exceptions.ArgumentException;
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
            System.out.println(collectionManager);
        } catch (NullCollectionException e){
            ConsoleManager.printError("Collection is empty");
        }
    }
}
