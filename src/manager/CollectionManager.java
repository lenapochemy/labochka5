package manager;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.time.LocalDate;
import java.util.Set;

import data.*;
import exceptions.NullCollectionException;
import exceptions.NullException;

/**
 * Class responsible for working with the collection
 */
public class CollectionManager {
    /**
     * Collection of groups
     */
    private HashSet<StudyGroup> studyGroupCollection = new HashSet<>();
    /**
     * Collection id values
     */
    private Set<Integer> idCollection = new HashSet<>();
    private int newId = 1;
    private final FileManager fileManager;

    /**
     * Time when the collection was last modified
     */
    private java.time.LocalDate lastInitDate;
    /**
     * The time when the collection was last saved to a file
     */
    private java.time.LocalDate lastSaveDate;

    public CollectionManager(FileManager fileManager){
        this.lastInitDate = null;
        this.lastSaveDate = null;
        this.fileManager = fileManager;
    }

    /**
     * Method creates an empty collection
     */
    public void createCollection(){
        this.studyGroupCollection = new HashSet<>();
    }

    /**
     * Method fills the collection with groups from the file
     */
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

    /**
     * Method counts the number of elements in the collection
     * @return elements count
     */
    public int collectionSize(){
        try{
            if(studyGroupCollection == null) throw new NullCollectionException();
            return studyGroupCollection.size();
        }catch (NullCollectionException e){
            return 0;
        }
    }

    /**
     * Method writes the collection to a file
     * @param fileName name of the file to save the collection
     */
    public void writeToFile(String fileName){
        fileManager.writeToFile(this.studyGroupCollection, fileName);
    }

    /**
     * Method generates a new unique id for the group
     * @return group's id
     */
    public int generateId(){
        while(!idCollection.add(newId)){
            newId++;
        }
        return newId;
    }

    /**
     * Method adds a new element to the collection
     * @param studyGroup new element for collection
     */
    public void addToCollection(StudyGroup studyGroup){
        studyGroupCollection.add(studyGroup);
        lastInitDate = LocalDate.now();
    }

    /**
     * Method clears the collection
     */
    public void clearCollection(){
        studyGroupCollection.clear();
    }

    /**
     * Method saves the collection to a file
     * @param fileName name of the file to write the collection
     */
    public void saveCollection(String fileName){
        this.writeToFile(fileName);
        lastSaveDate = LocalDate.now();
    }

    /**
     * Method finds the group with the maximum number of students in the collection
     * @return max students count
     */
    public Integer getMaxGroup(){
        Integer max = 0;
        for(StudyGroup group : studyGroupCollection){
            if(group.getStudentsCount() > max) max = group.getStudentsCount();
        }
        return max;
    }

    /**
     * Method finds a group with the given id
     * @param id id of the desired group
     * @return desired group
     */
    public StudyGroup getByID(int id){
        for(StudyGroup group : studyGroupCollection){
            if(group.getId() == id)  return group;
        }
        return null;
    }

    /**
     * Method deletes group from the collection
     * @param studyGroup the group to delete
     */
    public void removeFromCollection(StudyGroup studyGroup){
        idCollection.remove(studyGroup.getId());
        studyGroupCollection.remove(studyGroup);
    }

    /**
     * Method removes a group by the id from the collection
     * @param id id of the group to delete
     */
    public void removeByID(int id){
        StudyGroup studyGroup = getByID(id);
        try {
            if(studyGroup == null) throw new NullException();
            idCollection.remove(id);
            studyGroupCollection.remove(studyGroup);
        } catch (NullException e){
            ConsoleManager.printError("Study group with this ID is not exists");
        }
    }

    /**
     * Method removes groups with a larger number of students from the collection
     * @param count max number of students in groups that remain in the collection
     */
    public void removeGreater(Integer count){
        HashSet<Integer> idSet = new HashSet<>();
        for(StudyGroup group : studyGroupCollection){
            if(group.getStudentsCount() > count){
                idSet.add(group.getId());
            }
        }
        for(Integer id: idSet){
            removeByID(id);
        }
    }

    /**
     * Method removes groups with a smaller number of students from the collection
     * @param count min number of students in groups that remain in the collection
     */
    public void removeLower(Integer count){
        HashSet<Integer> idSet = new HashSet<>();
        for(StudyGroup group : studyGroupCollection){
            if(group.getStudentsCount() < count){
                idSet.add(group.getId());
            }
        }
        for(Integer id: idSet){
            removeByID(id);
        }
    }

    /**
     * Method removes a group with this form of education from the collection
     * @param formOfEducation form of education
     */
    public void removeByFormOfEducation(FormOfEducation formOfEducation){
        for(StudyGroup group : studyGroupCollection){
            if(group.getFormOfEducation().equals(formOfEducation)){
                removeFromCollection(group);
                break;
                }
        }
    }

    /**
     * Method displays all elements from collection
     */
    public void printCollection(){
        for(StudyGroup group : studyGroupCollection){
            System.out.println(group.toString());
        }
    }

    /**
     * Method displays groups whose admins are above this height
     * @param height max height of admins of groups that remain in the collection
     */
    public void getGreater(Integer height){
        for(StudyGroup group : studyGroupCollection){
            if(group.getGroupAdmin().getHeight() > height) {
                System.out.println(group.toString());
            }
        }

    }

    /**
     * Method displays the forms of education of all groups from the collection in descending order
     */
    public void printFromOfEducation(){
        int countDistance = 0;
        int countFullTime = 0;
        int countEventing = 0;
        for(StudyGroup group : studyGroupCollection){
            if(group.getFormOfEducation().equals(FormOfEducation.DISTANCE_EDUCATION)) countDistance++;
            if(group.getFormOfEducation().equals(FormOfEducation.FULL_TIME_EDUCATION)) countFullTime++;
            if(group.getFormOfEducation().equals(FormOfEducation.EVENTING_CLASSES)) countEventing++;
        }
        for(int i=0; i<countEventing; i++){
            System.out.println(FormOfEducation.EVENTING_CLASSES);
        }
        for(int i=0; i<countFullTime; i++){
            System.out.println(FormOfEducation.FULL_TIME_EDUCATION);
        }
        for(int i=0; i<countDistance; i++){
            System.out.println(FormOfEducation.DISTANCE_EDUCATION);
        }
    }

    /**
     * Method finds the collection type
     * @return type of collection
     */
    public String collectionType(){
        try{
            if(studyGroupCollection.isEmpty()) throw new NullCollectionException();
            return studyGroupCollection.getClass().getName();
        } catch (NullCollectionException e){
            ConsoleManager.printError("Collection is empty");
            return "empty";
        }
    }

    /**
     * Method generates the date the group was created
     * @return creation date
     */
    public LocalDate generateCreationDate(){
        return LocalDate.now();
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

