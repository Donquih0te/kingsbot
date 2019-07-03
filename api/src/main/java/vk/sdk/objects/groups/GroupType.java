package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GroupType implements EnumParam {

    @JsonProperty("group")
    GROUP("group"),

    @JsonProperty("page")
    PAGE("page"),

    @JsonProperty("event")
    EVENT("event");

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

}
