package main;

import data.*;
import exceptions.IncorrectGroupValueException;
import manager.*;
import commands.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ScannerManager scannerManager = new ScannerManager(scanner);
        try {

            FileManager fileManager = new FileManager();
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
            RemoveAnyByFormOfEducation removeAnyByFormOfEducation = new RemoveAnyByFormOfEducation(collectionManager);
            FilterGreaterThanGroupAdmin filterGreaterThanGroupAdmin = new FilterGreaterThanGroupAdmin(collectionManager);
            PrintFieldDescendingFormOfEducation printFieldDescendingFormOfEducation = new PrintFieldDescendingFormOfEducation(collectionManager);
            Help help = new Help(info, show, add, updateByID, removeByID,  clear, save, exit,
                    addIfMax, removeGreater, removeLower, removeAnyByFormOfEducation,
                    filterGreaterThanGroupAdmin, printFieldDescendingFormOfEducation);

            ConsoleManager consoleManager = new ConsoleManager(scanner, scannerManager, help);


            ConsoleManager.printInfo("Program is working!");
            collectionManager.readFromFile();
            if(collectionManager.collectionSize() >0) {
                System.out.println("Collection is filled from file \"study_groups.json\"!");
            } else {
                System.out.println("File \"study_groups.json\" is not found, collection is empty");
            }
            ConsoleManager.printInfo("Print \"help\" ");
            consoleManager.start();

        } catch (IOException e){
            ConsoleManager.printError("Input error");
        }


    }
}