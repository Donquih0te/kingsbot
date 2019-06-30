package vk.sdk.objects.apps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AppType implements EnumParam {

    @JsonProperty("app")
    APP("app"),

    @JsonProperty("game")
    GAME("game"),

    @JsonProperty("site")
    SITE("site"),

    @JsonProperty("standalone")
    STANDALONE("standalone");

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

}
