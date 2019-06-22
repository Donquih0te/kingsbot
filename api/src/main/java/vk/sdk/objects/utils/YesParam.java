package vk.sdk.objects.utils;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum YesParam implements EnumParam {

    YES(1);

    private Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }
}
