package vk.sdk.objects.polls;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor
public enum PoolBackgroundType implements EnumParam {

    @JsonProperty("gradient")
    GRADIENT("gradient"),

    @JsonProperty("tile")
    TILE("tile");

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

}
