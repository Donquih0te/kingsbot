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
<<<<<<< HEAD
import java.util.Collections;
=======
>>>>>>> modularity
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

<<<<<<< HEAD

    /**********************************************************************
     *
     *  Далее идут опциональные поля, задаваемые параметром extended = 1
     *
     *//////////////////////////////////////////////////////////////////////


=======
>>>>>>> modularity
    /**
     *  Изображения товара.
     */
    @Getter
    @JsonProperty("photos")
<<<<<<< HEAD
    List<Photo> photos = Collections.emptyList();
=======
    Optional<List<Photo>> photos;
>>>>>>> modularity

    /**
     *  Возможность комментировать товар для текущего пользователя
     *  (1 — есть, 0 — нет).
     */
    @Getter
    @JsonProperty("can_comment")
<<<<<<< HEAD
    Optional<BoolInt> canComment = Optional.empty();
=======
    Optional<BoolInt> canComment;
>>>>>>> modularity

    /**
     *  Возможность сделать репост товара для текущего пользователя
     *  (1 — есть, 0 — нет).
     */
    @Getter
    @JsonProperty("can_repost")
<<<<<<< HEAD
    Optional<BoolInt> canRepost = Optional.empty();
=======
    Optional<BoolInt> canRepost;
>>>>>>> modularity

    /**
     *  Информация об отметках «Мне нравится».
     */
    @Getter
    @JsonProperty("likes")
<<<<<<< HEAD
    Optional<ProductLikes> likes = Optional.empty();
=======
    Optional<ProductLikes> likes;
>>>>>>> modularity

    /**
     *  Ссылка на товар во внешних ресурсах.
     */
    @Getter
    @JsonProperty("url")
<<<<<<< HEAD
    Optional<URL> url = Optional.empty();
=======
    Optional<URL> url;
>>>>>>> modularity

    /**
     *  Текст на кнопке товара.
     */
    @Getter
    @JsonProperty("button_title")
<<<<<<< HEAD
    Optional<ProductButtonTitle> buttonTittle = Optional.empty();
=======
    Optional<ProductButtonTitle> buttonTittle;
>>>>>>> modularity

}
