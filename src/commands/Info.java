package commands;

import exceptions.ArgumentException;
import exceptions.NullCollectionException;
import manager.CollectionManager;
import manager.ConsoleManager;

import java.time.LocalDate;

public class Info extends Command{
    private final CollectionManager collectionManager;

    public Info(CollectionManager collectionManager){
        super("info", "displays information about collection");
        this.collectionManager = collectionManager;
    }

    @Override
    public boolean execute(String argument){
        try{
            if(!argument.isEmpty()) throw new ArgumentException();
            if(collectionManager.collectionSize() == 0) throw new NullCollectionException();
            LocalDate lastInitDate = collectionManager.getLastInitDate();
            String lastInitDateStr = (lastInitDate == null) ? "No command in this session":
                    lastInitDate.toString();
            LocalDate lastSaveDate = collectionManager.getLastSaveDate();
            String lastSaveDateStr = (lastSaveDate == null) ? "No saved in this session":
                    lastSaveDate.toString();
            ConsoleManager.printInfo("Collection info:");
            ConsoleManager.printInfo("  Type: " + collectionManager.collectionType());
            ConsoleManager.printInfo("  Last save: " + lastSaveDateStr);
            ConsoleManager.printInfo("  Last init: " + lastInitDateStr);
            ConsoleManager.printInfo("  Number of elements: " + collectionManager.collectionSize());
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
