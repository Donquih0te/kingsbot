package vk.sdk.objects.docs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.photos.PhotoSize;

import java.util.List;

/**
 *  Изображения для предпросмотра документа.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DocPreviewPhoto {

    /**
     *  Массив копий изображения в разных размерах.
     */
    @Getter
    @JsonProperty("sizes")
    List<PhotoSize> sizes;

}
