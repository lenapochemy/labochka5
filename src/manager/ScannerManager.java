package manager;

import java.util.Scanner;

import data.*;
import exceptions.*;
import static data.Coordinates.MAX_X;

public class ScannerManager {
    public Scanner scanner;
    private boolean fileMode;

    public ScannerManager(Scanner scanner){
        this.scanner = scanner;
    }

    public Scanner getSCanner(){
        return scanner;
    }
    public void setScanner(Scanner scanner){
        this.scanner = scanner;
    }
    public void setFileMode(){
        fileMode = true;
    }
    public void setUserMode(){
        fileMode = false;
    }


    public String sayName(String asking, String nameType) throws IncorrectScriptException{
        String name = "default_name";
        try{
            System.out.print(asking);
            name = scanner.nextLine().trim();
            if(fileMode) System.out.println(name);
            if(name.equals("")) throw  new NullException();
        } catch (NullException e){
            ConsoleManager.printError(nameType + "can't be empty");
            if(fileMode) throw new IncorrectScriptException();
        }
        return name;
    }

    public String sayGroupName() throws IncorrectScriptException{
        return sayName("Give Study Group Name:", " Study Group name");
    }

    public String sayPersonName() throws IncorrectScriptException{
        return sayName("Give Admin name:", "Person name");
    }

    public int sayCoordinateX() throws IncorrectScriptException{
        String sX;
        int x = 0;
        try{
            System.out.print("Give coordinate X");
            sX = scanner.nextLine().trim();
            if(fileMode) System.out.println(sX);
            if(sX.equals("")) throw new NullException();
            x = Integer.parseInt(sX);
            if(x > MAX_X) throw new IncorrectValueException();
        } catch (NullException e){
            ConsoleManager.printError("Coordinate X can't be empty");
            if(fileMode) throw new IncorrectScriptException();
        } catch (IncorrectValueException e){
            ConsoleManager.printError("Coordinate X can't be more than " + MAX_X);
            if(fileMode) throw new IncorrectScriptException();
        } catch (NumberFormatException e){
            ConsoleManager.printError("Coordinate X should be a number");
        }
        return x;
    }

    public Double sayCoordinateY() throws IncorrectScriptException{
        String sY;
        Double y = 0D;
        try{
            System.out.print("Give coordinate Y");
            sY = scanner.nextLine().trim();
            if(fileMode) System.out.println(sY);
            if(sY.equals("")) throw new NullException();
            y = Double.parseDouble(sY);
        } catch (NullException e){
            ConsoleManager.printError("Coordinate Y can't be empty");
            if(fileMode) throw new IncorrectScriptException();
        } catch (NumberFormatException e){
            ConsoleManager.printError("Coordinate Y should be a number");
        }
        return y;
    }

    public Coordinates sayCoordinates() throws IncorrectScriptException{
        try{
            int x = sayCoordinateX();
            Double y = sayCoordinateY();
            Coordinates coordinates = new Coordinates();
            coordinates.setX(x);
            coordinates.setY(y);
            return coordinates;
        } catch (IncorrectGroupValueException e){
            ConsoleManager.printError(e);
            return null;
        }
    }


    public Integer sayStudentsCount() throws IncorrectScriptException{
        String sCount;
        Integer count = 1;
        try{
            System.out.print("Give the number of students in the group");
            sCount = scanner.nextLine().trim();
            if(fileMode) System.out.println(sCount);
            if(sCount.equals("")) throw new NullException();
            count = Integer.valueOf(sCount);
            if(count <= 0) throw new IncorrectValueException();

        } catch (NullException e){
            ConsoleManager.printError("Students count can't be empty");
            if(fileMode) throw new IncorrectScriptException();
        } catch (IncorrectValueException e){
            ConsoleManager.printError("Students count can't be negative");
            if(fileMode) throw new IncorrectScriptException();
        } catch (NumberFormatException e){
            ConsoleManager.printError("Students count should be a number");
        }
        return count;
    }

    public Semester saySemesterEnum() throws IncorrectScriptException{
        String sSemester;
        Semester semester = Semester.DEFAULT_SEMESTER;
        try{
            System.out.print("Semester list:");
            Semester.getAllValues();
            System.out.print("Give semester:");
            sSemester = scanner.nextLine().trim();
            if(fileMode) System.out.println(sSemester);
            if(sSemester.equals("")) throw new NullException();
            semester = Semester.valueOf(sSemester);
        } catch (NullException e){
            ConsoleManager.printError("Semester can't be empty");
            if(fileMode) throw new IncorrectScriptException();
        } catch (IllegalArgumentException e){
            ConsoleManager.printError("Semester value should be from the list");
        }
        return semester;
    }

