package vk.sdk.objects.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Collections;
import java.util.List;

/**
 *  Объект, описывающий данные об охвате.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatsReach {

    /**
     *  Полный охват.
     */
    @Getter
    @JsonProperty("reach")
    Integer reach;

    /**
     *  Охват подписчиков.
     */
    @Getter
    @JsonProperty("reach_subscribers")
    Integer reachSubscribers;

    /**
     *  Охват с мобильных устройств.
     */
    @Getter
    @JsonProperty("mobile_reach")
    Integer mobileReach;

    /**
     *  Статистика по полу.
     */
    @Getter
    @JsonProperty("sex")
    List<StatsReachSex> sex = Collections.emptyList();

    /**
     *  Статистика по возрасту.
     */
    @Getter
    @JsonProperty("age")
    List<StatsReachAge> age = Collections.emptyList();

    /**
     *  Статистика по полу и возрасту.
     */
    @Getter
    @JsonProperty("age_sex")
    List<StatsReachSexAge> ageSex = Collections.emptyList();

    /**
     *  Статистика по городам.
     */
    @Getter
    @JsonProperty("cities")
    List<StatsReachCity> cities = Collections.emptyList();

    /**
     *  Статистика по странам.
     */
    @Getter
    @JsonProperty("countries")
    List<StatsReachCountry> countries = Collections.emptyList();

}
