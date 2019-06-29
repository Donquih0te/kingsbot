package vk.sdk.objects.wall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

<<<<<<< HEAD
import java.util.Optional;

=======
>>>>>>> modularity
/**
 *  Информация о местоположении.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Geo {

    /**
     *  Тип места.
     */
    @Getter
    @JsonProperty("type")
    String type;

    /**
     *  Координаты места.
     */
    @Getter
    @JsonProperty("coordinates")
    String coordinates;

    /**
     *  Описание места (если оно добавлено).
     */
    @Getter
    @JsonProperty("place")
<<<<<<< HEAD
    Optional<GeoPlace> place = Optional.empty();
=======
    GeoPlace place;
>>>>>>> modularity

}
