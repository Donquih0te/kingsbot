package vk.sdk.objects.wall.postsource;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonProperty;
=======
>>>>>>> modularity
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PostSourcePlatform implements EnumParam {

<<<<<<< HEAD
    @JsonProperty("android")
    ANDROID("android"),

    @JsonProperty("iphone")
    IPHONE("iphone"),

    @JsonProperty("wphone")
    WPHONE("wphone");

    private final String value;
=======
    ANDROID("android"),
    IPHONE("iphone"),
    WPHONE("wphone");

    private String value;
>>>>>>> modularity

    @Override
    public String getValue() {
        return value;
    }
<<<<<<< HEAD

=======
>>>>>>> modularity
}
