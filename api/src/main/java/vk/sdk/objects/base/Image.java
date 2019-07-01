package vk.sdk.objects.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;

/**
 *  Объект, описывающий изображение для стикера.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Image {

    /**
     *  URL копии изображения.
     */
    @Getter
    @JsonProperty("url")
    URL url;

    /**
     *  Ширина копии в px.
     */
    @Getter
    @JsonProperty("width")
    Integer width;

    /**
     *  Высота копии в px.
     */
    @Getter
    @JsonProperty("height")
    Integer height;

}
