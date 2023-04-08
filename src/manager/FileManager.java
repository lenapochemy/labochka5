package manager;

import data.*;
import java.io.*;
import java.util.HashSet;
import exceptions.IncorrectGroupValueException;

public class FileManager {
    private final String fileName = "study_groups.json";
    private final String PATH = System.getenv("STUDY_GROUP_PATH");
    private final String STUDY_PATH = PATH + fileName;

    public FileManager(){
    }

    public HashSet<StudyGroup> readFromFile() throws FileNotFoundException{
        HashSet<StudyGroup> studyGroupCollection = new HashSet<>();
        try{
            FileInputStream file = new FileInputStream(STUDY_PATH);
            InputStreamReader reader = new InputStreamReader(file);
            Parser parser = new Parser();

            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();
            String json = stringBuilder.toString();

            studyGroupCollection = parser.parseFromJSON(json);


        } catch (IncorrectGroupValueException e) {
            throw new RuntimeException(e);
        } catch (IOException e){
            ConsoleManager.printError("Problem with input");
        }
        return studyGroupCollection;
    }

    public void writeToFile(HashSet<StudyGroup> studyGroupCollection, String fileName){
        Parser parser = new Parser();

        File file = new File(PATH + fileName);
        try(FileOutputStream writer = new FileOutputStream(file)) {
            writer.write(parser.parseToJSON(studyGroupCollection).getBytes());

        } catch (IOException e){
            ConsoleManager.printError("Problem with write to file");
        }

    }

    public boolean isFileEmpty(){
        File file = new File(PATH+fileName);
        return file.length() == 0;
    }

}

