package vk.sdk.objects.wall;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 *  Информация о местоположении.
 */
@ToString
@EqualsAndHashCode
public class Geo {

    /**
     *  Тип места.
     */
    @Getter
    @SerializedName("type")
    private String type;

    /**
     *  Координаты места.
     */
    @Getter
    @SerializedName("coordinates")
    private String coordinates;

    /**
     *  Описание места (если оно добавлено).
     */
    @Getter
    @SerializedName("place")
    private GeoPlace place;

}
