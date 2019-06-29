package vk.sdk.objects.wall.postsource;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PostSourceType implements EnumParam {

    VK("vk"),
    WIDGET("widget"),
    API("api"),
    RSS("rss"),
    SMS("sms");

    private String value;

    @Override
    public String getValue() {
        return value;
    }
}
