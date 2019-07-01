package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

/**
 *  Объект, описывающий расписание работы по дням недели.
 *  Ключ по дню означает, что день рабочий.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressTimetable {

    /**
     *  Понедельник.
     */
    @Getter
    @JsonProperty("mon")
    Optional<AddressTimetableDay> mon = Optional.empty();

    /**
     *  Вторник.
     */
    @Getter
    @JsonProperty("tue")
    Optional<AddressTimetableDay> tue = Optional.empty();

    /**
     *  Среда.
     */
    @Getter
    @JsonProperty("wen")
    Optional<AddressTimetableDay> wen = Optional.empty();

    /**
     *  Четверг.
     */
    @Getter
    @JsonProperty("thu")
    Optional<AddressTimetableDay> thu = Optional.empty();

    /**
     *  Пятница.
     */
    @Getter
    @JsonProperty("fri")
    Optional<AddressTimetableDay> fri = Optional.empty();

    /**
     *  Суббота.
     */
    @Getter
    @JsonProperty("sat")
    Optional<AddressTimetableDay> sat = Optional.empty();

    /**
     *  Воскресенье.
     */
    @Getter
    @JsonProperty("san")
    Optional<AddressTimetableDay> san = Optional.empty();

}
