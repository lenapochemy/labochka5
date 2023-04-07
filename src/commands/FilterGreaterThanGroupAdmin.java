package commands;

import exceptions.ArgumentException;
import exceptions.NullCollectionException;
import manager.CollectionManager;
import manager.ConsoleManager;

public class FilterGreaterThanGroupAdmin extends Command{
    private final CollectionManager collectionManager;

    public FilterGreaterThanGroupAdmin(CollectionManager collectionManager){
        super("filter_greater_than_group_admin <height>", "display all groups from collection, whose admin is higher");
        this.collectionManager = collectionManager;
    }

    public void execute(String sHeight){
        try{
            if(sHeight.isEmpty()) throw new ArgumentException();
            Integer height = Integer.parseInt(sHeight);
            if(collectionManager.collectionSize() == 0) throw new NullCollectionException();
            collectionManager.getGreater(height);
        } catch (ArgumentException e){
            ConsoleManager.printError("Incorrect use of command " + getName());
        } catch (NumberFormatException e){
            ConsoleManager.printError("Height should be a number");
        } catch (NullCollectionException e){
            ConsoleManager.printError("Collection is empty");
        }

    }

}
