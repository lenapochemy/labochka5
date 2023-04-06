package commands;

import data.FormOfEducation;
import exceptions.IncorrectScriptException;
import manager.CollectionManager;
import manager.ConsoleManager;
import manager.ScannerManager;

public class RemoveAnyByFormOfEducation extends Command{
    private final CollectionManager collectionManager;
    private final ScannerManager scannerManager;

    public RemoveAnyByFormOfEducation(CollectionManager collectionManager, ScannerManager scannerManager){
        super("remove_by_any_form_of_education", "remove one group from collection, which have the same form of education");
        this.collectionManager = collectionManager;
        this.scannerManager = scannerManager;
    }

    public void execute(String sFormOfEducation){
        try{
            FormOfEducation formOfEducation = FormOfEducation.valueOf(sFormOfEducation);
            collectionManager.removeByFormOfEducation(formOfEducation);
            ConsoleManager.printSuccess("Group with this form of education removed from collection!");
        } catch (IllegalArgumentException e){
            ConsoleManager.printError("Form of education should be from the list:");
            FormOfEducation.getAllValues();
        }
    }
}
