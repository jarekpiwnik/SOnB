package com.example.projekt_sonb.other_classes;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum ResultFaultMode {
    NONE("None"),
    AUTO("Auto"),
    MANUAL("Manual");


    private final String name;

    @Override
    public String toString() {return name;}

    public ResultFaultMode next() {return values()[(this.ordinal() + 1) % values().length];}
}
