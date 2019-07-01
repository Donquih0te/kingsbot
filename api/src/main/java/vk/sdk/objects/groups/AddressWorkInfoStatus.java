package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AddressWorkInfoStatus implements EnumParam {

    @JsonProperty("no_information")
    NO_INFORMATION("no_information"),

    @JsonProperty("temporarily_closed")
    TEMPORARILY_CLOSED("temporarily_closed"),

    @JsonProperty("always_opened")
    ALWAYS_OPENED("always_opened"),

    @JsonProperty("forever_closed")
    FOREVER_CLOSED("forever_closed"),

    @JsonProperty("timetable")
    TIMETABLE("timetable");

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

}
