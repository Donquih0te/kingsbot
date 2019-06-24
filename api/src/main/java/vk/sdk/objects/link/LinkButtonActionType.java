package vk.sdk.objects.link;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor
public enum LinkButtonActionType implements EnumParam {

    @JsonProperty("open_url")
    OPEN_URL("open_url");

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

}
