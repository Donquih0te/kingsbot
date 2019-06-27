package vk.sdk.objects.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.photos.Photo;
import vk.sdk.objects.utils.BoolInt;

import java.net.URL;
import java.util.List;
import java.util.Optional;

/**
 *  Объект, описывающий товар.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    /**
     *  Идентификатор товара.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Идентификатор владельца товара.
     */
    @Getter
    @JsonProperty("owner_id")
    Integer ownerId;

    /**
     *  Название товара.
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
     *  Текст описания товара.
     */
    @Getter
    @JsonProperty("description")
    String description;

    /**
     *  Цена товара.
     */
    @Getter
    @JsonProperty("price")
    ProductPrice price;

    /**
     *  Категория товара.
     */
    @Getter
    @JsonProperty("category")
    Object category;

    /**
     *  URL изображения-обложки товара.
     */
    @Getter
    @JsonProperty("thumb_photo")
    URL thumbPhoto;

    /**
     *  Дата создания товара в формате UnixTime.
     */
    @Getter
    @JsonProperty("date")
    Long date;

    /**
     *  Статус доступности товара.
     */
    @Getter
    @JsonProperty("availability")
    ProductAvailability availability;

    /**
     *  True, если объект добавлен в закладки у текущего пользователя.
     */
    @Getter
    @JsonProperty("is_favorite")
    boolean isFavorite;

    /**
     *  Изображения товара.
     */
    @Getter
    @JsonProperty("photos")
    Optional<List<Photo>> photos;

    /**
     *  Возможность комментировать товар для текущего пользователя
     *  (1 — есть, 0 — нет).
     */
    @Getter
    @JsonProperty("can_comment")
    Optional<BoolInt> canComment;

    /**
     *  Возможность сделать репост товара для текущего пользователя
     *  (1 — есть, 0 — нет).
     */
    @Getter
    @JsonProperty("can_repost")
    Optional<BoolInt> canRepost;

    /**
     *  Информация об отметках «Мне нравится».
     */
    @Getter
    @JsonProperty("likes")
    Optional<ProductLikes> likes;

    /**
     *  Ссылка на товар во внешних ресурсах.
     */
    @Getter
    @JsonProperty("url")
    Optional<URL> url;

    /**
     *  Текст на кнопке товара.
     */
    @Getter
    @JsonProperty("button_title")
    Optional<ProductButtonTitle> buttonTittle;

}
