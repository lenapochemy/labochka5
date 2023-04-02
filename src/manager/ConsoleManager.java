package manager;

import exceptions.*;
import java.util.Scanner;
public class ConsoleManager {
    private Scanner scanner = new Scanner(System.in);

    private final String HELP = "help";
    private final String INFO = "info";
    private final String SHOW = "show";
    private final String ADD = "add";
    private final String UPDATE_ID = "update_id";
    private final String REMOVE_BY_ID = "remove_by_id";
    private final String CLEAR = "clear";
    private final String SAVE = "save";
    private final String EXECUTE_SCRIPT = "execute_script";
    private final String EXIT = "exit";
    private final String ADD_IF_MAX = "add_if_max";
    private final String REMOVE_GREATER = "remove_greater";
    private final String REMOVE_LOWER = "remove_lower";
    private final String REMOVE_ANY_BY_FORM_OF_EDUCATION = "remove_any_by_form_of_education";
    private final String FILTER_GREATER_THAN_GROUP_ADMIN = "filter_greater_than_group_admin";
    private final String PRINT_FIELD_DESCENDING_FORM_OF_EDUCATION = "print_field_descending_form_of_education";



    public ConsoleManager(Scanner scanner){
        this.scanner = scanner;
    }

    public static void printSuccess(Object message){
        System.out.println(message);
    }
    public static void printError(Object message){
        System.out.println(message);
    }
    public static void printInfo(Object message){
        System.out.println(message);
    }


}
