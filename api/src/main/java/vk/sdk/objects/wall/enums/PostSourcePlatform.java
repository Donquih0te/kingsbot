package vk.sdk.objects.wall.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PostSourcePlatform implements EnumParam {

    ANDROID("android"),
    IPHONE("iphone"),
    WPHONE("wphone");

    private String value;

    @Override
    public String getValue() {
        return value;
    }
}
