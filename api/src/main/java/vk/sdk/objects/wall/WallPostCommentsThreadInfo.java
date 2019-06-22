package vk.sdk.objects.wall;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 *  Информация о вложенной ветке комментариев.
 */
@ToString
@EqualsAndHashCode
public class WallPostCommentsThreadInfo {

    /**
     *  Количество комментариев в ветке.
     */
    @Getter
    @SerializedName("count")
    private Integer count;

    /**
     *  Массив объектов комментариев к записи.
     *  (только для метода wall.getComments).
     */
    @Getter
    @SerializedName("items")
    private List<WallPostComment> items;

    /**
     *  Может ли текущий пользователь оставлять комментарии в этой ветке.
     */
    @Getter
    @SerializedName("can_post")
    private boolean canPost;

    /**
     *  Нужно ли отображать кнопку «ответить» в ветке.
     */
    @Getter
    @SerializedName("show_reply_button")
    private boolean showReplyButton;

    /**
     *  Могут ли сообщества оставлять комментарии в ветке.
     */
    @Getter
    @SerializedName("groups_can_post")
    private boolean groupsCanPost;

}
