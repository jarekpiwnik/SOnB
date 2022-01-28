package com.example.projekt_sonb.other_classes;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum InputFaultMode {
    NONE("None"),
    MANUAL("Manual"),
    AUTO("Auto");

    private final String name;

    @Override
    public String toString() {
        return name;
    }

    public InputFaultMode next() {return values()[(this.ordinal() + 1) % values().length];}
}