    public FormOfEducation sayFormOfEducation() throws IncorrectScriptException{
        String sFormOfEducation;
        FormOfEducation formOfEducation = FormOfEducation.DEFAULT_FROM_OR_EDUCATION;
        try{
            System.out.print("Form of education list:");
            FormOfEducation.getAllValues();
            System.out.print("Give form of education:");
            sFormOfEducation = scanner.nextLine().trim();
            if(fileMode) System.out.println(sFormOfEducation);
            if(sFormOfEducation.equals("")) throw new NullException();
            formOfEducation = FormOfEducation.valueOf(sFormOfEducation);
        } catch (NullException e){
            ConsoleManager.printError("Form of education can't be empty");
            if(fileMode) throw new IncorrectScriptException();
        } catch (IllegalArgumentException e){
            ConsoleManager.printError("Form of education value should be from the list");
        }
        return formOfEducation;
    }

    public ColorEye sayColorEye() throws IncorrectScriptException{
        String sColorEye;
        ColorEye colorEye = ColorEye.DEFAULT_COLOR;
        try{
            System.out.print("Eye color list:");
            ColorEye.getAllValues();
            System.out.println("Give eye color");
            sColorEye = scanner.nextLine().trim();
            if(fileMode) System.out.println(sColorEye);
            if(sColorEye.equals("")) throw new NullException();
            colorEye = ColorEye.valueOf(sColorEye);
        } catch (NullException e){
            ConsoleManager.printError("Eye color can't  be empty");
            if(fileMode) throw new IncorrectScriptException();
        } catch (IllegalArgumentException e){
            ConsoleManager.printError("Eye color should be from the list");
        }
        return colorEye;
    }

    public ColorHair sayColorHair() throws IncorrectScriptException{
        String sColorHair;
        ColorHair colorHair = ColorHair.DEFAULT_COLOR;
        try {
            System.out.print("Hair color list:");
            ColorHair.getAllValues();
            System.out.println("Give hair color");
            sColorHair = scanner.nextLine().trim();
            if(fileMode) System.out.println(sColorHair);
            if(sColorHair.equals("")) throw new NullException();
            colorHair = ColorHair.valueOf(sColorHair);
        } catch (NullException e){
            ConsoleManager.printError("Hair color can't be empty");
            if(fileMode) throw new IncorrectScriptException();
        } catch (IllegalArgumentException e){
            ConsoleManager.printError("Hair color should be from the list");
        }
        return colorHair;
    }

    public Country sayNationality() throws IncorrectScriptException{
        String sCountry;
        Country country = Country.DEFAULT_COUNTRY;
        try{
            System.out.print("Country list:");
            Country.getAllValues();
            System.out.println("Give country");
            sCountry = scanner.nextLine().trim();
            if(fileMode) System.out.println(sCountry);
            if(sCountry.equals("")) throw new NullException();
            country = Country.valueOf(sCountry);
        } catch (NullException e){
            ConsoleManager.printError("Country can't be empty");
            if(fileMode) throw new IncorrectScriptException();
        } catch (IllegalArgumentException e){
            ConsoleManager.printError("Country should be from the list");
        }
        return country;
    }

    public Integer sayHeight() throws IncorrectScriptException{
        String sHeight;
        Integer height = 170;
        try{
            System.out.println("Give person height");
            sHeight = scanner.nextLine().trim();
            if(fileMode) System.out.println(sHeight);
            if(sHeight.equals("")) throw new NullException();
            height = Integer.valueOf(sHeight);
            if(height <= 0) throw new IncorrectValueException();
        } catch (NullException e){
            ConsoleManager.printError("Height can't be empty");
            if(fileMode) throw new IncorrectScriptException();
        } catch (IncorrectValueException e){
            ConsoleManager.printError("Height can't be negative");
            if(fileMode) throw new IncorrectScriptException();
        }
        return height;
    }

    public Person sayPerson() throws IncorrectScriptException{
        return new Person(sayPersonName(), sayHeight(), sayColorEye(), sayColorHair(), sayNationality());
    }


}

