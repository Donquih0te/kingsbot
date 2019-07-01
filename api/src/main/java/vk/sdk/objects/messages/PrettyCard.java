package vk.sdk.objects.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.base.Image;
import vk.sdk.objects.link.LinkButton;

import java.net.URL;
import java.util.Collections;
import java.util.List;

/**
 *  TODO: что это?
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PrettyCard {

    /**
     *  Идентификатор карточки.
     */
    @Getter
    @JsonProperty("card_id")
    String cardId;

    /**
     *  URL карточки.
     */
    @Getter
    @JsonProperty("link_url")
    URL linkUrl;

    /**
     *  Подпись карточки.
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
     *  Изображения.
     */
    @Getter
    @JsonProperty("images")
    List<Image> images = Collections.emptyList();

    /**
     *  Кнопка.
     */
    @Getter
    @JsonProperty("button")
    LinkButton button;

    /**
     *  Цена.
     */
    @Getter
    @JsonProperty("price")
    String price;

    /**
     *  Старая цена.
     */
    @Getter
    @JsonProperty("price_old")
    String priceOld;

}
