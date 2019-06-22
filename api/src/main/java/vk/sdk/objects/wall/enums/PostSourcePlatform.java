package vk.sdk.objects.wall.enums;

import vk.sdk.objects.utils.EnumParam;

public enum PostSourcePlatform implements EnumParam {

    ANDROID("android"),
    IPHONE("iphone"),
    WPHONE("wphone");

    private String value;

    public PostSourcePlatform(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
