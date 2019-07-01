package vk.sdk.objects.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Sex implements EnumParam {

    @JsonProperty("m")
    MALE("m"),

    @JsonProperty("f")
    FEMALE("f");

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

}
