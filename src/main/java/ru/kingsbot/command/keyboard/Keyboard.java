package ru.kingsbot.command.keyboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@ToString
@EqualsAndHashCode
public class Keyboard {

    @Expose(serialize = false, deserialize = false)
    private static final int MAX_ROWS = 4;

    @SerializedName(value = "one_time")
    private boolean oneTime = false;

    @SerializedName(value = "buttons")
    private final List<List<Button>> buttons;

    public Keyboard(List<List<Button>> buttons) {
        this.buttons = Objects.requireNonNullElseGet(buttons, LinkedList::new);
    }

    public void addButtonToRow(int row, Button button) {
        if(row > MAX_ROWS) {
            throw new IllegalArgumentException("Keyboard might have only 4 rows");
        }
        List<Button> list = new LinkedList<>();
        list.add(button);
        addButtonsToRow(row, list);
    }

    public void addButtonsToRow(int row, List<Button> buttonList) {
        buttons.add(row, buttonList);
    }

    public static Builder newKeyboard() {
        return new Builder();
    }

    public static class Builder {

        private final List<List<Button>> buttons = new LinkedList<>();

        private Builder() {}

        public Builder withRowButtons(List<Button> buttons) {
            this.buttons.add(new LinkedList<>(buttons));
            return this;
        }

        public Builder withRowButtons(int row, List<Button> buttons) {
            this.buttons.add(row, new LinkedList<>(buttons));
            return this;
        }

        public Builder withButton(int row, Button button) {
            if(row > MAX_ROWS) {
                throw new IllegalArgumentException("Keyboard might have only 4 rows");
            }
            List<Button> list = new LinkedList<>();
            list.add(button);
            this.buttons.add(row, list);
            return this;
        }

        public Keyboard create() {
            return new Keyboard(buttons);
        }

    }

}
