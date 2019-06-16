package ru.kingsbot.command.keyboard;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class Action {

    @SerializedName(value = "type")
    private String type = "text";

    @SerializedName(value = "label")
    private String label;

    @SerializedName(value = "payload")
    private String payload;

    public Action(String label, Map<String, String> payload) {
        this.label = label;
        this.payload = new Gson().toJson(payload);
    }

    public String getLabel() {
        return label;
    }

    public String getPayload() {
        return payload;
    }
}
