package vk.sdk.objects.wall;

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
import vk.sdk.objects.market.Product;
import vk.sdk.objects.market.ProductAlbum;
<<<<<<< HEAD
import vk.sdk.objects.messages.PrettyCard;
import vk.sdk.objects.messages.Sticker;
=======
>>>>>>> modularity
import vk.sdk.objects.notes.Note;
import vk.sdk.objects.pages.WikiPage;
import vk.sdk.objects.photos.Photo;
import vk.sdk.objects.photos.PhotoAlbum;
import vk.sdk.objects.photos.PostedPhoto;
import vk.sdk.objects.polls.Pool;
import vk.sdk.objects.video.Video;
<<<<<<< HEAD

import java.util.Collections;
=======
import vk.sdk.objects.wall.comments.WallPostCommentAttachmentType;

>>>>>>> modularity
import java.util.List;
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
public class WallPostAttachment {

    /**
     *  Тип вложения.
     */
    @Getter
    @JsonProperty("type")
<<<<<<< HEAD
    WallPostAttachmentType type;
=======
    WallPostCommentAttachmentType type;
>>>>>>> modularity

    /**
     *  Фотография.
     */
    @Getter
    @JsonProperty("photo")
<<<<<<< HEAD
    Optional<Photo> photo = Optional.empty();
=======
    Optional<Photo> photo;
>>>>>>> modularity

    /**
     *  Фотография, загруженная напрямую.
     */
    @Getter
    @JsonProperty("posted_photo")
<<<<<<< HEAD
    Optional<PostedPhoto> postedPhoto = Optional.empty();
=======
    Optional<PostedPhoto> postedPhoto;
>>>>>>> modularity

    /**
     *  Видеозапись.
     */
    @Getter
    @JsonProperty("video")
<<<<<<< HEAD
    Optional<Video> video = Optional.empty();
=======
    Optional<Video> video;
>>>>>>> modularity

    /**
     *  Аудиозапись.
     */
    @Getter
    @JsonProperty("audio")
<<<<<<< HEAD
    Optional<Audio> audio = Optional.empty();
=======
    Optional<Audio> audio;
>>>>>>> modularity

    /**
     *  Документ.
     */
    @Getter
    @JsonProperty("doc")
<<<<<<< HEAD
    Optional<Doc> doc = Optional.empty();
=======
    Optional<Doc> doc;
>>>>>>> modularity

    /**
     *  Граффити.
     */
    @Getter
    @JsonProperty("graffity")
<<<<<<< HEAD
    Optional<Graffity> graffity = Optional.empty();
=======
    Optional<Graffity> graffity;
>>>>>>> modularity

    /**
     *  Ссылка.
     */
    @Getter
    @JsonProperty("link")
<<<<<<< HEAD
    Optional<Link> link = Optional.empty();
=======
    Optional<Link> link;
>>>>>>> modularity

    /**
     *  Заметка.
     */
    @Getter
    @JsonProperty("note")
<<<<<<< HEAD
    Optional<Note> note = Optional.empty();
=======
    Optional<Note> note;
>>>>>>> modularity

    /**
     *  Приложение.
     */
    @Getter
    @JsonProperty("app")
<<<<<<< HEAD
    Optional<App> app = Optional.empty();
=======
    Optional<App> app;
>>>>>>> modularity

    /**
     *  Опрос.
     */
    @Getter
    @JsonProperty("poll")
<<<<<<< HEAD
    Optional<Pool> poll = Optional.empty();
=======
    Optional<Pool> poll;
>>>>>>> modularity

    /**
     *  Вики-страница.
     */
    @Getter
    @JsonProperty("page")
<<<<<<< HEAD
    Optional<WikiPage> page = Optional.empty();
=======
    Optional<WikiPage> page;
>>>>>>> modularity

    /**
     *  Альбом с фотографиями.
     */
    @Getter
    @JsonProperty("album")
<<<<<<< HEAD
    Optional<PhotoAlbum> album = Optional.empty();
=======
    Optional<PhotoAlbum> album;
>>>>>>> modularity

    /**
     *  Массив из строк, содержащих идентификаторы фотографий.
     *  Сами фотографии дублируются в виде приложенных объектов фотографий, однако этот список необходим в случае,
     *  если фотографий использовано больше максимального количества возвращаемых вложений (10).
     */
    @Getter
    @JsonProperty("photos_list")
<<<<<<< HEAD
    List<String> photosList = Collections.emptyList();
=======
    List<String> photosList;
>>>>>>> modularity

    /**
     *  Товар.
     */
    @Getter
    @JsonProperty("market")
<<<<<<< HEAD
    Optional<Product> market = Optional.empty();
=======
    Optional<Product> market;
>>>>>>> modularity

    /**
     *  Подборка товаров.
     */
    @Getter
    @JsonProperty("market_album")
<<<<<<< HEAD
    Optional<ProductAlbum> marketAlbum = Optional.empty();

    /**
     *  Стикер.
     */
    @Getter
    @JsonProperty("sticker")
    Optional<Sticker> sticker = Optional.empty();

    /**
     *  Массив элементов-карточек.
     */
    @Getter
    @JsonProperty("prettyCards")
    List<PrettyCard> prettyCards = Collections.emptyList();
=======
    Optional<ProductAlbum> marketAlbum;

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
>>>>>>> modularity

}
