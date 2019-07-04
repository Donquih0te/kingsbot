package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GroupMainSection implements EnumParam {

    @JsonProperty("0")
    MISSING(0),

    @JsonProperty("1")
    PHOTO(1),

    @JsonProperty("2")
    BOARD(2),

    @JsonProperty("3")
    AUDIO(3),

    @JsonProperty("4")
    VIDEO(4),

    @JsonProperty("5")
    PRODUCT(5);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
