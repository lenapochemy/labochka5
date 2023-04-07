package data;

import exceptions.*;
import manager.ConsoleManager;

public class Coordinates {
    private int coordinatesX; //Максимальное значение поля: 79
    public static final int MAX_X = 79;
    private Double coordinatesY; // поле не может быть null

    public Coordinates(int x, Double y) throws IncorrectGroupValueException{
        this.setX(x);
        this.setY(y);
    }
    public void setX(int coordinatesX) throws IncorrectGroupValueException{
        try {
            if(coordinatesX > MAX_X) throw new IncorrectValueException();
            this.coordinatesX = coordinatesX;
        } catch (IncorrectValueException e){
            ConsoleManager.printError("Coordinate X can't be more than " + MAX_X );
            throw new IncorrectGroupValueException();
        }
    }

    public void setY(Double coordinatesY) throws IncorrectGroupValueException{
        try {
            if(coordinatesY == null) throw new NullException();
            this.coordinatesY = coordinatesY;
        } catch (NullException e) {
            ConsoleManager.printError("Coordinate Y can't be null");
            throw new IncorrectGroupValueException();
        }
    }

    public int getCoordinatesX(){
        return coordinatesX;
    }
    public Double getCoordinatesY(){
        return coordinatesY;
    }


    @Override
    public String toString(){
        return "(" + getCoordinatesX() + ", " + getCoordinatesY() + ")";
    }

}
