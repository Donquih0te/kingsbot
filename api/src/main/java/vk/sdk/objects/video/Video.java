package vk.sdk.objects.video;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.utils.BoolInt;
import vk.sdk.objects.utils.YesParam;

import java.net.URL;
import java.util.Optional;

/**
 *  Объект, описывающий видеозапись.
 *  <p>
 *  При получении объектов, прямого доступа к которым может не быть, например, фотографий или видео в новостях,
 *  вместе с объектами приходит поле access_key, которое необходимо передавать при получении этих объектов напрямую
 *  или при совершении с ними действий.
 *  </p>
 *  access_key нужно добавить к строковому id объекта через символ подчеркивания:
 *      123456_654312_6d103522bc13b790c5
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Video {

    /**
<<<<<<< HEAD
     *  Идентификатор видеозаписи.
=======
     *  идентификатор видеозаписи.
>>>>>>> modularity
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
<<<<<<< HEAD
     *  Идентификатор владельца видеозаписи.
=======
     *  идентификатор владельца видеозаписи.
>>>>>>> modularity
     */
    @Getter
    @JsonProperty("owner_id")
    Integer ownerId;

    /**
<<<<<<< HEAD
     *  Название видеозаписи.
=======
     *  название видеозаписи.
>>>>>>> modularity
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
<<<<<<< HEAD
     *  Текст описания видеозаписи.
=======
     *  текст описания видеозаписи.
>>>>>>> modularity
     */
    @Getter
    @JsonProperty("description")
    String description;

    /**
<<<<<<< HEAD
     *  Длительность ролика в секундах.
=======
     *  длительность ролика в секундах.
>>>>>>> modularity
     */
    @Getter
    @JsonProperty("duration")
    Integer duration;

    /**
     *  URL изображения-обложки ролика с размером 130x98 px.
     */
    @Getter
    @JsonProperty("photo_130")
    URL photo130;

    /**
     *  URL изображения-обложки ролика с размером 320x240 px.
     */
    @Getter
    @JsonProperty("photo_320")
    URL photo320;

    /**
     *  URL изображения-обложки ролика с размером 640x480 px (если размер есть).
     */
    @Getter
    @JsonProperty("photo_640")
<<<<<<< HEAD
    Optional<URL> photo640 = Optional.empty();
=======
    Optional<URL> photo640;
>>>>>>> modularity

    /**
     *  URL изображения-обложки ролика с размером 800x450 px (если размер есть).
     */
    @Getter
    @JsonProperty("photo_800")
<<<<<<< HEAD
    Optional<URL> photo800 = Optional.empty();
=======
    Optional<URL> photo800;
>>>>>>> modularity

    /**
     *  URL изображения-обложки ролика с размером до 1280 px по ширине (если размер есть).
     */
    @Getter
    @JsonProperty("photo_1280")
<<<<<<< HEAD
    Optional<URL> photo1280 = Optional.empty();
=======
    Optional<URL> photo1280;
>>>>>>> modularity

    /**
     *  URL изображения первого кадра ролика с размером 130x98 px.
     */
    @Getter
    @JsonProperty("first_frame_130")
    URL firstFrame130;

    /**
     *  URL изображения первого кадра ролика с размером 320x240 px.
     */
    @Getter
    @JsonProperty("first_frame_320")
    URL firstFrame320;

    /**
     *  URL изображения первого кадра ролика с размером 640x480 px (если размер есть).
     */
    @Getter
    @JsonProperty("first_frame_640")
<<<<<<< HEAD
    Optional<URL> firstFrame640 = Optional.empty();
=======
    Optional<URL> firstFrame640;
>>>>>>> modularity

    /**
     *  URL изображения первого кадра ролика с размером 800x450 px (если размер есть).
     */
    @Getter
    @JsonProperty("first_frame_800")
<<<<<<< HEAD
    Optional<URL> firstFrame800 = Optional.empty();
=======
    Optional<URL> firstFrame800;
>>>>>>> modularity

    /**
     *  URL изображения первого кадра ролика с шириной до 1028 px (если размер есть).
     */
    @Getter
    @JsonProperty("first_frame_1280")
