package vk.sdk.objects.board;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.base.Attachment;

import java.util.List;
import java.util.Optional;

/**
 *  Объект, описывающий комментарий из обсуждения в сообществе.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BoardComment {

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
     *  Дата создания (в формате UnixTime).
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
     *  Медиавложения комментария (фотографии, ссылки и т.п.).
     */
    @Getter
    @JsonProperty("attachments")
    List<Attachment> attachments;

    /**
     *  Информация об отметках «Мне нравится» текущего комментария.
     *  (если был задан параметр need_likes)
     */
    @Getter
    @JsonProperty("likes")
    Optional<BoardCommentLikesInfo> likes;

}
