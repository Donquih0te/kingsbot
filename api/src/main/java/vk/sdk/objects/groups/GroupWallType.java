package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GroupWallType implements EnumParam {

    @JsonProperty("0")
    DISABLED(0),

    @JsonProperty("1")
    OPENED(1),

    @JsonProperty("2")
    LIMITED(2),

    @JsonProperty("3")
    CLOSED(3);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
