package ru.kingsbot.api.keyboard;

import com.google.gson.annotations.SerializedName;

public class Button {

    @SerializedName(value = "action")
    private Action action;

    @SerializedName(value = "color")
    private String color;

    public Button(Action action, Color color) {
        this.action = action;
        this.color = color.toString();
    }

    public Action getAction() {
        return action;
    }

    public String getColor() {
        return color;
    }
}
