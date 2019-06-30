package vk.sdk.objects.apps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AppScreenOrientationType implements EnumParam {

    @JsonProperty("0")
    ALBUM_AND_PORTRAIT(0),

    @JsonProperty("1")
    ONLY_ALBUM(1),

    @JsonProperty("2")
    ONLY_PORTRAIT(2);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