<<<<<<< HEAD
    Optional<URL> firstFrame1280 = Optional.empty();

    /**
     *  Дата создания видеозаписи в формате UnixTime.
=======
    Optional<URL> firstFrame1280;

    /**
     *  дата создания видеозаписи в формате UnixTime.
>>>>>>> modularity
     */
    @Getter
    @JsonProperty("date")
    Long date;

    /**
<<<<<<< HEAD
     *  Дата добавления видеозаписи пользователем или группой в формате UnixTime.
=======
     *  дата добавления видеозаписи пользователем или группой в формате UnixTime.
>>>>>>> modularity
     */
    @Getter
    @JsonProperty("adding_date")
    Long addingDate;

    /**
<<<<<<< HEAD
     *  Количество просмотров видеозаписи.
=======
     *  количество просмотров видеозаписи.
>>>>>>> modularity
     */
    @Getter
    @JsonProperty("views")
    Integer views;

    /**
<<<<<<< HEAD
     *  Количество комментариев к видеозаписи.
=======
     *  количество комментариев к видеозаписи.
>>>>>>> modularity
     */
    @Getter
    @JsonProperty("comments")
    Integer comments;

    /**
     *  URL страницы с плеером, который можно использовать для воспроизведения ролика в браузере.
     *  Поддерживается flash и html5, плеер всегда масштабируется по размеру окна.
     */
    @Getter
    @JsonProperty("player")
    URL player;

    /**
<<<<<<< HEAD
     *  Название платформы (для видеозаписей, добавленных с внешних сайтов).
     */
    @Getter
    @JsonProperty("platform")
    Optional<String> platform = Optional.empty();

    /**
     *  Поле возвращается, если пользователь может редактировать видеозапись, всегда содержит 1.
     */
    @Getter
    @JsonProperty("can_edit")
    Optional<YesParam> canEdit = Optional.empty();
=======
     *  название платформы (для видеозаписей, добавленных с внешних сайтов).
     */
    @Getter
    @JsonProperty("platform")
    String platform;

    /**
     *  поле возвращается, если пользователь может редактировать видеозапись, всегда содержит 1.
     */
    @Getter
    @JsonProperty("can_edit")
    Optional<YesParam> canEdit;
>>>>>>> modularity

    /**
     *  1, если пользователь может добавить видеозапись к себе.
     */
    @Getter
    @JsonProperty("can_add")
    BoolInt canAdd;

    /**
<<<<<<< HEAD
     *  Поле возвращается, если видеозапись приватная (например, была загружена в личное сообщение), всегда содержит 1.
     */
    @Getter
    @JsonProperty("is_private")
    Optional<YesParam> isPrivate = Optional.empty();

    /**
     *  Ключ доступа к объекту.
     */
    @Getter
    @JsonProperty("access_key")
    Optional<String> accessKey = Optional.empty();

    /**
     *  Поле возвращается в том случае, если видеоролик находится в процессе обработки, всегда содержит 1.
     */
    @Getter
    @JsonProperty("processing")
    Optional<YesParam> processing = Optional.empty();

    /**
     *  Поле возвращается в том случае, если видеозапись является прямой трансляцией, всегда содержит 1.
=======
     *  поле возвращается, если видеозапись приватная (например, была загружена в личное сообщение), всегда содержит 1.
     */
    @Getter
    @JsonProperty("is_private")
    Optional<YesParam> isPrivate;

    /**
     *  ключ доступа к объекту.
     */
    @Getter
    @JsonProperty("access_key")
    String accessKey;

    /**
     *  поле возвращается в том случае, если видеоролик находится в процессе обработки, всегда содержит 1.
     */
    @Getter
    @JsonProperty("processing")
    Optional<YesParam> processing;

    /**
     *  поле возвращается в том случае, если видеозапись является прямой трансляцией, всегда содержит 1.
>>>>>>> modularity
     *  Обратите внимание, в этом случае в поле duration содержится значение 0.
     */
    @Getter
    @JsonProperty("live")
<<<<<<< HEAD
    Optional<YesParam> live = Optional.empty();

    /**
     *  Поле свидетельствует о том, что трансляция скоро начнётся.
     *  (для live = 1)
     */
    @Getter
    @JsonProperty("upcoming")
    Optional<YesParam> upcoming = Optional.empty();

    /**
     *  True, если объект добавлен в закладки у текущего пользователя.
=======
    Optional<YesParam> live;

    /**
     *  (для live = 1). Поле свидетельствует о том, что трансляция скоро начнётся.
     */
    @Getter
    @JsonProperty("upcoming")
    Optional<YesParam> upcoming;

    /**
     *  true, если объект добавлен в закладки у текущего пользователя.
>>>>>>> modularity
     */
    @Getter
    @JsonProperty("is_favorite")
    boolean isFavorite;

}
