package vk.sdk.objects.polls;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.photos.PhotoSize;

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
    Optional<Integer> angel;

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
    Optional<Integer> width;

    /**
     *  Высота плитки паттерна.
     *  (для type = tile)
     */
    @Getter
    @JsonProperty("height")
    Optional<Integer> height;

    /**
     *  Изображение плитки паттерна.
     *  (для type = tile)
     */
    @Getter
    @JsonProperty("images")
    List<PhotoSize> images;

    /**
     *  Точки градиента.
     *  (для type = gradient)
     */
    @Getter
    @JsonProperty("points")
    List<PoolBackgroundPoint> points;

}
