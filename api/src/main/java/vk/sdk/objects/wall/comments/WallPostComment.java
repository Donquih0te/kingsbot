package vk.sdk.objects.wall.comments;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 *  Объект, описывающий комментарий к записи.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WallPostComment {

    /**
     *  Идентификатор комментария.
     */
    @Getter
    @SerializedName("id")
    Integer id;

    /**
     *  Идентификатор автора комментария.
     */
    @Getter
    @SerializedName("from_id")
    Integer fromId;

    /**
     *  Дата создания комментария в формате UnixTime.
     */
    @Getter
    @SerializedName("date")
    Long date;

    /**
     *  Текст комментария.
     */
    @Getter
    @SerializedName("text")
    String text;

    /**
     *  Идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
     */
    @Getter
    @SerializedName("reply_to_user")
    Integer replyToUser;

    /**
     *  Идентификатор комментария, в ответ на который оставлен текущий (если применимо).
     */
    @Getter
    @SerializedName("reply_to_comment")
    Integer replyToComment;

    /**
     *  Медиавложения комментария (фотографии, ссылки и т.п.)
     *
     *  TODO: create WallCommentAttachment objects to any type of attachments
     */
    @Getter
    @SerializedName("attachments")
    List<Object> attachments;

    /**
     *  Массив идентификаторов родительских комментариев.
     */
    @Getter
    @SerializedName("parents_stack")
    List<Integer> parentsStack;

    /**
     *  Информация о вложенной ветке комментариев.
     */
    @Getter
    @SerializedName("thread")
    WallPostCommentsThreadInfo thread;

}
