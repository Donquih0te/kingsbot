package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, описывающий город, указанный в информации о сообществе.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupCityCountry {

    /**
     *  Идентификатор города/страны.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Название города/страны.
     */
    @Getter
    @JsonProperty("title")
    String title;

}
