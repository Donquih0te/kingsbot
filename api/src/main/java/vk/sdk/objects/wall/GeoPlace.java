package vk.sdk.objects.wall;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;

/**
 *  Объект, описывающий местоположение.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GeoPlace {

    /**
     *  Идентификатор места.
     */
    @Getter
    @SerializedName("id")
    Integer id;

    /**
     *  Название места.
     */
    @Getter
    @SerializedName("title")
    String title;

    /**
     *  Географическая широта, заданная в градусах (от -90 до 90).
     */
    @Getter
    @SerializedName("latitude")
    Integer latitude;

    /**
     *  Географическая долгота, заданная в градусах (от -90 до 90).
     */
    @Getter
    @SerializedName("longitude")
    Integer longitude;

    /**
     *  Дата создания места в UnixTime.
     */
    @Getter
    @SerializedName("created")
    Long created;

    /**
     *  Иконка места, URL изображения.
     */
    @Getter
    @SerializedName("icon")
    URL icon;

    /**
     *  Число отметок в этом месте.
     */
    @Getter
    @SerializedName("checkins")
    Integer checkins;

    /**
     *  Дата обновления места в UnixTime.
     */
    @Getter
    @SerializedName("updated")
    Long updated;

    /**
     *  Тип места.
     */
    @Getter
    @SerializedName("type")
    Integer type;

    /**
     *  Идентификатор страны.
     */
    @Getter
    @SerializedName("country")
    Integer country;

    /**
     *  Идентификатор города.
     */
    @Getter
    @SerializedName("city")
    Integer city;

    /**
     *  Адрес места.
     */
    @Getter
    @SerializedName("address")
    String address;

}
