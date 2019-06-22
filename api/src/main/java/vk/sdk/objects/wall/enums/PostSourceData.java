package vk.sdk.objects.wall.enums;

import vk.sdk.objects.utils.EnumParam;

public enum PostSourceData implements EnumParam {

    PROFILE_ACTIVE("profile_active"),
    PROFILE_PHOTO("profile_photo"),
    COMMENTS("comments"),
    LIKE("like"),
    POOL("pool");

    private String value;

    public PostSourceData(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
