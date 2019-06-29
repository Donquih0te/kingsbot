package vk.sdk.objects.wall.comments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
<<<<<<< HEAD
import vk.sdk.objects.wall.WallPostAttachment;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
=======

import java.util.List;
>>>>>>> modularity

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
<<<<<<< HEAD
    Optional<Integer> replyToUser = Optional.empty();
=======
    Integer replyToUser;
>>>>>>> modularity

    /**
     *  Идентификатор комментария, в ответ на который оставлен текущий (если применимо).
     */
    @Getter
    @JsonProperty("reply_to_comment")
<<<<<<< HEAD
    Optional<Integer> replyToComment = Optional.empty();

    /**
     *  Медиавложения комментария (фотографии, ссылки и т.п.)
     */
    @Getter
    @JsonProperty("attachments")
    List<WallPostAttachment> attachments = Collections.emptyList();
=======
    Integer replyToComment;

    /**
     *  Медиавложения комментария (фотографии, ссылки и т.п.)
     *
     *  TODO: create WallCommentAttachment objects to any type of attachments
     */
    @Getter
    @JsonProperty("attachments")
    List<Object> attachments;
>>>>>>> modularity

    /**
     *  Массив идентификаторов родительских комментариев.
     */
    @Getter
    @JsonProperty("parents_stack")
<<<<<<< HEAD
    List<Integer> parentsStack = Collections.emptyList();
=======
    List<Integer> parentsStack;
>>>>>>> modularity

    /**
     *  Информация о вложенной ветке комментариев.
     */
    @Getter
    @JsonProperty("thread")
    WallPostCommentsThreadInfo thread;

}
