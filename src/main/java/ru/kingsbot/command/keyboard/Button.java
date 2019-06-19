package ru.kingsbot.command.keyboard;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
@EqualsAndHashCode
public class Button {

    @Getter
    @SerializedName(value = "action")
    private Action action;

    @Getter
    @SerializedName(value = "color")
    private String color;

    public Button(Action action, String color) {
        this.action = action;
        this.color = color;
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
            if(label == null) {
                label = "Unknown";
            }
            if(color == null) {
                color = Color.WHITE;
            }
            return new Button(new Action(label, payload.toString()), color.toString());
        }

    }
}