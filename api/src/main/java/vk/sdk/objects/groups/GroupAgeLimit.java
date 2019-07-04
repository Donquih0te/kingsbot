package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GroupAgeLimit implements EnumParam {

    @JsonProperty("1")
    NOT(1),

    @JsonProperty("2")
    A16PLUS(2),

    @JsonProperty("3")
    A18PLUS(3);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
