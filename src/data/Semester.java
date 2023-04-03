package data;

public enum Semester {
    SECOND("SECOND"),
    SIXTH("SIXTH"),
    SEVENTH("SEVENTH"),
    DEFAULT_SEMESTER("default_semester");

    private final String semester;

    Semester(String semester){
        this.semester = semester;
    }

    public static void getAllValues(){
        System.out.println(Semester.SECOND + ", " + Semester.SIXTH + ", " + Semester.SEVENTH);
    }
}
