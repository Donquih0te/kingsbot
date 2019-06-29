package vk.sdk.objects.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *  Объект, описывающий стикер.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sticker {

    /**
     *  Идентификатор набора (поле не возвращается в методе "store.getCatalog").
     */
    @Getter
    @JsonProperty("product_id")
    Optional<Integer> productId = Optional.empty();

    /**
     *  Идентификатор стикера.
     */
    @Getter
    @JsonProperty("sticker_id")
    Integer stickerId;

    /**
     *  Изображения для стикера (с прозрачным фоном).
     */
    @Getter
    @JsonProperty("images")
    List<StickerImage> images = Collections.emptyList();

    /**
     *  Изображения для стикера (с непрозрачным фоном).
     */
    @Getter
    @JsonProperty("images_with_background")
    List<StickerImage> imagesWithBackground = Collections.emptyList();

}
