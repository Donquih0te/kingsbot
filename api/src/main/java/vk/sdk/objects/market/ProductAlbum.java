package vk.sdk.objects.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.photos.Photo;

/**
 *  Объект, описывающий подборку товаров.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductAlbum {

    /**
     *  Идентификатор подборки.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Идентификатор владельца подборки.
     */
    @Getter
    @JsonProperty("owner_id")
    Integer ownerId;

    /**
     *  Название подборки.
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
     *  Обложка подборки.
     */
    @Getter
    @JsonProperty("photo")
    Photo photo;

    /**
     *  Число товаров в подборке.
     */
    @Getter
    @JsonProperty("count")
    Integer count;

    /**
     *  Дата обновления подборки в формате UnixTime.
     */
    @Getter
    @JsonProperty("updated_time")
    Long updatedTime;

}
