package vk.sdk.objects.wall;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PostType implements EnumParam {

    POST("post"),
    COPY("copy"),
    REPLY("reply"),
    POSTPONE("postpone"),
    SUGGEST("suggest");

    private String value;

    @Override
    public String getValue() {
        return value;
    }

}
