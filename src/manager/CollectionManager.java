package manager;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.time.LocalDate;
import java.util.Set;

import data.*;
import exceptions.NullCollectionException;
import exceptions.NullException;

public class CollectionManager {
    private HashSet<StudyGroup> studyGroupCollection = new HashSet<>();
    private Set<Integer> idCollection = new HashSet<Integer>();
    private int newId = 1;
    private final FileManager fileManager;

    private java.time.LocalDate lastInitDate;
    private java.time.LocalDate lastSaveDate;

    public CollectionManager(FileManager fileManager){
        this.lastInitDate = null;
        this.lastSaveDate = null;
        this.fileManager = fileManager;
    }

    public void createCollection(){
        this.studyGroupCollection = new HashSet<StudyGroup>();
    }

    public void readFromFile(){
        try{
            this.studyGroupCollection = fileManager.readFromFile();
            if(collectionSize() !=0){
                for(StudyGroup group : studyGroupCollection){
                    if(group.getId() == StudyGroup.wrongId){
                        studyGroupCollection.remove(group);
                    } else{
                        idCollection.add(group.getId());
                    }
                }
            }
            if(studyGroupCollection == null){
                createCollection();
            }
        } catch (FileNotFoundException e){
            ConsoleManager.printError(e);
        }
    }

    public int collectionSize(){
        try{
            if(studyGroupCollection == null) throw new NullCollectionException();
            return studyGroupCollection.size();
        }catch (NullCollectionException e){
            return 0;
        }
    }
    public void writeToFile(String fileName){
        fileManager.writeToFile(this.studyGroupCollection, fileName);
    }

    public int generateId(){
        while(!idCollection.add(newId)){
            newId++;
        }
        return newId;
    }

    public void addToCollection(StudyGroup studyGroup){
        studyGroupCollection.add(studyGroup);
        lastInitDate = LocalDate.now();
    }

    public void clearCollection(){
        try{
            if(studyGroupCollection == null) throw new NullCollectionException();
            studyGroupCollection.clear();
        } catch (NullCollectionException e){
            ConsoleManager.printError("Collection is empty");
        }
    }

    public void saveCollection(String fileName){
        this.writeToFile(fileName);
        lastSaveDate = LocalDate.now();
    }

    public StudyGroup getByID(int id){
        for(StudyGroup group : studyGroupCollection){
            if(group.getId() == id)  return group;
        }
        return null;
    }

    public void removeFromCollection(StudyGroup studyGroup){
        idCollection.remove(studyGroup.getId());
        studyGroupCollection.remove(studyGroup);
    }

    public void removeByID(int id){
        StudyGroup studyGroup = getByID(id);
        idCollection.remove(id);
        studyGroupCollection.remove(studyGroup);
    }

    public String collectionType(){
        try{
            if(studyGroupCollection.isEmpty()) throw new NullCollectionException();
            return studyGroupCollection.getClass().getName();
        } catch (NullCollectionException e){
            ConsoleManager.printError("Collection is empty");
            return "empty";
        }
    }

    public LocalDate getLastInitDate(){
        return lastInitDate;
    }
    public LocalDate getLastSaveDate(){
        return lastSaveDate;
    }

    public HashSet<StudyGroup> getStudyGroupCollection(){
        return studyGroupCollection;
    }
}

