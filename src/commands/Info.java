package commands;

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

    public void execute(){
        try{
            if(collectionManager.collectionSize() == 0) throw new NullCollectionException();
            LocalDate lastInitDate = collectionManager.getLastInitDate();
            String sLastInitDate;
            if(lastInitDate == null) sLastInitDate = "No command in this session";
                else sLastInitDate = lastInitDate.toString();
            LocalDate lastSaveDate = collectionManager.getLastSaveDate();
            String sLastSaveDate;
            if(lastSaveDate == null) sLastSaveDate = "No saved in this session";
                else sLastSaveDate = lastSaveDate.toString();
            ConsoleManager.printInfo("Collection info:");
            ConsoleManager.printInfo("  Type: " + collectionManager.collectionType());
            ConsoleManager.printInfo("  Last save: " + sLastSaveDate);
            ConsoleManager.printInfo("  Last init: " + sLastInitDate);
            ConsoleManager.printInfo("  Number of elements: " + collectionManager.collectionSize());
        } catch (NullCollectionException e){
            ConsoleManager.printError("Collection is empty");
        }
    }
}
