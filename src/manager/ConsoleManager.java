package manager;

import commands.*;
import exceptions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
public class ConsoleManager {
    private final Scanner scanner;
    private final ScannerManager scannerManager;
    private final Help help;


    public ConsoleManager(Scanner scanner, ScannerManager scannerManager, Help help) {
        this.scanner = scanner;
        this.scannerManager = scannerManager;
        this.help = help;
    }

    public static void printSuccess(Object message){
        System.out.println(message);
    }
    public static void printError(Object message){
        System.out.println("Error: " + message);
    }
    public static void printInfo(Object message){
        System.out.println(message);
    }


    public void start() throws IOException{
        String[] mCommand = {"", ""};
        try {
            while (true) {
                mCommand = (scanner.nextLine().trim() + " ").split(" ", 2);
                mCommand[1] = mCommand[1].trim();
                execution(mCommand);
            }
        } catch (ArrayIndexOutOfBoundsException e){
            ConsoleManager.printError("Error with input command");
        }
    }

    public void execution(String[] mCommand){
        String command = mCommand[0];
        String argument = mCommand[1];
        try{
            switch (command) {
                case "help" -> help.execute();
                case "info" -> help.info.execute();
                case "show" -> help.show.execute();
                case "add" -> help.add.execute();
                case "update_by_id" -> help.updateByID.execute(argument);
                case "remove_by_id" -> help.removeByID.execute(argument);
                case "clear" -> help.clear.execute();
                case "save" -> help.save.execute(argument);
                case "execute_script" -> scriptMode(argument);
                case "exit" -> help.exit.execute();
                case "add_if_max" -> help.addIfMax.execute();
                case "remove_greater" -> help.removeGreater.execute(argument);
                case "remove_lower" -> help.removeLower.execute(argument);
                case "remove_any_by_form_of_education" -> help.removeAnyByFormOfEducation.execute(argument);
                case "filter_greater_than_group_admin" -> help.filterGreaterThanGroupAdmin.execute(argument);
                case "print_field_descending_form_of_education" -> help.printFieldDescendingFormOfEducation.execute();
                default -> ConsoleManager.printError("This is not a command, print \"help\" ");
            }
        } catch (IOException e){
            ConsoleManager.printError("Script is incorrect");
        } catch (ArrayIndexOutOfBoundsException e){
            ConsoleManager.printError("Error with input command");
        }
    }

    public void scriptMode(String fileName) throws IOException{
        String path;
        String[] mCommand = {"", ""};
        HashSet<String> scriptCollection = new HashSet<>();
        scriptCollection.add(fileName);
        try{
            path = System.getenv("STUDY_GROUP_PATH") + fileName;
            File file = new File(path);
            if(file.exists() && !file.canRead()) throw new FileException();
            Scanner scannerScript = new Scanner(file);
            Scanner scannerOld = scannerManager.getSCanner();
            scannerManager.setScanner(scannerScript);
            scannerManager.setFileMode();

            while (scannerScript.hasNext() ) {
                mCommand = (scanner.nextLine().trim() + " ").split(" ",2);
                mCommand[1] = mCommand[1].trim();
                if(mCommand[0].equals("execute_script")) {
                    for(String script: scriptCollection){
                        if(script.equals(fileName)) throw new RecurentScriptException();
                    }
                }
                execution(mCommand);
            }

            scannerManager.setScanner(scannerOld);
            scannerManager.setUserMode();
        } catch (FileException e){
            ConsoleManager.printError("No commands in file");
        } catch (FileNotFoundException e){
            ConsoleManager.printError("File is not found");
        } catch (RecurentScriptException e){
            ConsoleManager.printError("Recurse in script");
        } catch (ArrayIndexOutOfBoundsException e){
            ConsoleManager.printError("Error with input command");
        }
    }
}
