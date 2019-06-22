package vk.sdk.objects.utils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum BoolInt implements EnumParam {

    NO(0),
    YES(1);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
