package ru.kingsbot.command.keyboard;

public enum Color {

    RED("negative"),
    GREEN("positive"),
    WHITE("default"),
    BLUE("primary");

    private String value;

    private Color(String value) {
        this.value = value;
    }

    public String getRealColor() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
