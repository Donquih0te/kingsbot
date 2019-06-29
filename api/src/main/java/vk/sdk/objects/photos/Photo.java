package vk.sdk.objects.photos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

<<<<<<< HEAD
import java.util.Collections;
=======
>>>>>>> modularity
import java.util.List;
import java.util.Optional;

/**
 *  Объект, описывающий фотографию.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Photo {

    /**
     *  Идентификатор фотографии.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Идентификатор альбома, в котором находится фотография.
     */
    @Getter
    @JsonProperty("album_id")
    Integer albumId;

    /**
     *  Идентификатор владельца фотографии.
     */
    @Getter
    @JsonProperty("owner_id")
    Integer ownerId;

    /**
<<<<<<< HEAD
     *  Идентификатор пользователя, загрузившего фото (если фотография размещена в сообществе).
=======
     *  Идентификатор пользователя, загрузившего фото(если фотография размещена в сообществе).
>>>>>>> modularity
     *  Для фотографий, размещенных от имени сообщества, user_id = 100.
     */
    @Getter
    @JsonProperty("user_id")
    Integer userId;

    /**
     *  Текст описания фотографии.
     */
    @Getter
    @JsonProperty("text")
    String text;

    /**
     *  Дата добавления в формате UnixTime.
     */
    @Getter
    @JsonProperty("date")
    Long date;

    /**
<<<<<<< HEAD
     *  Для фотографий, которые были загружены не в запрашиваемую запись, дополнительно возвращается поле post_id,
     *  содержащее идентификатор записи, в которую была загружена фотография.
     */
    @Getter
    @JsonProperty("post_id")
    Optional<Integer> postId = Optional.empty();

    /**
     *  Ключ доступа к контенту.
     */
    @Getter
    @JsonProperty("access_key")
    Optional<String> accessKey = Optional.empty();

    /**
=======
>>>>>>> modularity
     *  Массив с копиями изображения в разных размерах.
     */
    @Getter
    @JsonProperty("sizes")
<<<<<<< HEAD
    List<PhotoSize> sizes = Collections.emptyList();
=======
    List<PhotoSize> sizes;
>>>>>>> modularity

    /**
     *  Ширина оригинала фотографии в пикселах.
     *  Значение может быть недоступно для фотографий, загруженных на сайт до 2012 года.
     */
    @Getter
    @JsonProperty("width")
<<<<<<< HEAD
    Optional<Integer> width = Optional.empty();
=======
    Optional<Integer> width;
>>>>>>> modularity

    /**
     *  Высота оригинала фотографии в пикселах.
     *  Значение может быть недоступно для фотографий, загруженных на сайт до 2012 года.
     */
    @Getter
    @JsonProperty("height")
<<<<<<< HEAD
    Optional<Integer> height = Optional.empty();
=======
    Optional<Integer> height;
>>>>>>> modularity

}
