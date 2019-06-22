package vk.sdk.objects.wall.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PostSourceData implements EnumParam {

    PROFILE_ACTIVE("profile_active"),
    PROFILE_PHOTO("profile_photo"),
    COMMENTS("comments"),
    LIKE("like"),
    POOL("pool");

    private String value;

    @Override
    public String getValue() {
        return value;
    }
}
