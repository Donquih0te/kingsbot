package vk.sdk.objects.apps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AppLeaderBoardType implements EnumParam {

    @JsonProperty("0")
    NOT_SUPPORT(0),

    @JsonProperty("1")
    LEVELS(1),

    @JsonProperty("2")
    POINTS(2);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
