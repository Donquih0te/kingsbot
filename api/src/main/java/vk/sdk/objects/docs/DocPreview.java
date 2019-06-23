package vk.sdk.objects.docs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Информация для предварительного просмотра документа.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DocPreview {

    /**
     *  Изображения для предпросмотра.
     */
    @Getter
    @JsonProperty("photo")
    DocPreviewPhoto photo;

    /**
     *  Данные о граффити.
     */
    @Getter
    @JsonProperty("graffity")
    DocPreviewGraffity graffity;

    /**
     *  Данные об аудиосообщении.
     */
    @Getter
    @JsonProperty("audio_message")
    DocPreviewAudioMessage audioMessage;

}
