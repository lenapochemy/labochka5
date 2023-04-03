package data;

public enum ColorEye {
    GREEN("GREEN"),
    RED("RED"),
    BLUE("BLUE"),
    ORANGE("ORANGE"),
    BROWN("BROWN"),
    DEFAULT_COLOR("default color");

    private final String color;

    ColorEye(String color){
        this.color = color;
    }

    public static void getAllValues(){
        System.out.println(ColorEye.GREEN + ", " + ColorEye.RED+ ", " + ColorEye.BLUE +", " + ColorEye.ORANGE + ", " +ColorEye.BROWN);
    }

}
