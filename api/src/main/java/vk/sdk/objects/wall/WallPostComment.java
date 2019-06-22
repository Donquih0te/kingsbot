package vk.sdk.objects.wall;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 *  Объект, описывающий комментарий к записи.
 */
@ToString
@EqualsAndHashCode
public class WallPostComment {

    /**
     *  Идентификатор комментария.
     */
    @Getter
    @SerializedName("id")
    private Integer id;

    /**
     *  Идентификатор автора комментария.
     */
    @Getter
    @SerializedName("from_id")
    private Integer fromId;

    /**
     *  Дата создания комментария в формате UnixTime.
     */
    @Getter
    @SerializedName("date")
    private Long date;

    /**
     *  Текст комментария.
     */
    @Getter
    @SerializedName("text")
    private String text;

    /**
     *  Идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
     */
    @Getter
    @SerializedName("reply_to_user")
    private Integer replyToUser;

    /**
     *  Идентификатор комментария, в ответ на который оставлен текущий (если применимо).
     */
    @Getter
    @SerializedName("reply_to_comment")
    private Integer replyToComment;

    /**
     *  Медиавложения комментария (фотографии, ссылки и т.п.)
     *
     *  TODO: create WallCommentAttachment objects to any type of attachments
     */
    @Getter
    @SerializedName("attachments")
    private List<Object> attachments;

    /**
     *  Массив идентификаторов родительских комментариев.
     */
    @Getter
    @SerializedName("parents_stack")
    private List<Integer> parentsStack;

    /**
     *  Информация о вложенной ветке комментариев.
     */
    @Getter
    @SerializedName("thread")
    private WallPostCommentsThreadInfo thread;

}
