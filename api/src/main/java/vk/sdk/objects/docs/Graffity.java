package vk.sdk.objects.docs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;

/**
 *  Это устаревший тип вложения. Он может быть возвращен лишь для записей, созданных раньше 2013 года.
 *  Для более новых записей граффити возвращается в виде вложения с типом photo.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Graffity {

    /**
     *  Идентификатор граффити.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Идентификатор автора граффити.
     */
    @Getter
    @JsonProperty("owner_id")
    Integer ownerId;

    /**
     *  URL изображения для предпросмотра.
     */
    @Getter
    @JsonProperty("photo_130")
    URL photo130;

    /**
     *  URL полноразмерного изображения.
     */
    @Getter
    @JsonProperty("photo_604")
    URL photo604;

}
