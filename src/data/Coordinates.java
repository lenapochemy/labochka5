package data;

import exceptions.*;
import manager.ConsoleManager;

public class Coordinates {
    private int coordinatesX; //Максимальное значение поля: 79
    public static final int MAX_X = 79;
    private Double coordinatesY; // поле не может быть null
    private final int defaultX = 0;
    private final Double defaultY = 0D;

    public Coordinates() throws IncorrectGroupValueException{
        this.setX(defaultX);
        this.setY(defaultY);
    }
    public Coordinates(int x, Double y) throws IncorrectGroupValueException{
        this.setX(x);
        this.setY(y);
    }
    public void setX(int coordinatesX) throws IncorrectGroupValueException{
        try {
            if(coordinatesX > MAX_X) throw new IncorrectValueException();
            this.coordinatesX = coordinatesX;
        } catch (IncorrectValueException e){
            ConsoleManager.printError("X can't be more than " + MAX_X );
            this.coordinatesX = defaultX;
            throw new IncorrectGroupValueException();
        }
    }

    public void setY(Double coordinatesY) throws IncorrectGroupValueException{
        try {
            if(coordinatesY == null) throw new NullException();
            this.coordinatesY = coordinatesY;
        } catch (NullException e) {
            ConsoleManager.printError("Y can't be null");
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
        return getCoordinatesX() + " " + getCoordinatesY();
    }

}
