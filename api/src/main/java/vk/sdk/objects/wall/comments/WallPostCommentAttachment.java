package vk.sdk.objects.wall.comments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.apps.App;
import vk.sdk.objects.audio.Audio;
import vk.sdk.objects.docs.Doc;
import vk.sdk.objects.docs.Graffity;
import vk.sdk.objects.link.Link;
import vk.sdk.objects.notes.Note;
import vk.sdk.objects.pages.WikiPage;
import vk.sdk.objects.photos.Photo;
import vk.sdk.objects.photos.PostedPhoto;
import vk.sdk.objects.polls.Pool;
import vk.sdk.objects.video.Video;

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
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WallPostCommentAttachment {

    /**
     *  Тип вложения.
     */
    @Getter
    @JsonProperty("type")
    WallPostCommentAttachmentType type;

    /**
     *  Фотография.
     */
    @Getter
    @JsonProperty("photo")
    Optional<Photo> photo;

    /**
     *  Фотография, загруженная напрямую.
     */
    @Getter
    @JsonProperty("posted_photo")
    Optional<PostedPhoto> postedPhoto;

    /**
     *  Видеозапись.
     */
    @Getter
    @JsonProperty("video")
    Optional<Video> video;

    /**
     *  Аудиозапись.
     */
    @Getter
    @JsonProperty("audio")
    Optional<Audio> audio;

    /**
     *  Документ.
     */
    @Getter
    @JsonProperty("doc")
    Optional<Doc> doc;

    /**
     *  Граффити.
     */
    @Getter
    @JsonProperty("graffity")
    Optional<Graffity> graffity;

    /**
     *  Ссылка.
     */
    @Getter
    @JsonProperty("link")
    Optional<Link> link;

    /**
     *  Заметка.
     */
    @Getter
    @JsonProperty("note")
    Optional<Note> note;

    /**
     *  Приложение.
     */
    @Getter
    @JsonProperty("app")
    Optional<App> app;

    /**
     *  Опрос.
     */
    @Getter
    @JsonProperty("poll")
    Optional<Pool> poll;

    /**
     *  Вики-страница.
     */
    @Getter
    @JsonProperty("page")
    Optional<WikiPage> page;

    /**
     *
     */
    @Getter
    @JsonProperty("album")
    Optional<Object> album;

    /**
     *
     */
    @Getter
    @JsonProperty("photos_list")
    Optional<Object> photosList;

    /**
     *
     */
    @Getter
    @JsonProperty("market")
    Optional<Object> market;

    /**
     *
     */
    @Getter
    @JsonProperty("market_album")
    Optional<Object> marketAlbum;

    /**
     *
     */
    @Getter
    @JsonProperty("sticker")
    Optional<Object> sticker;

    /**
     *
     */
    @Getter
    @JsonProperty("prettyCards")
    Optional<Object> prettyCards;

}
