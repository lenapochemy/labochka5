package data;

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
}
