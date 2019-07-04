package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;

/**
 *  Объект, описывающий информацию о ссылке из блока ссылок сообщества.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupLink {

    /**
     *  Идентификатор ссылки.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  URL.
     */
    @Getter
    @JsonProperty("url")
    URL url;

    /**
     *  Название ссылки.
     */
    @Getter
    @JsonProperty("name")
    String name;

    /**
     *  Описание ссылки.
     */
    @Getter
    @JsonProperty("desc")
    String description;

    /**
     *  URL изображения-превью шириной 50px.
     */
    @Getter
    @JsonProperty("photo_50")
    URL photo50;

    /**
     *  URL изображения-превью шириной 100px.
     */
    @Getter
    @JsonProperty("photo_100")
    URL photo100;

}
