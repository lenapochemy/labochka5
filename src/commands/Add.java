package commands;

import data.StudyGroup;
import exceptions.IncorrectScriptException;
import manager.CollectionManager;
import manager.ConsoleManager;
import manager.ScannerManager;

/**
 * Command 'add', adds a new element to the collection
 */
public class Add extends Command{

    private final CollectionManager collectionManager;
    private final ScannerManager scannerManager;

    public Add(CollectionManager collectionManager, ScannerManager scannerManager){
        super("add", "add a new element to collection");
        this.collectionManager = collectionManager;
        this.scannerManager = scannerManager;
    }


    /**
     * Executing the command 'add'
     */
    public void execute(){
        try{
            collectionManager.addToCollection(
                    new StudyGroup(
                        collectionManager.generateId(),
                        scannerManager.sayGroupName(),
                        scannerManager.sayCoordinates(),
                        collectionManager.generateCreationDate(),
                        scannerManager.sayStudentsCount(),
                        scannerManager.sayFormOfEducation(),
                        scannerManager.saySemesterEnum(),
                        scannerManager.sayPerson()
                     )
            );
            ConsoleManager.printSuccess("New Study Group added to collection!");
        } catch (IncorrectScriptException e){
            ConsoleManager.printError("Script is incorrect");
        }
    }
}
