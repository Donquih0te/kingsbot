package vk.sdk.objects.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, описывающий статистику по странам.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatsReachCountry {

    /**
     *  Название страны.
     */
    @Getter
    @JsonProperty("name")
    String name;

    /**
     *  Двухбуквенный код страны (например, "RU").
     */
    @Getter
    @JsonProperty("code")
    String code;

    /**
     *  Идентификатор страны.
     */
    @Getter
    @JsonProperty("country_id")
    Integer countryId;

    /**
     *  Число посетителей.
     */
    @Getter
    @JsonProperty("count")
    Integer count;

}
