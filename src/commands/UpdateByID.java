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
            int id = Integer.valueOf(sID);
            StudyGroup group = collectionManager.getByID(id);
            if(group == null) throw new NullException();
            LocalDate creationDate = group.getCreationDate();
            collectionManager.removeFromCollection(group);

            String name = scannerManager.sayGroupName();
            Coordinates coordinates = scannerManager.sayCoordinates();
            Integer studentsCount = scannerManager.sayStudentsCount();
            FormOfEducation formOfEducation = scannerManager.sayFormOfEducation();
            Semester semester = scannerManager.saySemesterEnum();
            Person admin = scannerManager.sayPerson();

            collectionManager.addToCollection(
                    new StudyGroup(id, name, coordinates, creationDate, studentsCount, formOfEducation, semester, admin)
                );
            ConsoleManager.printSuccess("Element from collection was updated");
        } catch (ArgumentException e){
            ConsoleManager.printError("Incorrect use of command " + getName());
        } catch (NullCollectionException e){
            ConsoleManager.printError("Collection is empty");
        } catch (NullException e){
            ConsoleManager.printError("This study group is empty");
        } catch (IncorrectScriptException e){
            ConsoleManager.printError("Script is incorrect");
        }
    }
}
