package vk.sdk.objects.wall.comments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Collections;
import java.util.List;

/**
 *  Информация о вложенной ветке комментариев.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WallPostCommentsThreadInfo {

    /**
     *  Количество комментариев в ветке.
     */
    @Getter
    @JsonProperty("count")
    Integer count;

    /**
     *  Массив объектов комментариев к записи.
     *  (только для метода wall.getComments).
     */
    @Getter
    @JsonProperty("items")
    List<WallPostComment> items = Collections.emptyList();

    /**
     *  Может ли текущий пользователь оставлять комментарии в этой ветке.
     */
    @Getter
    @JsonProperty("can_post")
    boolean canPost;

    /**
     *  Нужно ли отображать кнопку «ответить» в ветке.
     */
    @Getter
    @JsonProperty("show_reply_button")
    boolean showReplyButton;

    /**
     *  Могут ли сообщества оставлять комментарии в ветке.
     */
    @Getter
    @JsonProperty("groups_can_post")
    boolean groupsCanPost;

}
