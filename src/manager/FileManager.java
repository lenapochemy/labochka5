package manager;

import data.*;
import parser.*;
import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.*;

public class FileManager {
    private final String fileName = "study_groups.json";

    private final String PATH = System.getenv("STUDY_GROUP_PATH");

    public FileManager(){
    }

    public HashSet<StudyGroup> readFromFile() throws FileNotFoundException{
        System.out.println("1");
       // Gson parser = new Gson();
        ObjectMapper parser = new ObjectMapper();
        HashSet<StudyGroup> studyGroupCollection = new HashSet<>();
        System.out.println("2");
        try{
          //  FileInputStream file = new FileInputStream(PATH + fileName);
            System.out.println("3");
           // InputStreamReader reader = new InputStreamReader(file);
            System.out.println("4");
            StudyGroup studyGroupList = parser.readValue(new File(PATH + fileName), StudyGroup.class);
            studyGroupCollection.addAll(studyGroupList);
            System.out.println("5 " + studyGroupCollection.isEmpty());
          //  studyGroupCollection = parser.fromJson(reader, StudyGroup.class);
        } catch (IOException e){
            ConsoleManager.printError("Cringe - Problem with file");
        }
        return studyGroupCollection;
    }

    public void writeToFile(HashSet<StudyGroup> studyGroupCollection, String fileName){
   /*  Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .serializeNulls()
                .create();
*/
        ToJSON parser = new ToJSON();
      //  ObjectMapper parser = new ObjectMapper();
        File file = new File(PATH + fileName);
        try(FileOutputStream writer = new FileOutputStream(file)) {
         //   String json = gson.toJson(studyGroupCollection);
           // System.out.println(studyGroupCollection);
           // System.out.println(json);
           // writer.write(json.getBytes());

           // parser.writeValue(writer, studyGroupCollection);

            String json = parser.parseToJSON(studyGroupCollection);
            writer.write(json.getBytes());

        } catch (IOException e){
            ConsoleManager.printError("Problem with write to file");
        }

    }

    public boolean isFileEmpty(){
        File file = new File(PATH+fileName);
        return file.length() == 0;
    }

}

