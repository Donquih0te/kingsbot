package vk.sdk.objects.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DeactivationType implements EnumParam {

    @JsonProperty("banned")
    BANNED("banned"),

    @JsonProperty("deleted")
    DELETED("deleted");

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

}
