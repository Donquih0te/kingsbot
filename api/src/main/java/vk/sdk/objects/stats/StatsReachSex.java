package vk.sdk.objects.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.base.Sex;

/**
 *  Объект, описывающий статистику по полу.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatsReachSex {

    /**
     *  Пол ("m" — мужской, "f" — женский).
     */
    @Getter
    @JsonProperty("value")
    Sex value;

    /**
     *  Число посетителей.
     */
    @Getter
    @JsonProperty("count")
    Integer count;

}
