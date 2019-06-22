package vk.sdk.objects.wall;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.utils.BoolInt;

/**
 *  Информация о комментариях к записи.
 */
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WallPostCommentsInfo {

    /**
     *  Количество комментариев.
     */
    @Getter
    @SerializedName("count")
    Integer count;

    /**
     *  Информация о том, может ли текущий пользователь комментировать запись
     *  (1 — может, 0 — не может)
     */
    @Getter
    @SerializedName("can_post")
    BoolInt canPost;

    /**
     *  Информация о том, могут ли сообщества комментировать запись.
     */
    @Getter
    @SerializedName("groups_can_post")
    BoolInt groupsCanPost;

    /**
     *  Может ли текущий пользователь закрыть комментарии к записи.
     */
    @Getter
    @SerializedName("can_close")
    boolean canClose;

    /**
     *  Может ли текущий пользователь открыть комментарии к записи.
     */
    @Getter
    @SerializedName("can_open")
    boolean canOpen;

}
