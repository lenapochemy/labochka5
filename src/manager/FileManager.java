package manager;

import data.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Scanner;
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
        HashSet<StudyGroup> studyGroupCollection = null;
        try{
            FileInputStream file = new FileInputStream(PATH);
            InputStreamReader reader = new InputStreamReader(file);
            studyGroupCollection = parser.fromJson(reader, (Type) StudyGroup.class);
        } catch (IOException e){
            ConsoleManager.printError("Problem with file");
        }
        return studyGroupCollection;
    }

    public void writeToFile(HashSet<StudyGroup> studyGroupCollecion, String fileName){
        Gson parser = new Gson();
        try {
            File file = new File(PATH + fileName);
            FileOutputStream writer = new FileOutputStream(file);

            parser.toJson((Object) studyGroupCollecion, (Type) writer);
        } catch (IOException e){
            ConsoleManager.printError("Problem with file");
        }

    }

    public boolean isFileEmpty(){
        File file = new File(PATH);
        return file.length() == 0;
    }


    public Scanner getScanner(String fileName) throws FileNotFoundException{
        try{
            return new Scanner(new File(PATH + fileName));
        } catch (Exception e){
            throw new FileNotFoundException("File" + fileName + "should be in" + PATH);
        }

    }

    public String getPATH(){
        return PATH;
    }
}

