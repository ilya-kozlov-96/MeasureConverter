package by.bsu.kozlov.entity;

public enum Measures {


    METERS(1), MILES(1), VERST(1), GRAMS(2), POUNDS(2), POODS(2), CELSIUS(3), KELVINS(3), FAHRENHEIT(3);

    private final int id;

    Measures(int id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }
}

