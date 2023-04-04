package commands;

import manager.CollectionManager;
import manager.ScannerManager;

public class AddIfMax extends Command{
    private final CollectionManager collectionManager;
    private final ScannerManager scannerManager;

    public AddIfMax(CollectionManager collectionManager, ScannerManager scannerManager){
        super("add_if_max", "add new element to collection, if ");
        this.collectionManager = collectionManager;
        this.scannerManager = scannerManager;
    }
}
