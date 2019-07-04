package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;

/**
 *  Объект, описывающий копию изображения обложки сообщества.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupCoverImage {

    /**
     *  URL копии.
     */
    @Getter
    @JsonProperty("url")
    URL url;


    /**
     *  Ширина копии.
     */
    @Getter
    @JsonProperty("width")
    Integer width;


    /**
     *  Высота копии.
     */
    @Getter
    @JsonProperty("height")
    Integer height;

}
