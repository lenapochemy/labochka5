package data;
/**
 * Enum represent person's country
 */
public enum Country {
    USA("USA"),
    ITALY("ITALY"),
    SOUTH_KOREA("SOUTH_KOREA"),
    NORTH_KOREA("NORTH_KOREA"),
    DEFAULT_COUNTRY("default_country");

    private final String country;

    Country(String country){
        this.country = country;
    }

    /**
     * Method outputs all possible student's country as string
     */
    public static void getAllValues(){
        System.out.println(Country.USA + ", " + Country.ITALY + ", " + Country.SOUTH_KOREA + ", " + Country.NORTH_KOREA);
    }
}
