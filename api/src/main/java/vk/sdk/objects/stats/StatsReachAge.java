package vk.sdk.objects.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.base.Age;

/**
 *  Объект, описывающий статистику по возрасту.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatsReachAge {

    /**
     *  Возрастной интервал (например, "12-18").
     *  Возможные значения: "12-18", "18-21", "21-24", "24-27", "27-30", "30-35", "35-45", "45-100".
     */
    @Getter
    @JsonProperty("value")
    Age value;

    /**
     *  Число посетителей.
     */
    @Getter
    @JsonProperty("count")
    Integer count;

}
