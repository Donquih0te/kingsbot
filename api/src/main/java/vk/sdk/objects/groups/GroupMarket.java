package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.market.ProductPriceCurrency;
import vk.sdk.objects.utils.BoolInt;

import java.util.Optional;

/**
 *  Объект, описывающий информацию о магазине.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupMarket {

    /**
     *  Информация о том, включен ли блок товаров в сообществе.
     *  Возможные значения:
     *      1 — включен;
     *      0 — выключен.
     *
     *  Если enabled = 0, объект не содержит других полей.
     */
    @Getter
    @JsonProperty("enabled")
    BoolInt enabled;

    /**
     *  Минимальная цена товаров.
     */
    @Getter
    @JsonProperty("price_min")
    Optional<Integer> priceMin = Optional.empty();

    /**
     *  Максимальная цена товаров.
     */
    @Getter
    @JsonProperty("price_max")
    Optional<Integer> priceMax = Optional.empty();

    /**
     *  Идентификатор главной подборки товаров.
     */
    @Getter
    @JsonProperty("main_album_id")
    Optional<Integer> mainAlbumId = Optional.empty();

    /**
     *  Идентификатор контактного лица для связи с продавцом.
     *  Возвращается отрицательное значение, если для связи с продавцом используются сообщения сообщества.
     */
    @Getter
    @JsonProperty("contact_id")
    Optional<Integer> contactId = Optional.empty();

    /**
     *  Информация о валюте.
     */
    @Getter
    @JsonProperty("currency")
    Optional<ProductPriceCurrency> currency = Optional.empty();

    /**
     *  Ттроковое обозначение валюты.
     */
    @Getter
    @JsonProperty("currency_text")
    Optional<String> currencyText = Optional.empty();

}
