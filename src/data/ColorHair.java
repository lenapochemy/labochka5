package data;
/**
 * Enum represent person's hair color
 */
public enum ColorHair {
    GREEN("GREEN"),
    RED("RED"),
    BLUE("BLUE"),
    ORANGE("ORANGE"),
    WHITE("WHITE"),
    DEFAULT_COLOR("default color");

    private final String color;

    ColorHair(String color){
        this.color = color;
    }

    /**
     * Method outputs all possible hair colors as string
     */
    public static void getAllValues(){
        System.out.println(ColorHair.GREEN + ", " + ColorHair.RED + ", " + ColorHair.BLUE + ", " + ColorHair.ORANGE +", " + ColorHair.WHITE);
    }
}
