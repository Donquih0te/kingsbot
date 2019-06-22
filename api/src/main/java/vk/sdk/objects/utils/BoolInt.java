package vk.sdk.objects.utils;

public enum BoolInt implements EnumParam {

    NO(0),
    YES(1);

    private final Integer value;

    private BoolInt(Integer value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value.toString();
    }

}
