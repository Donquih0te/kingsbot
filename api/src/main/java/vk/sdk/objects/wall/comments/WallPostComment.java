package vk.sdk.objects.wall.comments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.base.Attachment;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *  Объект, описывающий комментарий к записи.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WallPostComment {

    /**
     *  Идентификатор комментария.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Идентификатор автора комментария.
     */
    @Getter
    @JsonProperty("from_id")
    Integer fromId;

    /**
     *  Идентификатор записи, к которой оставлен комментарий.
     */
    @Getter
    @JsonProperty("post_id")
    Optional<Integer> postId = Optional.empty();

    /**
     *  Идентификатор владельца стены, на которой оставлен комментарий.
     */
    @Getter
    @JsonProperty("owner_id")
    Optional<Integer> ownerId = Optional.empty();

    /**
     *  Дата создания комментария в формате UnixTime.
     */
    @Getter
    @JsonProperty("date")
    Long date;

    /**
     *  Текст комментария.
     */
    @Getter
    @JsonProperty("text")
    String text;

    /**
     *  Идентификатор пользователя или сообщества, в ответ которому оставлен текущий комментарий (если применимо).
     */
    @Getter
    @JsonProperty("reply_to_user")
    Optional<Integer> replyToUser = Optional.empty();

    /**
     *  Идентификатор комментария, в ответ на который оставлен текущий (если применимо).
     */
    @Getter
    @JsonProperty("reply_to_comment")
    Optional<Integer> replyToComment = Optional.empty();

    /**
     *  Медиавложения комментария (фотографии, ссылки и т.п.)
     */
    @Getter
    @JsonProperty("attachments")
    List<Attachment> attachments = Collections.emptyList();

    /**
     *  Массив идентификаторов родительских комментариев.
     */
    @Getter
    @JsonProperty("parents_stack")
    List<Integer> parentsStack = Collections.emptyList();

    /**
     *  Информация о вложенной ветке комментариев.
     */
    @Getter
    @JsonProperty("thread")
    WallPostCommentsThreadInfo thread;

}
