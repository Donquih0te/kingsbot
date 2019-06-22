package vk.sdk.objects.wall.enums;

import vk.sdk.objects.utils.EnumParam;

public enum PostType implements EnumParam {

    POST("post"),
    COPY("copy"),
    REPLY("reply"),
    POSTPONE("postpone"),
    SUGGEST("suggest");

    private String value;

    private PostType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

}
