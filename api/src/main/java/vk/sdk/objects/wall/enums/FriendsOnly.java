package vk.sdk.objects.wall.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum FriendsOnly implements EnumParam {

    YES(1);

    private Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }
}
