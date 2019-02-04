package ru.kingsbot.api.keyboard;

import com.google.gson.annotations.SerializedName;

import java.util.*;

public class Keyboard {

    @SerializedName(value = "one_time")
    private boolean oneTime = false;

    @SerializedName(value = "buttons")
    private List<List<Button>> buttons = new LinkedList<>();

    private Keyboard() { }

    public void addButtonToRow(int row, Button button) {
        if(row > 4) {
            return;
        }
        if(buttons.get(row).size() == 4) {
            return;
        }
        if(buttons.size() >= row) {
            buttons.get(row).add(button);
        }
        if(buttons.size() < row) {
            List<Button> list = new LinkedList<>();
            list.add(button);
            buttons.add(list);
        }
    }

    public static Builder newKeyboard() {
        return new Keyboard().new Builder();
    }

    public class Builder {

        private Builder() { }

        public Builder row(List<Button> buttons) {
            Keyboard.this.buttons.add(new LinkedList<>(buttons));
            return this;
        }

        public Keyboard build() {
            return Keyboard.this;
        }

    }

}
