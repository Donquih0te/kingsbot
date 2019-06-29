package vk.sdk.objects.polls;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.photos.PhotoSize;

<<<<<<< HEAD
import java.util.Collections;
=======
>>>>>>> modularity
import java.util.List;
import java.util.Optional;

/**
 *  Объект, описывающий фон сниппета опроса.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PoolBackground {

    /**
     *  Идентификатор фона.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Тип фона.
     */
    @Getter
    @JsonProperty("type")
    PoolBackgroundType type;

    /**
     *  Угол градиента по оси X.
     *  (для type = gradient)
     */
    @Getter
    @JsonProperty("angel")
<<<<<<< HEAD
    Optional<Integer> angel = Optional.empty();
=======
    Optional<Integer> angel;
>>>>>>> modularity

    /**
     *  HEX-код замещающего цвета (без #).
     */
    @Getter
    @JsonProperty("color")
    String color;

    /**
     *  Ширина плитки паттерна.
     *  (для type = tile)
     */
    @Getter
    @JsonProperty("width")
<<<<<<< HEAD
    Optional<Integer> width = Optional.empty();
=======
    Optional<Integer> width;
>>>>>>> modularity

    /**
     *  Высота плитки паттерна.
     *  (для type = tile)
     */
    @Getter
    @JsonProperty("height")
<<<<<<< HEAD
    Optional<Integer> height = Optional.empty();
=======
    Optional<Integer> height;
>>>>>>> modularity

    /**
     *  Изображение плитки паттерна.
     *  (для type = tile)
     */
    @Getter
    @JsonProperty("images")
<<<<<<< HEAD
    List<PhotoSize> images = Collections.emptyList();
=======
    List<PhotoSize> images;
>>>>>>> modularity

    /**
     *  Точки градиента.
     *  (для type = gradient)
     */
    @Getter
    @JsonProperty("points")
<<<<<<< HEAD
    List<PoolBackgroundPoint> points = Collections.emptyList();
=======
    List<PoolBackgroundPoint> points;
>>>>>>> modularity

}
