package vk.sdk.objects.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ProductButtonTitle implements EnumParam {

    @JsonProperty("Купить")
    BUY("Купить"),

    @JsonProperty("Перейти в магазин")
    GO_TO_MARKET("Перейти в магазин"),

    @JsonProperty("Купить билет")
    BUY_TICKET("Купить билет");

    private final String value;

    @Override
    public String getValue() {
        return value;
    }

}
