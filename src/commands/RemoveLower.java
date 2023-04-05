package commands;

import exceptions.ArgumentException;
import manager.CollectionManager;
import manager.ConsoleManager;

public class RemoveLower extends Command{
    private final CollectionManager collectionManager;
    public RemoveLower(CollectionManager collectionManager){
        super("remove_lower <count>", "remove all groups from collection that have less students");
        this.collectionManager = collectionManager;
    }

    public void execute(String sCount){
        try{
            if(sCount.isEmpty()) throw new ArgumentException();
            Integer count = Integer.parseInt(sCount);
            collectionManager.removeLower(count);
            ConsoleManager.printSuccess("Smaller groups removed from collection!");
        } catch (ArgumentException e){
            ConsoleManager.printError("Incorrect use of command " + getName());
        } catch (NumberFormatException e){
            ConsoleManager.printError("Count should be a number");
        }
    }
}
