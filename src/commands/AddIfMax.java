package commands;

import data.StudyGroup;
import exceptions.IncorrectScriptException;
import exceptions.NullCollectionException;
import manager.CollectionManager;
import manager.ConsoleManager;
import manager.ScannerManager;

/**
 * Command 'add_if_max', adds a new element to the collection if his students count is more than other groups in collection
 */
public class AddIfMax extends Command{
    private final CollectionManager collectionManager;
    private final ScannerManager scannerManager;

    public AddIfMax(CollectionManager collectionManager, ScannerManager scannerManager){
        super("add_if_max", "add new element to collection, if this students count is more than max students count in collection");
        this.collectionManager = collectionManager;
        this.scannerManager = scannerManager;
    }

    /**
     * Executing the command 'add_if_max'
     */
    public void execute(){
        try{
            if(collectionManager.collectionSize() == 0) throw new NullCollectionException();
            StudyGroup group = new StudyGroup(
                 collectionManager.generateId(),
                 scannerManager.sayGroupName(),
                 scannerManager.sayCoordinates(),
                 collectionManager.generateCreationDate(),
                 scannerManager.sayStudentsCount(),
                 scannerManager.sayFormOfEducation(),
                 scannerManager.saySemesterEnum(),
                 scannerManager.sayPerson()
                );
            if(group.getStudentsCount() > collectionManager.getMaxGroup()){
                collectionManager.addToCollection(group);
                ConsoleManager.printSuccess("New study group added to collection!");
            } else {
                ConsoleManager.printInfo("This study group is not max");
            }
        } catch (NullCollectionException e){
            ConsoleManager.printError("Collection is empty");
        } catch (IncorrectScriptException e){
            ConsoleManager.printError("Script is incorrect");
        }
    }
}
