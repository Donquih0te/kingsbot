package vk.sdk.objects.docs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;

/**
 *  Данные о граффити.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DocPreviewGraffity {

    /**
     *  URL документа с граффити.
     */
    @Getter
    @JsonProperty("src")
    URL src;

    /**
     *  Ширина изображения в px.
     */
    @Getter
    @JsonProperty("width")
    Integer width;

    /**
     *  Высота изображения в px.
     */
    @Getter
    @JsonProperty("height")
    Integer height;

}
