package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

/**
 *  Объект, описывающий время работы в конкретный день.
 *  Время передается в минутах начиная от 0 часов.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressTimetableDay {

    /**
     *  Время открытия.
     */
    @Getter
    @JsonProperty("open_time")
    Integer openTime;

    /**
     *  Время закрытия.
     */
    @Getter
    @JsonProperty("close_time")
    Integer closeTime;

    /**
     *  Время начала перерыва.
     */
    @Getter
    @JsonProperty("break_open_time")
    Optional<Integer> breakOpenTime = Optional.empty();

    /**
     *  Время завершения перерыва.
     */
    @Getter
    @JsonProperty("break_close_time")
    Optional<Integer> breakCloseTime = Optional.empty();

}
