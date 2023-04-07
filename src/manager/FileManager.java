package manager;

import data.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashSet;
import com.google.gson.*;

public class FileManager {
    private final String fileName;

    private final String PATH;

    public FileManager(String fileName){
        this.fileName = fileName;
        this.PATH = System.getenv("STUDY_GROUP_PATH") + fileName;
    }

    public HashSet<StudyGroup> readFromFile() throws FileNotFoundException{
        Gson parser = new Gson();
        HashSet<StudyGroup> studyGroupCollection = new HashSet<>();
        try{
            FileInputStream file = new FileInputStream(PATH);
            InputStreamReader reader = new InputStreamReader(file);
            studyGroupCollection = parser.fromJson(reader, (Type) StudyGroup.class);
        } catch (IOException e){
            ConsoleManager.printError("Problem with file");
        }
        return studyGroupCollection;
    }

    public void writeToFile(HashSet<StudyGroup> studyGroupCollection, String fileName){
        Gson parser = new Gson();
        try {
            File file = new File(PATH + fileName);
            FileOutputStream writer = new FileOutputStream(file);

            parser.toJson( studyGroupCollection, writer.getClass());
        } catch (IOException e){
            ConsoleManager.printError("Problem with write to file");
        }

    }

    public boolean isFileEmpty(){
        File file = new File(PATH);
        return file.length() == 0;
    }


    public String getFileName() {
        return fileName;
    }
}

