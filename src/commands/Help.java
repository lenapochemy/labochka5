package commands;

import java.util.HashSet;

public class Help extends Command{


    public final Info info;
    public final Show show;
    public final Add add;
    public final UpdateByID updateByID;
    public final RemoveByID removeByID;
    public final Clear clear;
    public final Save save;
    public final Exit exit;
    public final AddIfMax addIfMax;
    public final RemoveGreater removeGreater;
    public final RemoveLower removeLower;
    public final RemoveAnyByFormOfEducation removeAnyByFormOfEducation;
    public final FilterGreaterThanGroupAdmin filterGreaterThanGroupAdmin;
    public final PrintFieldDescendingFormOfEducation printFieldDescendingFormOfEducation;

    private final HashSet<Command> commandCollection = new HashSet<>();


    public Help(Info info, Show show, Add add, UpdateByID updateByID,
                RemoveByID removeByID, Clear clear, Save save,
                Exit exit, AddIfMax addIfMax, RemoveGreater removeGreater, RemoveLower removeLower,
                RemoveAnyByFormOfEducation removeAnyByFormOfEducation,
                FilterGreaterThanGroupAdmin filterGreaterThanGroupAdmin,
                PrintFieldDescendingFormOfEducation printFieldDescendingFormOfEducation){
        super("help", "displays help for available commands");
        this.info = info;
        this.show = show;
        this.add = add;
        this.updateByID = updateByID;
        this.removeByID = removeByID;
        this.clear = clear;
        this.save = save;
        this.exit = exit;
        this.addIfMax = addIfMax;
        this.removeGreater = removeGreater;
        this.removeLower = removeLower;
        this.removeAnyByFormOfEducation = removeAnyByFormOfEducation;
        this.filterGreaterThanGroupAdmin = filterGreaterThanGroupAdmin;
        this.printFieldDescendingFormOfEducation = printFieldDescendingFormOfEducation;

        commandCollection.add(info);
        commandCollection.add(show);
        commandCollection.add(add);
        commandCollection.add(updateByID);
        commandCollection.add(removeByID);
        commandCollection.add(clear);
        commandCollection.add(save);
        commandCollection.add(exit);
        commandCollection.add(addIfMax);
        commandCollection.add(removeGreater);
        commandCollection.add(removeLower);
        commandCollection.add(removeAnyByFormOfEducation);
        commandCollection.add(filterGreaterThanGroupAdmin);
        commandCollection.add(printFieldDescendingFormOfEducation);
    }

    public void execute(){
        System.out.println("Command: help, Description: displays help for available commands");
        System.out.println("Command: execute_script <file_name>, Description: execute script from file");
        for(Command command: commandCollection){
            System.out.println("Command: " + command.getName() + ", Description: " + command.getDescription());
        }

    }

}
