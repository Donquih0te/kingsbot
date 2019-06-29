package vk.sdk.objects.audio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.utils.YesParam;

import java.net.URL;
import java.util.Optional;

/**
 *  Объект, описывающий аудиозапись.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Audio {

    /**
     *  Идентификатор аудиозаписи.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Идентификатор владельца аудиозаписи.
     */
    @Getter
    @JsonProperty("owner_id")
    Integer ownerId;

    /**
     *  Исполнитель.
     */
    @Getter
    @JsonProperty("artist")
    String artist;

    /**
     *  Название композиции.
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
     *  Длительность аудиозаписи в секундах.
     */
    @Getter
    @JsonProperty("duration")
    Integer duration;

    /**
     *  Ссылка на mp3.
     */
    @Getter
    @JsonProperty("url")
    URL url;

    /**
     *  Идентификатор текста аудиозаписи (если доступно).
     */
    @Getter
    @JsonProperty("lyrics_id")
<<<<<<< HEAD
    Optional<Integer> lyricsId = Optional.empty();
=======
    Optional<Integer> lyricsId;
>>>>>>> modularity

    /**
     *  Идентификатор альбома, в котором находится аудиозапись (если присвоен).
     */
    @Getter
    @JsonProperty("album_id")
<<<<<<< HEAD
    Optional<Integer> albumId = Optional.empty();
=======
    Optional<Integer> albumId;
>>>>>>> modularity

    /**
     *  Идентификатор жанра.
     */
    @Getter
    @JsonProperty("genre_id")
    AudioGenre genreId;

    /**
     *  Дата добавления.
     */
    @Getter
    @JsonProperty("date")
    Long date;

    /**
     *  Вернет 1, если включена опция «Не выводить при поиске».
     *  Если опция отключена, поле не возвращается.
     */
    @Getter
    @JsonProperty("no_search")
<<<<<<< HEAD
    Optional<YesParam> noSearch = Optional.empty();
=======
    Optional<YesParam> noSearch;
>>>>>>> modularity

    /**
     *  Вернет 1, если аудио в высоком качестве.
     */
    @Getter
    @JsonProperty("is_hq")
<<<<<<< HEAD
    Optional<YesParam> isHighQuality = Optional.empty();
=======
    Optional<YesParam> isHighQuality;
>>>>>>> modularity

}
