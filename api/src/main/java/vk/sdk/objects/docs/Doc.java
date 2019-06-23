package vk.sdk.objects.docs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;

/**
 *  Объект, описывающий документ.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Doc {

    /**
     *  Идентификатор документа.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Идентификатор пользователя, загрузившего документ.
     */
    @Getter
    @JsonProperty("owner_id")
    Integer ownerId;

    /**
     *  Название документа.
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
     *  Размер документа в байтах.
     */
    @Getter
    @JsonProperty("size")
    Integer size;

    /**
     *  Расширение документа.
     */
    @Getter
    @JsonProperty("ext")
    String extension;

    /**
     *  Адрес документа, по которому его можно загрузить.
     */
    @Getter
    @JsonProperty("url")
    URL url;

    /**
     *  Дата добавления в формате UnixTime.
     */
    @Getter
    @JsonProperty("date")
    Long date;

    /**
     *  Тип документа.
     */
    @Getter
    @JsonProperty("type")
    DocType type;

    /**
     *  Информация для предварительного просмотра документа.
     */
    @Getter
    @JsonProperty("preview")
    DocPreview preview;

}
