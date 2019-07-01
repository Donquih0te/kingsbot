package vk.sdk.objects.stats;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, описывающий данные о посетителях и просмотрах.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StatsVisitors {

    /**
     *  Число просмотров.
     */
    @Getter
    @JsonProperty("views")
    Integer views;

    /**
     *  Число посетителей.
     */
    @Getter
    @JsonProperty("visitors")
    Integer visitors;

}
