package commands;

import exceptions.ArgumentException;
import manager.CollectionManager;

public class RemoveByID extends {

    private final CollectionManager collectionManager;
    public RemoveByID(CollectionManager collectionManager){
        super("remove_by_id <id>", "remove element from collection by id");
        this.collectionManager = collectionManager;
    }

    public void execute(String sID){
        try{
            if(sID.isEmpty()) throw new ArgumentException();
            int id = Integer.
        }
    }
}
