package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GroupDeactivationType implements EnumParam {

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
