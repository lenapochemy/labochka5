package commands;

import exceptions.ArgumentException;
import manager.CollectionManager;
import manager.ConsoleManager;

public class RemoveGreater extends Command{
    private final CollectionManager collectionManager;

    public RemoveGreater(CollectionManager collectionManager){
        super("remove_greater <count>", "remove all groups from collection that have more students");
        this.collectionManager = collectionManager;
    }

    public void execute(String sCount){
        try{
            if(sCount.isEmpty()) throw new ArgumentException();
            Integer count = Integer.parseInt(sCount);
            collectionManager.removeGreater(count);
            ConsoleManager.printSuccess("Bigger groups removed from collection!");
        } catch (ArgumentException e){
            ConsoleManager.printError("Incorrect use of command " + getName());
        } catch (NumberFormatException e){
            ConsoleManager.printError("Count should be a number");
        }
    }



}
