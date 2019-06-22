package vk.sdk.objects.wall;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Информация о местоположении.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Geo {

    /**
     *  Тип места.
     */
    @Getter
    @SerializedName("type")
    String type;

    /**
     *  Координаты места.
     */
    @Getter
    @SerializedName("coordinates")
    String coordinates;

    /**
     *  Описание места (если оно добавлено).
     */
    @Getter
    @SerializedName("place")
    GeoPlace place;

}
