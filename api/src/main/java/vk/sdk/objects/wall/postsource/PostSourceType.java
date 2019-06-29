package vk.sdk.objects.wall.postsource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PostSourceType implements EnumParam {

    @JsonProperty("vk")
    VK("vk"),

    @JsonProperty("widget")
    WIDGET("widget"),

    @JsonProperty("api")
    API("api"),

    @JsonProperty("rss")
    RSS("rss"),

    @JsonProperty("sms")
    SMS("sms");

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

}
