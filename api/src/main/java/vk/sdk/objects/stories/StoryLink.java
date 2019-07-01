package vk.sdk.objects.stories;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;

/**
 *  Объект, описывающий ссылку для перехода из истории.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoryLink {

    /**
     *  Текст ссылки.
     */
    @Getter
    @JsonProperty("url")
    String text;

    /**
     *  URL для перехода.
     */
    @Getter
    @JsonProperty("url")
    URL url;

}
