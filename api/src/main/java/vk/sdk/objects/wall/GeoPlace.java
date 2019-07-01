package vk.sdk.objects.wall;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id")
    Integer id;

    /**
     *  Название места.
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
     *  Географическая широта, заданная в градусах (от -90 до 90).
     */
    @Getter
    @JsonProperty("latitude")
    Float latitude;

    /**
     *  Географическая долгота, заданная в градусах (от -180 до 180).
     */
    @Getter
    @JsonProperty("longitude")
    Float longitude;

    /**
     *  Дата создания места в UnixTime.
     */
    @Getter
    @JsonProperty("created")
    Long created;

    /**
     *  Иконка места, URL изображения.
     */
    @Getter
    @JsonProperty("icon")
    URL icon;

    /**
     *  Число отметок в этом месте.
     */
    @Getter
    @JsonProperty("checkins")
    Integer checkins;

    /**
     *  Дата обновления места в UnixTime.
     */
    @Getter
    @JsonProperty("updated")
    Long updated;

    /**
     *  Тип места.
     */
    @Getter
    @JsonProperty("type")
    Integer type;

    /**
     *  Идентификатор страны.
     */
    @Getter
    @JsonProperty("country")
    Integer country;

    /**
     *  Идентификатор города.
     */
    @Getter
    @JsonProperty("city")
    Integer city;

    /**
     *  Адрес места.
     */
    @Getter
    @JsonProperty("address")
    String address;

}
