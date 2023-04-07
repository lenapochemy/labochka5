package commands;

import data.*;
import exceptions.*;
import manager.CollectionManager;
import manager.ConsoleManager;
import manager.ScannerManager;

import java.time.LocalDate;

public class UpdateByID extends Command{
    private final CollectionManager collectionManager;
    private final ScannerManager scannerManager;

    public UpdateByID(CollectionManager collectionManager, ScannerManager scannerManager){
        super("update_by_id <id>", "update element from collection by id");
        this.collectionManager = collectionManager;
        this.scannerManager = scannerManager;
    }

    public void execute(String sID){
        try{
            if(sID.isEmpty()) throw new ArgumentException();
            if(collectionManager.collectionSize() == 0) throw new NullCollectionException();
            int id = Integer.parseInt(sID);
            StudyGroup group = collectionManager.getByID(id);
            if(group == null) throw new NullException();
            LocalDate creationDate = group.getCreationDate();
            collectionManager.removeFromCollection(group);

            collectionManager.addToCollection(
                    new StudyGroup(
                            id,
                            scannerManager.sayGroupName(),
                            scannerManager.sayCoordinates(),
                            creationDate,
                            scannerManager.sayStudentsCount(),
                            scannerManager.sayFormOfEducation(),
                            scannerManager.saySemesterEnum(),
                            scannerManager.sayPerson()
                        )
            );

            ConsoleManager.printSuccess("Element from collection was updated!");
        } catch (ArgumentException e){
            ConsoleManager.printError("Incorrect use of command " + getName());
        } catch (NullCollectionException e){
            ConsoleManager.printError("Collection is empty");
        } catch (NullException e){
            ConsoleManager.printError("Study group with this ID is not exists");
        } catch (IncorrectScriptException e){
            ConsoleManager.printError("Script is incorrect");
        }
    }
}
