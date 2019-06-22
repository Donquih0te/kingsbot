package vk.sdk.objects.wall.enums;

import vk.sdk.objects.utils.EnumParam;

public enum FriendsOnly implements EnumParam {

    YES(1);

    private Integer value;

    private FriendsOnly(Integer value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value.toString();
    }
}
