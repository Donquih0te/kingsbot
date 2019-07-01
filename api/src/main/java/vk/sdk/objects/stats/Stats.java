package vk.sdk.objects.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, описывающий данные статистики.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stats {

    /**
     *  Период начала отсчёта в формате YYYY-MM-DD.
     */
    @Getter
    @JsonProperty("period_from")
    String periodFrom;

    /**
     *  Период окончания отсчёта в формате YYYY-MM-DD.
     */
    @Getter
    @JsonProperty("period_to")
    String periodTo;

    /**
     *  Данные о посетителях и просмотрах.
     */
    @Getter
    @JsonProperty("visitors")
    StatsVisitors visitors;

    /**
     *  Данные об охвате.
     */
    @Getter
    @JsonProperty("reach")
    StatsReach reach;

}
