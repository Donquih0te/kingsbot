package vk.sdk.objects.wall.postsource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PostSourcePlatform implements EnumParam {

    @JsonProperty("android")
    ANDROID("android"),

    @JsonProperty("iphone")
    IPHONE("iphone"),

    @JsonProperty("wphone")
    WPHONE("wphone");

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

}
