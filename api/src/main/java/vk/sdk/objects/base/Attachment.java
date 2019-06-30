package vk.sdk.objects.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.apps.AppOld;
import vk.sdk.objects.audio.Audio;
import vk.sdk.objects.docs.Doc;
import vk.sdk.objects.docs.Graffity;
import vk.sdk.objects.link.Link;
import vk.sdk.objects.market.Product;
import vk.sdk.objects.market.ProductAlbum;
import vk.sdk.objects.messages.PrettyCard;
import vk.sdk.objects.messages.Sticker;
import vk.sdk.objects.notes.Note;
import vk.sdk.objects.pages.WikiPage;
import vk.sdk.objects.photos.Photo;
import vk.sdk.objects.photos.PhotoAlbum;
import vk.sdk.objects.photos.PostedPhoto;
import vk.sdk.objects.polls.Pool;
import vk.sdk.objects.video.Video;

import java.util.Collections;
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
public class Attachment {

    /**
     *  Тип вложения.
     */
    @Getter
    @JsonProperty("type")
    AttachmentType type;

    /**
     *  Фотография.
     */
    @Getter
    @JsonProperty("photo")
    Optional<Photo> photo = Optional.empty();

    /**
     *  Фотография, загруженная напрямую.
     */
    @Getter
    @JsonProperty("posted_photo")
    Optional<PostedPhoto> postedPhoto = Optional.empty();

    /**
     *  Видеозапись.
     */
    @Getter
    @JsonProperty("video")
    Optional<Video> video = Optional.empty();

    /**
     *  Аудиозапись.
     */
    @Getter
    @JsonProperty("audio")
    Optional<Audio> audio = Optional.empty();

    /**
     *  Документ.
     */
    @Getter
    @JsonProperty("doc")
    Optional<Doc> doc = Optional.empty();

    /**
     *  Граффити.
     */
    @Getter
    @JsonProperty("graffity")
    Optional<Graffity> graffity = Optional.empty();

    /**
     *  Ссылка.
     */
    @Getter
    @JsonProperty("link")
    Optional<Link> link = Optional.empty();

    /**
     *  Заметка.
     */
    @Getter
    @JsonProperty("note")
    Optional<Note> note = Optional.empty();

    /**
     *  Приложение.
     */
    @Getter
    @JsonProperty("app")
    Optional<AppOld> app = Optional.empty();

    /**
     *  Опрос.
     */
    @Getter
    @JsonProperty("poll")
    Optional<Pool> poll = Optional.empty();

    /**
     *  Вики-страница.
     */
    @Getter
    @JsonProperty("page")
    Optional<WikiPage> page = Optional.empty();

    /**
     *  Альбом с фотографиями.
     */
    @Getter
    @JsonProperty("album")
    Optional<PhotoAlbum> album = Optional.empty();

    /**
     *  Массив из строк, содержащих идентификаторы фотографий.
     *  Сами фотографии дублируются в виде приложенных объектов фотографий, однако этот список необходим в случае,
     *  если фотографий использовано больше максимального количества возвращаемых вложений (10).
     */
    @Getter
    @JsonProperty("photos_list")
    List<String> photosList = Collections.emptyList();

    /**
     *  Товар.
     */
    @Getter
    @JsonProperty("market")
    Optional<Product> market = Optional.empty();

    /**
     *  Подборка товаров.
     */
    @Getter
    @JsonProperty("market_album")
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

}
