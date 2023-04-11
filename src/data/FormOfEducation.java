package data;
/**
 * Enum represent group's forms of education
 */
public enum FormOfEducation {
    DISTANCE_EDUCATION("DISTANCE_EDUCATION"),
    FULL_TIME_EDUCATION("FULL_TIME_EDUCATION"),
    EVENTING_CLASSES("EVENTING_CLASSES"),
    DEFAULT_FORM_OR_EDUCATION("default_form_of_education");

    private final String formOfEducation;

    FormOfEducation(String formOfEducation){
        this.formOfEducation = formOfEducation;
    }

    /**
     * Method outputs all possible form of education values as string
     */
    public static void getAllValues(){
        System.out.println(FormOfEducation.DISTANCE_EDUCATION + ", " + FormOfEducation.FULL_TIME_EDUCATION + ", " + FormOfEducation.EVENTING_CLASSES);
    }

}
