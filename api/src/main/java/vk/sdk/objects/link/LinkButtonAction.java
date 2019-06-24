package vk.sdk.objects.link;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;

/**
 *  Действие для кнопки.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkButtonAction {

    /**
     *  Тип действия.
     */
    @Getter
    @JsonProperty("type")
    LinkButtonActionType type;

    /**
     *  URL для перехода.
     */
    @Getter
    @JsonProperty("url")
    URL url;

}
