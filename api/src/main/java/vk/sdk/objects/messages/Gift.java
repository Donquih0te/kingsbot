package vk.sdk.objects.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;

/**
 *  Объект, описывающий подарок.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Gift {

    /**
     *  Идентификатор подарка.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  URL изображения 256x256px.
     */
    @Getter
    @JsonProperty("thumb_256")
    URL thumb256;

    /**
     *  URL изображения 96x96px.
     */
    @Getter
    @JsonProperty("thumb_96")
    URL thumb96;

    /**
     *  URL изображения 48x48px.
     */
    @Getter
    @JsonProperty("thumb_48")
    URL thumb48;

}
