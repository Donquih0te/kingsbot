package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GroupUserAuthorityLevel implements EnumParam {

    @JsonProperty("0")
    MODERATOR(0),

    @JsonProperty("1")
    REDACTOR(1),

    @JsonProperty("2")
    ADMINISTRATOR(2);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
