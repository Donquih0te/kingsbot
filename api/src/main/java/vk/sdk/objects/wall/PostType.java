package vk.sdk.objects.wall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PostType implements EnumParam {

    @JsonProperty("post")
    POST("post"),

    @JsonProperty("copy")
    COPY("copy"),

    @JsonProperty("reply")
    REPLY("reply"),

    @JsonProperty("postpone")
    POSTPONE("postpone"),

    @JsonProperty("suggest")
    SUGGEST("suggest");

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

}
