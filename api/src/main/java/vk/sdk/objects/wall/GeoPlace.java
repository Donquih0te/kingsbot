package vk.sdk.objects.wall;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 *  Объект, описывающий местоположение.
 */
@ToString
@EqualsAndHashCode
public class GeoPlace {

    /**
     *  Идентификатор места.
     */
    @Getter
    @SerializedName("id")
    private Integer id;

    /**
     *  Название места.
     */
    @Getter
    @SerializedName("title")
    private String title;

    /**
     *  Географическая широта, заданная в градусах (от -90 до 90).
     */
    @Getter
    @SerializedName("latitude")
    private Integer latitude;

    /**
     *  Географическая долгота, заданная в градусах (от -90 до 90).
     */
    @Getter
    @SerializedName("longitude")
    private Integer longitude;

    /**
     *  Дата создания места в UnixTime.
     */
    @Getter
    @SerializedName("created")
    private Long created;

    /**
     *  Иконка места, URL изображения.
     */
    @Getter
    @SerializedName("icon")
    private String icon;

    /**
     *  Число отметок в этом месте.
     */
    @Getter
    @SerializedName("checkins")
    private Integer checkins;

    /**
     *  Дата обновления места в UnixTime.
     */
    @Getter
    @SerializedName("updated")
    private Long updated;

    /**
     *  Тип места.
     */
    @Getter
    @SerializedName("type")
    private Integer type;

    /**
     *  Идентификатор страны.
     */
    @Getter
    @SerializedName("country")
    private Integer country;

    /**
     *  Идентификатор города.
     */
    @Getter
    @SerializedName("city")
    private Integer city;

    /**
     *  Адрес места.
     */
    @Getter
    @SerializedName("address")
    private String address;

}
