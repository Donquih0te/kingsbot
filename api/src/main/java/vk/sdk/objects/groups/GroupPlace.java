package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, описывающий место, указанное в информации о сообществе.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupPlace {

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
     *  Географическая широта в градусах (от -90 до 90).
     */
    @Getter
    @JsonProperty("latitude")
    Float latitude;

    /**
     *  Географическая долгота в градусах (от -180 до 180).
     */
    @Getter
    @JsonProperty("longitude")
    Float longitude;

    /**
     *  Тип места.
     */
    @Getter
    @JsonProperty("type")
    String type;

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
     *  Адрес.
     */
    @Getter
    @JsonProperty("address")
    String address;

}
