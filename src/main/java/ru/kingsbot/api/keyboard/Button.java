package ru.kingsbot.api.keyboard;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

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

    public static Builder newButton() {
        return new Builder();
    }

    public static class Builder {

        private Builder() {}

        private String label;
        private Color color;
        private Map<String, String> payload = new HashMap<>();

        public Builder label(String label) {
            this.label = label;
            return this;
        }

        public Builder payload(String key, String value) {
            payload.put(key, value);
            return this;
        }

        public Builder color(Color color) {
            this.color = color;
            return this;
        }

        public Button create() {
            return new Button(new Action(label, payload), color);
        }

    }
}