package vk.sdk.objects.wall.comments;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 *  Информация о вложенной ветке комментариев.
 */
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WallPostCommentsThreadInfo {

    /**
     *  Количество комментариев в ветке.
     */
    @Getter
    @SerializedName("count")
    Integer count;

    /**
     *  Массив объектов комментариев к записи.
     *  (только для метода wall.getComments).
     */
    @Getter
    @SerializedName("items")
    List<WallPostComment> items;

    /**
     *  Может ли текущий пользователь оставлять комментарии в этой ветке.
     */
    @Getter
    @SerializedName("can_post")
    boolean canPost;

    /**
     *  Нужно ли отображать кнопку «ответить» в ветке.
     */
    @Getter
    @SerializedName("show_reply_button")
    boolean showReplyButton;

    /**
     *  Могут ли сообщества оставлять комментарии в ветке.
     */
    @Getter
    @SerializedName("groups_can_post")
    boolean groupsCanPost;

}
