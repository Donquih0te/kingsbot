package vk.sdk.objects.docs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;
import java.util.List;

/**
 *  Данные об аудиосообщении.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DocPreviewAudioMessage {

    /**
     *  Длительность аудиосообщения в секундах.
     */
    @Getter
    @JsonProperty("duration")
    Integer duration;

    /**
     *  Массив значений для визуального отображения звука.
     */
    @Getter
    @JsonProperty("waveform")
    List<Integer> waveform;

    /**
     *  URL ".ogg"-файла.
     */
    @Getter
    @JsonProperty("link_ogg")
    URL linkOgg;

    /**
     *  URL ".mp3"-файла.
     */
    @Getter
    @JsonProperty("link_mp3")
    URL linkMp3;

}
