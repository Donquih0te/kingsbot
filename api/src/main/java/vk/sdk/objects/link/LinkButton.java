package vk.sdk.objects.link;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, описывающий информацию о кнопке.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkButton {

    /**
     *  Название кнопки.
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
     *  Действие для кнопки.
     */
    @Getter
    @JsonProperty("action")
    LinkButtonAction action;

}
