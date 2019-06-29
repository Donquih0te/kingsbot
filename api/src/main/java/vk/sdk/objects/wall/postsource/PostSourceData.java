package vk.sdk.objects.wall.postsource;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonProperty;
=======
>>>>>>> modularity
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PostSourceData implements EnumParam {

<<<<<<< HEAD
    @JsonProperty("profile_active")
    PROFILE_ACTIVE("profile_active"),

    @JsonProperty("profile_photo")
    PROFILE_PHOTO("profile_photo"),

    @JsonProperty("comments")
    COMMENTS("comments"),

    @JsonProperty("like")
    LIKE("like"),

    @JsonProperty("pool")
    POOL("pool");

    private final String value;
=======
    PROFILE_ACTIVE("profile_active"),
    PROFILE_PHOTO("profile_photo"),
    COMMENTS("comments"),
    LIKE("like"),
    POOL("pool");

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
