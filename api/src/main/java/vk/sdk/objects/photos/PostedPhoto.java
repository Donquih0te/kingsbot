package vk.sdk.objects.photos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;

/**
 *  Устаревший тип вложения. Он может быть возвращен лишь для записей, созданных раньше 2013 года.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostedPhoto {

    /**
     *  Идентификатор фотографии.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Идентификатор владельца фотографии.
     */
    @Getter
    @JsonProperty("owner_id")
    Integer ownerId;

    /**
     *  URL изображения для предпросмотра.
     */
    @Getter
    @JsonProperty("photo_130")
    URL photo130;

    /**
     *  URL полноразмерного изображения.
     */
    @Getter
    @JsonProperty("photo_640")
    URL photo640;

}
