package vk.sdk.objects.polls;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, описывающий фон сниппета опроса.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PoolBackgroundPoint {

    /**
     *   Положение точки.
     */
    @Getter
    @JsonProperty("position")
    Float position;

    /**
     *  HEX-код цвета точки (без #).
     */
    @Getter
    @JsonProperty("color")
    String color;

}
