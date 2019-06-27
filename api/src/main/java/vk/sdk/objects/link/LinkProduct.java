package vk.sdk.objects.link;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.market.ProductPrice;

/**
 *  Объект, описывающий информацию о продукте.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkProduct {

    /**
     *  Описание товара.
     */
    @Getter
    @JsonProperty("price")
    ProductPrice price;

}
