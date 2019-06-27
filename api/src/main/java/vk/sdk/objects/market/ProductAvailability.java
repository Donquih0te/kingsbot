package vk.sdk.objects.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ProductAvailability implements EnumParam {

    /**
     *  Товар доступен.
     */
    @JsonProperty("0")
    PRODUCT_AVAILABLE(0),

    /**
     *  Товар удален.
     */
    @JsonProperty("1")
    PRODUCT_DELETED(1),

    /**
     *  Товар недоступен.
     */
    @JsonProperty("2")
    PRODUCT_NOT_AVAILABLE(2);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
