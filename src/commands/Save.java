package commands;

import manager.CollectionManager;
import exceptions.ArgumentException;
import manager.ConsoleManager;

public class Save extends Command{
    private final CollectionManager collectionManager;

    public Save(CollectionManager collectionManager){
        super("save <file_name>", "save collection to file");
        this.collectionManager = collectionManager;
    }

    public void execute(String fileName){
        try {
            if(fileName.isEmpty()) throw  new ArgumentException();
            collectionManager.saveCollection(fileName);
            ConsoleManager.printSuccess("Collection is saved!");
        } catch(ArgumentException e){
            ConsoleManager.printError("Incorrect use of command " + getName());
        }
    }
}
