package vk.sdk.objects.wall.enums;

import vk.sdk.objects.utils.EnumParam;

public enum PostSourceType implements EnumParam {

    VK("vk"),
    WIDGET("widget"),
    API("api"),
    RSS("rss"),
    SMS("sms");

    private String value;

    private PostSourceType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
