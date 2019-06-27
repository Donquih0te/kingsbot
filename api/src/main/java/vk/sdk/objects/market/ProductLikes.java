package vk.sdk.objects.market;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.utils.BoolInt;

/**
 *  Объект, описывающий информацию об отметках «Мне нравится».
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductLikes {

    /**
     *  Есть ли отметка «Мне нравится» от текущего пользователя
     *  (1 — есть, 0 — нет).
     */
    @Getter
    @JsonProperty("user_likes")
    BoolInt userLikes;

    /**
     *  Число отметок «Мне нравится».
     */
    @Getter
    @JsonProperty("count")
    Integer count;

}
