package vk.sdk.objects.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCategorySection {

    /**
     *  Идентификатор секции.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Название секции.
     */
    @Getter
    @JsonProperty("name")
    String name;

}
