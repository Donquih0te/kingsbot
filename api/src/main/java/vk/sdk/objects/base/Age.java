package vk.sdk.objects.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Age implements EnumParam {

    @JsonProperty("12-18")
    A12_18("12-18"),

    @JsonProperty("18-21")
    A18_21("18-21"),

    @JsonProperty("21-24")
    A21_24("21-24"),

    @JsonProperty("24-27")
    A24_27("24-27"),

    @JsonProperty("27-30")
    A27_30("27-30"),

    @JsonProperty("30-35")
    A30_35("30-35"),

    @JsonProperty("35_45")
    A35_45("35_45"),

    @JsonProperty("45-100")
    A45_100("45-100");

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

}
