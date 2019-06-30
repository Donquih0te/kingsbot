package vk.sdk.objects.apps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;

/**
 *  Это устаревший тип вложений. Он может быть возвращен лишь для записей, созданных раньше 2013 года.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppOld {

    /**
     *  Идентификатор приложения.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Название приложения.
     */
    @Getter
    @JsonProperty("name")
    String name;

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
