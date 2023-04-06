package main;

import data.*;
import exceptions.*;
import manager.*;
import commands.*;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String path = System.getenv("STUDY_GROUP_PATH");
        Scanner scanner = new Scanner(System.in);
        ScannerManager scannerManager = new ScannerManager(scanner);
        try {
        //    String path = scannerManager.sayPath();
            FileManager fileManager = new FileManager(path);
            CollectionManager collectionManager = new CollectionManager(fileManager);

            if(fileManager.isFileEmpty()) {
                collectionManager.createCollection();
            } else{
                collectionManager.readFromFile();
            }

            Info info = new Info(collectionManager);
            Show show = new Show(collectionManager);
            Add add = new Add(collectionManager, scannerManager);
            UpdateByID updateByID = new UpdateByID(collectionManager, scannerManager);
            RemoveByID removeByID = new RemoveByID(collectionManager);
            Clear clear = new Clear(collectionManager);
            Save save = new Save(collectionManager);
            Exit exit = new Exit();
            AddIfMax addIfMax = new AddIfMax(collectionManager, scannerManager);
            RemoveGreater removeGreater = new RemoveGreater(collectionManager);
            RemoveLower removeLower = new RemoveLower(collectionManager);
            RemoveAnyByFormOfEducation removeAnyByFormOfEducation = new RemoveAnyByFormOfEducation(collectionManager, scannerManager);
            FilterGreaterThanGroupAdmin filterGreaterThanGroupAdmin = new FilterGreaterThanGroupAdmin(collectionManager);
            PrintFieldDescendingFormOfEducation printFieldDescendingFormOfEducation = new PrintFieldDescendingFormOfEducation(collectionManager);
            Help help = new Help(info, show, add, updateByID, removeByID,  clear, save, exit,
                    addIfMax, removeGreater, removeLower, removeAnyByFormOfEducation,
                    filterGreaterThanGroupAdmin, printFieldDescendingFormOfEducation);

            ConsoleManager consoleManager = new ConsoleManager(scanner, scannerManager, help);
            ExecuteScript executeScript = new ExecuteScript(consoleManager);

            ConsoleManager.printInfo("Program is working. Print \"help\" ");
            consoleManager.start();

        } catch (IOException e){
            ConsoleManager.printError("Input error");
        }


    }
}