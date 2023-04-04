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

    @Override
    public boolean execute(String argument){
        try{
            if(!argument.isEmpty()) throw new ArgumentException();
            if(collectionManager.collectionSize() == 0) throw new NullCollectionException();
            System.out.println(collectionManager);
            return true;
        } catch (ArgumentException e){
            ConsoleManager.printError("Incorrect use of command" + getName());
        } catch (NullCollectionException e){
            ConsoleManager.printError("Collection is empty");
            return true;
        }
        return false;
    }
}
