package vk.sdk.objects.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum BoolInt implements EnumParam {

    @JsonProperty("0")
    NO(0),

    @JsonProperty("1")
    YES(1);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
