package data;

import exceptions.*;
import manager.ConsoleManager;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.function.IntFunction;

public class StudyGroup extends HashSet<StudyGroup> {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным
    // Значение этого поля должно генерироваться автоматически
    public static final int wrongId = -1;

    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer studentsCount; //Значение поля должно быть больше 0, Поле может быть null
    private FormOfEducation formOfEducation; //Поле может быть null
    private Semester semesterEnum; //Поле может быть null
    private Person groupAdmin; //Поле может быть null

    public StudyGroup(){

    }

    public StudyGroup(int id, String name, Coordinates coordinates, LocalDate creationDate, Integer studentsCount,
                      FormOfEducation formOfEducation, Semester semesterEnum, Person groupAdmin){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.studentsCount = studentsCount;
        this.formOfEducation = formOfEducation;
        this.semesterEnum = semesterEnum;
        this.groupAdmin = groupAdmin;
    }

    public void setName(String name){
        try {
            if(name == null || name.isEmpty()) throw new NullException();
            this.name = name;
        } catch (NullException e){
            ConsoleManager.printError("Name can't be empty");
            this.id = wrongId;
        }
    }

    public void setId(int id){
        try {
            if(id <= 0) throw new IncorrectValueException();
            this.id = id;
        } catch (IncorrectValueException e){
            ConsoleManager.printError("ID can't be negative");
            this.id = wrongId;
        }
    }

    public void setCoordinates(Coordinates coordinates) throws IncorrectGroupValueException{
        this.coordinates = coordinates;
        this.coordinates.setX(coordinates.getCoordinatesX());
        this.coordinates.setY(coordinates.getCoordinatesY());
    }

    public void setCreationDate(LocalDate creationDate){
        try {
            if(creationDate == null) throw new NullException();
            this.creationDate = creationDate;
        } catch (NullException e){
            ConsoleManager.printError("Date can't be null");
            this.id = wrongId;
        }
    }

    public void setStudentsCount(Integer studentsCount){
        try {
            if(studentsCount <= 0) throw new IncorrectValueException();
            this.studentsCount = studentsCount;
        } catch (IncorrectValueException e){
            ConsoleManager.printError("Students count can't be negative");
            this.id = wrongId;
        }
    }

    public void setFormOfEducation(FormOfEducation formOfEducation){
        this.formOfEducation = formOfEducation;
    }

    public void setSemesterEnum(Semester semesterEnum){
        this.semesterEnum = semesterEnum;
    }

    public void setGroupAdmin(Person groupAdmin){
        this.groupAdmin = groupAdmin;
    }



    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Coordinates getCoordinates(){
        return coordinates;
    }
    public LocalDate getCreationDate(){
        return creationDate;
    }
    public Integer getStudentsCount(){
        return studentsCount;
    }
    public FormOfEducation getFormOfEducation(){
        return formOfEducation;
    }
    public Semester getSemesterEnum(){
        return semesterEnum;
    }
    public Person getGroupAdmin(){
        return groupAdmin;
    }

    @Override
    public String toString(){
        return "StudyGroup{" + "id=" + id + ", name=" + name + ", coordinates=" + coordinates +
                ", creationDate=" + creationDate + ", studentsCount=" + studentsCount +
                ", formOfEducation=" + formOfEducation + ", semesterEnum=" + semesterEnum +
                ", groupAdmin=" + groupAdmin + "}";
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return super.toArray(generator);
    }

    @Override
    public int hashCode(){
        return name.hashCode() + coordinates.hashCode() + studentsCount.hashCode() + formOfEducation.hashCode() + semesterEnum.hashCode() + groupAdmin.hashCode();
    }
}
