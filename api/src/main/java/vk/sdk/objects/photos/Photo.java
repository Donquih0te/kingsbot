package vk.sdk.objects.photos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Collections;
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
     *  Идентификатор пользователя, загрузившего фото (если фотография размещена в сообществе).
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
     *  Массив с копиями изображения в разных размерах.
     */
    @Getter
    @JsonProperty("sizes")
    List<PhotoSize> sizes = Collections.emptyList();

    /**
     *  Ширина оригинала фотографии в пикселах.
     *  Значение может быть недоступно для фотографий, загруженных на сайт до 2012 года.
     */
    @Getter
    @JsonProperty("width")
    Optional<Integer> width = Optional.empty();

    /**
     *  Высота оригинала фотографии в пикселах.
     *  Значение может быть недоступно для фотографий, загруженных на сайт до 2012 года.
     */
    @Getter
    @JsonProperty("height")
    Optional<Integer> height = Optional.empty();

}
