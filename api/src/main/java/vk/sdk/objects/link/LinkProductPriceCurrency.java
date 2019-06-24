package vk.sdk.objects.link;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, описывающий информацию о валюте.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkProductPriceCurrency {

    /**
     *  Идентификатор валюты.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Буквенное обозначение валюты.
     */
    @Getter
    @JsonProperty("name")
    String name;

}
