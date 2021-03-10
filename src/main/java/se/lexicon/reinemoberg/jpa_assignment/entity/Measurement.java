package se.lexicon.reinemoberg.jpa_assignment.entity;

public enum Measurement {
    TBSP("Table spoon"),
    TSP("Tea spoon"),
    G("Gram"),
    HG("Hecto"),
    KG("Kilo"),
    ML("Milliliter"),
    CL("Centiliter"),
    DL("Deciliter");

    String valueString;

    Measurement(String valueString) {
        this.valueString = valueString;
    }

    public String getValueString() {
        return valueString;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "valueString='" + valueString + '\'' +
                '}';
    }
}



