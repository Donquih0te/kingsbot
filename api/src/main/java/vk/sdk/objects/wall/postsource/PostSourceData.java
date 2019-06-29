package vk.sdk.objects.wall.postsource;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PostSourceData implements EnumParam {

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

    @Override
    public String getValue() {
        return value;
    }

}
