package commands;

import exceptions.NullCollectionException;
import manager.CollectionManager;
import manager.ConsoleManager;

public class PrintFieldDescendingFormOfEducation extends Command{
    private final CollectionManager collectionManager;

    public PrintFieldDescendingFormOfEducation(CollectionManager collectionManager){
        super("print_descending_form_of_education","display all forms of education from collection in descending order");
        this.collectionManager = collectionManager;
    }

    public void execute(){
        try{
            if(collectionManager.collectionSize() == 0) throw new NullCollectionException();
            collectionManager.printFromOfEducation();
        } catch (NullCollectionException e){
            ConsoleManager.printError("Collection is empty");
        }
    }
}

