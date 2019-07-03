package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GroupAccessType implements EnumParam {

    @JsonProperty("0")
    OPEN(0),

    @JsonProperty("1")
    CLOSED(1),

    @JsonProperty("2")
    PARTICULAR(2);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
