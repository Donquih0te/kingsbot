package vk.sdk.objects.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, описывающий статистику по полу и возрасту.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatsReachSexAge {

    /**
     *  Пол и возрастной интервал (например, "f;12-18").
     */
    @Getter
    @JsonProperty("value")
    String value;

    /**
     *  Число посетителей.
     */
    @Getter
    @JsonProperty("count")
    Integer count;

}
