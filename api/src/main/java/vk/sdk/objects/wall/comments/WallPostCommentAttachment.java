package vk.sdk.objects.wall.comments;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

/**
 *  Информация о медиавложениях в записях и комментариях на стене возвращается в виде массива attachments.
 *  Каждый элемент массива представляет собой объект с двумя полями.
 *  Первое поле — type (string) содержит тип вложения (photo,note,audio и т.д.).
 *  Название второго поля совпадает со значением, переданным в type.
 *  Второе поле содержит объект, представляющий медиавложение.
 *  Структура объекта в этом поле зависит от его типа.
 *  <p>
 *  Схематичное представление объекта attachments для двух вложений (фото и аудио):
 *  [
 *    {
 *      "type": "photo",
 *      "photo": {photo}
 *      }, {
 *      "type": "audio",
 *      "audio": {audio}
 *    }
 *  ]
 *  </p>
 *  Каждый объект может содержать дополнительное поле access_key — ключ доступа к контенту.
 *  При получении объектов, прямого доступа к которым может не быть, например, фотографий или видео в новостях,
 *  вместе с объектами приходит поле access_key, которое необходимо передавать при получении этих объектов напрямую
 *  или при совершении с ними действий.
 *
 *  Например, поле access_key принимают методы video.get, photos.getById.
 *  access_key нужно добавить к строковому id объекта через символ подчеркивания:
 *      123456_654312_6d103522bc13b790c5
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WallPostCommentAttachment {

    /**
     *  Тип вложения.
     */
    @Getter
    @SerializedName("type")
    WallPostCommentAttachmentType type;

    /**
     *
     */
    @Getter
    @SerializedName("photo")
    Optional<Object> photo;

    /**
     *
     */
    @Getter
    @SerializedName("posted_photo")
    Optional<Object> postedPhoto;

    /**
     *
     */
    @Getter
    @SerializedName("video")
    Optional<Object> video;

    /**
     *
     */
    @Getter
    @SerializedName("audio")
    Optional<Object> audio;

    /**
     *
     */
    @Getter
    @SerializedName("doc")
    Optional<Object> doc;

    /**
     *
     */
    @Getter
    @SerializedName("graffity")
    Optional<Object> graffity;

    /**
     *
     */
    @Getter
    @SerializedName("link")
    Optional<Object> link;

    /**
     *
     */
    @Getter
    @SerializedName("note")
    Optional<Object> note;

    /**
     *
     */
    @Getter
    @SerializedName("app")
    Optional<Object> app;

    /**
     *
     */
    @Getter
    @SerializedName("poll")
    Optional<Object> poll;

    /**
     *
     */
    @Getter
    @SerializedName("page")
    Optional<Object> page;

    /**
     *
     */
    @Getter
    @SerializedName("album")
    Optional<Object> album;

    /**
     *
     */
    @Getter
    @SerializedName("photos_list")
    Optional<Object> photosList;

    /**
     *
     */
    @Getter
    @SerializedName("market")
    Optional<Object> market;

    /**
     *
     */
    @Getter
    @SerializedName("market_album")
    Optional<Object> marketAlbum;

    /**
     *
     */
    @Getter
    @SerializedName("sticker")
    Optional<Object> sticker;

    /**
     *
     */
    @Getter
    @SerializedName("prettyCards")
    Optional<Object> prettyCards;

}
