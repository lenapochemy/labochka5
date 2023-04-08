package parser;

import data.StudyGroup;

import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;
import com.google.gson.*;

public class ToJSON {

    public ToJSON(){
    }

    public String parseToJSON(HashSet<StudyGroup> studyGroupCollection){
        String json = "";
        List<String>  elements = new LinkedList<>();
        String stringGroup;
        if(studyGroupCollection.size() == 1){
            for(StudyGroup group: studyGroupCollection) {
            /*Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .serializeNulls()
                    .create();
            json = gson.toJson(studyGroupCollection);
            */
                json = "{\n" +
                        " \"id\": " + group.getId() + ",\n" +
                        " \"name\": \"" + group.getName() + "\",\n" +
                        " \"coordinates\": {\n" +
                        "  \"x\": " + group.getCoordinates().getCoordinatesX() + ",\n" +
                        "  \"y\": " + group.getCoordinates().getCoordinatesY() + "\n" +
                        " },\n" +
                        " \"creationDate\": \"" + group.getCreationDate() + "\",\n" +
                        " \"formOfEducation\": \"" + group.getFormOfEducation() + "\",\n" +
                        " \"semesterEnum\": \"" + group.getSemesterEnum() + "\",\n" +
                        " \"groupAdmin\": {\n" +
                        "  \"name\": \"" + group.getGroupAdmin().getName() + "\",\n" +
                        "  \"height\": " + group.getGroupAdmin().getHeight() + ",\n" +
                        "  \"eyeColor\": \"" + group.getGroupAdmin().getEyeColor() + "\",\n" +
                        "  \"hairColor\": \"" + group.getGroupAdmin().getHairColor() + "\",\n" +
                        "  \"nationality\": \"" + group.getGroupAdmin().getNationality() + "\"\n" +
                        "  }\n" +
                        "}\n";
            }
        } else {
            json = "[\n";
            for (StudyGroup group : studyGroupCollection) {
                stringGroup = " {\n" +
                        "  \"id\": " + group.getId() + ",\n" +
                        "  \"name\": \"" + group.getName() + "\",\n" +
                        "  \"coordinates\": {\n" +
                        "   \"x\": " + group.getCoordinates().getCoordinatesX() + ",\n" +
                        "   \"y\": " + group.getCoordinates().getCoordinatesY() + "\n" +
                        "  },\n" +
                        "  \"creationDate\": \"" + group.getCreationDate() + "\",\n" +
                        "  \"formOfEducation\": \"" + group.getFormOfEducation() + "\",\n" +
                        "  \"semesterEnum\": \"" + group.getSemesterEnum() + "\",\n" +
                        "  \"groupAdmin\": {\n" +
                        "   \"name\": \"" + group.getGroupAdmin().getName() + "\",\n" +
                        "   \"height\": " + group.getGroupAdmin().getHeight() + ",\n" +
                        "   \"eyeColor\": \"" + group.getGroupAdmin().getEyeColor() + "\",\n" +
                        "   \"hairColor\": \"" + group.getGroupAdmin().getHairColor() + "\",\n" +
                        "   \"nationality\": \"" + group.getGroupAdmin().getNationality() + "\"\n" +
                        "   }\n" +
                        " },\n";
                json += stringGroup;

            }
            json = json.substring(0, json.length()-2) + "\n";
            json += "]";
        }
        return json;
    }
}
