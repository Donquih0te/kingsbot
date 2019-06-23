package vk.sdk.objects.photos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;

/**
 *  При использовании параметра photo_sizes = 1 в методах для работы с фотографиями,
 *  в ответе возвращается информация о копиях исходного изображения разных размеров.
 *  Для фотографий, загруженных на сайт до 2012 года, значения width и height могут быть недоступны,
 *  в этом случае соответствующие поля содержат 0.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhotoSize {

    /**
     *  Тип копии.
     */
    @JsonProperty("type")
    PhotoSizeType type;

    /**
     *  URL копии.
     */
    @JsonProperty("url")
    URL url;

    /**
     *  Высота в px.
     */
    @JsonProperty("width")
    Integer width;

    /**
     *  Ширина в px.
     */
    @JsonProperty("height")
    Integer height;

}
