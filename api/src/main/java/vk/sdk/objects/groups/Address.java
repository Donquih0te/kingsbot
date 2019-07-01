package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

/**
 *  Объект, описывающий адрес в сообществе.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {

    /**
     *  Идентификатор адреса.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Идентификатор страны.
     */
    @Getter
    @JsonProperty("country_id")
    Integer countryId;

    /**
     *  Идентификатор города.
     */
    @Getter
    @JsonProperty("city_id")
    Integer cityId;

    /**
     *  Заголовок адреса.
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
     *  Строка адреса.
     */
    @Getter
    @JsonProperty("address")
    String address;

    /**
     *  Описание адреса.
     */
    @Getter
    @JsonProperty("additional_address")
    String additionalAddress;

    /**
     *  Географическая широта отметки, заданная в градусах (от -90 до 90).
     */
    @Getter
    @JsonProperty("latitude")
    Float latitude;

    /**
     *  Географическая долгота отметки, заданная в градусах (от -180 до 180).
     */
    @Getter
    @JsonProperty("longitude")
    Float longitude;

    /**
     *  Идентификатор станции метрополитена.
     */
    @Getter
    @JsonProperty("metro_station_id")
    Integer metroStationId;

    /**
     *  Тип расписания.
     *  Возможные значения:
     *      no_information — нет информации о расписании;
     *      temporarily_closed — временно закрыто;
     *      always_opened — открыто круглосуточно;
     *      forever_closed — закрыто навсегда;
     *      timetable — открыто в указанные часы работы.
     *      Для этого типа расписания необходимо передать параметр timetable;
     */
    @Getter
    @JsonProperty("work_info_status")
    AddressWorkInfoStatus workInfoStatus;

    /**
     *  Для типа расписания timetable можно передать расписание в формате json.
     */
    @Getter
    @JsonProperty("timetable")
    Optional<AddressTimetable> timetable = Optional.empty();

}
