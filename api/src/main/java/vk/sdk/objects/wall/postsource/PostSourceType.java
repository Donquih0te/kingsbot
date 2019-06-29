package vk.sdk.objects.wall.postsource;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonProperty;
=======
>>>>>>> modularity
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PostSourceType implements EnumParam {

<<<<<<< HEAD
    @JsonProperty("vk")
    VK("vk"),

    @JsonProperty("widget")
    WIDGET("widget"),

    @JsonProperty("api")
    API("api"),

    @JsonProperty("rss")
    RSS("rss"),

    @JsonProperty("sms")
    SMS("sms");

    private final String value;
=======
    VK("vk"),
    WIDGET("widget"),
    API("api"),
    RSS("rss"),
    SMS("sms");

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
