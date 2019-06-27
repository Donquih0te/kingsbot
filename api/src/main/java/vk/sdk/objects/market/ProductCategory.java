package vk.sdk.objects.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, описывающий категорию товара.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCategory {

    /**
     *  Идентификатор категории.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Название категории.
     */
    @Getter
    @JsonProperty("name")
    String name;

    /**
     *  Секция.
     */
    @Getter
    @JsonProperty("section")
    ProductCategorySection section;

}
