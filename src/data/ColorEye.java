package data;

/**
 * Enum represent person's eye color
 */
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

    /**
     * Method outputs all possible eye colors as string
     */
    public static void getAllValues(){
        System.out.println(ColorEye.GREEN + ", " + ColorEye.RED+ ", " + ColorEye.BLUE +", " + ColorEye.ORANGE + ", " +ColorEye.BROWN);
    }

}
