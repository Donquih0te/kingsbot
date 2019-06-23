package vk.sdk.objects.photos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Photo {

    /**
     *
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *
     */
    @Getter
    @JsonProperty("album_id")
    Integer albumId;

    /**
     *
     */
    @Getter
    @JsonProperty("owner_id")
    Integer ownerId;

    /**
     *
     */
    @Getter
    @JsonProperty("user_id")
    Integer userId;

    /**
     *
     */
    @Getter
    @JsonProperty("text")
    String text;

    /**
     *
     */
    @Getter
    @JsonProperty("date")
    Long date;

    /**
     *
     */
    @Getter
    @JsonProperty("sizes")
    List<Object> sizes;

    /**
     *
     */
    @Getter
    @JsonProperty("width")
    Optional<Integer> width;

    /**
     *
     */
    @Getter
    @JsonProperty("height")
    Optional<Integer> height;

}
