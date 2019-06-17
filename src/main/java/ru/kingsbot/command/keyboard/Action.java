package ru.kingsbot.command.keyboard;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public class Action {

    @SerializedName(value = "type")
    private String type = "text";

    @Getter
    @SerializedName(value = "label")
    private String label;

    @Getter
    @SerializedName(value = "payload")
    private String payload;

    public Action(String label, String payload) {
        this.label = label;
        this.payload = payload;
    }

}
