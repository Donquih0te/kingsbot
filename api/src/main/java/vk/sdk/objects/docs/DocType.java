package vk.sdk.objects.docs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DocType implements EnumParam {

    /**
     *  Текстовые документы.
     */
    @JsonProperty("1")
    TEXT_DOC(1),

    /**
     *  Архивы.
     */
    @JsonProperty("2")
    ARCHIVE(2),

    /**
     *  Gif.
     */
    @JsonProperty("3")
    GIF(3),

    /**
     *  Изображения.
     */
    @JsonProperty("4")
    IMAGE(4),

    /**
     *  Аудио.
     */
    @JsonProperty("5")
    AUDIO(5),

    /**
     *  Видео.
     */
    @JsonProperty("6")
    VIDEO(6),

    /**
     *  Электронные книги.
     */
    @JsonProperty("7")
    EBOOK(7),

    /**
     *  Неизвестный тип документа.
     */
    @JsonProperty("8")
    UNKNOWN(8);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
