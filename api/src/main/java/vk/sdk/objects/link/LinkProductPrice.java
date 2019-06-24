package vk.sdk.objects.link;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, описывающий цену.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkProductPrice {

    /**
     *  Целочисленное значение цены, умноженное на 100.
     */
    @Getter
    @JsonProperty("amount")
    Integer amount;

    /**
     *  Информацию о валюте.
     */
    @Getter
    @JsonProperty("currency")
    LinkProductPriceCurrency currency;

    /**
     *  Строка с локализованной ценой и валютой.
     */
    @Getter
    @JsonProperty("text")
    String text;

}
