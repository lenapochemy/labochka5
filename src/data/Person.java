package data;

import exceptions.*;
import manager.ConsoleManager;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Integer height; //Поле не может быть null, Значение поля должно быть больше 0
    private ColorEye eyeColor; //Поле может быть null
    private ColorHair hairColor; //Поле не может быть null
    private Country nationality; //Поле не может быть null

    public Person(String name, Integer height,ColorEye eyeColor, ColorHair hairColor, Country nationality){
        this.name = name;
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }

 /*   public void setName(String name) throws IncorrectGroupValueException{
        try {
            if(name == null || name.isEmpty()) throw new NullException();
            this.name = name;
        } catch (NullException e){
            ConsoleManager.printError("Name can't be empty");
            throw new IncorrectGroupValueException();
        }
    }

    public void setHeight(Integer height) throws IncorrectGroupValueException{
        try {
            if (height == null) throw new NullException();
            if (height <= 0) throw new IncorrectValueException();
            this.height = height;
        } catch (NullException e) {
            ConsoleManager.printError("Height can't be hull");
            throw new IncorrectGroupValueException();
        } catch (IncorrectValueException e) {
            ConsoleManager.printError("Height can't be negative");
            throw new IncorrectGroupValueException();
        }
    }
    public void setEyeColor(ColorEye eyeColor){
        this.eyeColor = eyeColor;
    }

    public void setHairColor(ColorHair hairColor){
        try {
            if(hairColor == null) throw new NullException();
            this.hairColor = hairColor;
        } catch (NullException e){
            ConsoleManager.printError("Hair color can't be hull");
        }
    }

    public void setNationality(Country nationality){
        try {
            if(nationality == null) throw new NullException();
            this.nationality = nationality;
        } catch (NullException e){
            ConsoleManager.printError("Nationality can't be hull");
        }
    }

*/
    public String getName(){
        return name;
    }
    public Integer getHeight(){
        return height;
    }
    public ColorEye getEyeColor(){
        return eyeColor;
    }
    public ColorHair getHairColor(){
        return hairColor;
    }
    public Country getNationality(){
        return nationality;
    }

    @Override
    public String toString(){
        return "Person{" +
                "name=" + name +
                ", height=" + height +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                "}";
    }

    @Override
    public int hashCode(){
        return name.hashCode() + height.hashCode() + eyeColor.hashCode() + hairColor.hashCode() + nationality.hashCode();
    }
}
