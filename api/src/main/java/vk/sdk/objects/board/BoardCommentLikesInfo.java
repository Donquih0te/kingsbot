package vk.sdk.objects.board;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.utils.BoolInt;

/**
 *  Объект, описывающий информацию об отметках «Мне нравится» текущего комментария.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardCommentLikesInfo {

    /**
     *  Число пользователей, которым понравился комментарий.
     */
    @Getter
    @JsonProperty("count")
    Integer count;

    /**
     *  Наличие отметки «Мне нравится» от текущего пользователя.
     *  (1 — есть, 0 — нет)
     */
    @Getter
    @JsonProperty("user_likes")
    BoolInt userLikes;

    /**
     *  Информация о том, может ли текущий пользователь поставить отметку «Мне нравится».
     *  (1 — может, 0 — не может)
     */
    @Getter
    @JsonProperty("can_like")
    BoolInt canLike;

}
