package vk.sdk.objects.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Collections;
import java.util.Map;

/**
 *  Объект, описывающий статистику по городам.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatsReachCity {

    /**
     *  Название города.
     */
    @Getter
    @JsonProperty("name")
    String name;

    /**
     *  Идентификатор города или "other" для раздела «прочие города».
     */
    @Getter
    @JsonProperty("city_id")
    Map<Integer, String> cityId = Collections.emptyMap();

    /**
     *  Число посетителей.
     */
    @Getter
    @JsonProperty("count")
    Integer count;

}
