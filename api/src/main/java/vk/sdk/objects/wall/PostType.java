package vk.sdk.objects.wall;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonProperty;
=======
>>>>>>> modularity
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PostType implements EnumParam {

<<<<<<< HEAD
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
=======
    POST("post"),
    COPY("copy"),
    REPLY("reply"),
    POSTPONE("postpone"),
    SUGGEST("suggest");

    private String value;
>>>>>>> modularity

    @Override
    public String getValue() {
        return value;
    }

}
