package commands;

import exceptions.NullCollectionException;
import manager.CollectionManager;
import manager.ConsoleManager;

/**
 * Command 'print_field_descending_form_of_education", displays all forms of education from collection in descending order
 */
public class PrintFieldDescendingFormOfEducation extends Command{
    private final CollectionManager collectionManager;

    public PrintFieldDescendingFormOfEducation(CollectionManager collectionManager){
        super("print_field_descending_form_of_education","display all forms of education from collection in descending order");
        this.collectionManager = collectionManager;
    }

    /**
     * Executing the command 'print_field_descending_form_of_education'
     */
    public void execute(){
        try{
            if(collectionManager.collectionSize() == 0) throw new NullCollectionException();
            collectionManager.printFromOfEducation();
        } catch (NullCollectionException e){
            ConsoleManager.printError("Collection is empty");
        }
    }
}

