package vk.sdk.objects.stories;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum StoryType implements EnumParam {

    @JsonProperty("photo")
    PHOTO("photo"),

    @JsonProperty("video")
    VIDEO("video");

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

}
