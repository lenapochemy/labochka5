package commands;

import exceptions.ArgumentException;
import manager.CollectionManager;
import manager.ConsoleManager;

public class RemoveByID extends Command{

    private final CollectionManager collectionManager;
    public RemoveByID(CollectionManager collectionManager){
        super("remove_by_id <id>", "remove element from collection by id");
        this.collectionManager = collectionManager;
    }

    public void execute(String sID){
        try{
            if(sID.isEmpty()) throw new ArgumentException();
            int id = Integer.parseInt(sID);
            collectionManager.removeByID(id);
            ConsoleManager.printSuccess("Element removed from collection!");
        } catch (ArgumentException e){
            ConsoleManager.printError("Incorrect use of command " + getName());
        } catch (NumberFormatException e){
            ConsoleManager.printError("ID should be a number");
        }
    }
}
