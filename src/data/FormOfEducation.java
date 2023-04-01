package data;

public enum FormOfEducation {
    DISTANCE_EDUCATION("DISTANCE_EDUCATION"),
    FULL_TIME_EDUCATION("FULL_TIME_EDUCATION"),
    EVENTING_CLASSES("EVENTING_CLASSES"),
    DEFAULT_FROM_OR_EDUCATION("default_form_of_education");

    private final String formOfEducation;

    FormOfEducation(String formOfEducation){
        this.formOfEducation = formOfEducation;
    }

}
