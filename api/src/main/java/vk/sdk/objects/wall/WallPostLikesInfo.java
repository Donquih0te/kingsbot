package vk.sdk.objects.wall;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import vk.sdk.objects.utils.BoolInt;

/**
 *  Информация о лайках к записи.
 */
@ToString
@EqualsAndHashCode
public class WallPostLikesInfo {

    /**
     *  Число пользователей, которым понравилась запись.
     */
    @Getter
    @SerializedName("count")
    private Integer count;

    /**
     *  Наличие отметки «Мне нравится» от текущего пользователя
     *  (1 — есть, 0 — нет)
     */
    @Getter
    @SerializedName("user_likes")
    private BoolInt userLikes;

    /**
     *  Информация о том, может ли текущий пользователь поставить отметку «Мне нравится»
     *  (1 — может, 0 — не может)
     */
    @Getter
    @SerializedName("can_like")
    private BoolInt canLike;

    /**
     *  Информация о том, может ли текущий пользователь сделать репост записи
     *  (1 — может, 0 — не может)
     */
    @Getter
    @SerializedName("can_publish")
    private BoolInt canPublish;

}
