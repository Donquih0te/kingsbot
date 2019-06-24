package vk.sdk.objects.link;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.photos.Photo;

import java.net.URL;
import java.util.Optional;

/**
 *  Объект, описывающий прикрепленную ссылку в сообщении, комментарии или записи на стене.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Link {

    /**
     *  URL ссылки.
     */
    @Getter
    @JsonProperty("url")
    URL url;

    /**
     *  Заголовок ссылки.
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
     *  Подпись ссылки (если имеется).
     */
    @Getter
    @JsonProperty("caption")
    Optional<String> caption;

    /**
     *  Описание ссылки.
     */
    @Getter
    @JsonProperty("description")
    String description;

    /**
     *  Изображение превью (если имеется).
     */
    @Getter
    @JsonProperty("photo")
    Optional<Photo> photo;

    /**
     *  Информация о продукте (если имеется).
     *  Поле возвращается для ссылок на магазины, например, Aliexpress.
     */
    @Getter
    @JsonProperty("product")
    Optional<LinkProduct> product;

    /**
     *  Информация о кнопке для перехода (если имеется).
     */
    @Getter
    @JsonProperty("button")
    Optional<LinkButton> button;

    /**
     *  Идентификатор вики-страницы с контентом для предпросмотра содержимого страницы.
     *  Возвращается в формате "owner_id_page_id".
     */
    @Getter
    @JsonProperty("preview_page")
    String previewPage;

    /**
     *  URL страницы с контентом для предпросмотра содержимого страницы.
     */
    @Getter
    @JsonProperty("preview_url")
    URL previewUrl;

}
