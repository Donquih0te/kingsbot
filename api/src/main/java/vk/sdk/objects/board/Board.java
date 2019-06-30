package vk.sdk.objects.board;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.utils.BoolInt;

import java.util.Optional;

/**
 *  Объект, описывающий обсуждение в сообществе.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Board {

    /**
     *  Идентификатор обсуждения.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Название обсуждения.
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
     *  Дата создания обсуждения в UnixTime.
     */
    @Getter
    @JsonProperty("created")
    Long created;

    /**
     *  Идентификатор создателя обсуждения.
     */
    @Getter
    @JsonProperty("created_by")
    Integer createdBy;

    /**
     *  Дата последнего обновления обсуждения в UnixTime.
     */
    @Getter
    @JsonProperty("updated")
    Long updated;

    /**
     *  Идентификатор автора последнего комментария в обсуждении.
     */
    @Getter
    @JsonProperty("is_closed")
    BoolInt isClosed;

    /**
     *  Информация о том, закрыто ли обсуждение.
     *  Возможные значения:
     *      0 — не закрыто;
     *      1 — закрыто.
     */
    @Getter
    @JsonProperty("is_fixed")
    BoolInt isFixed;

    /**
     *  Информация о том, закреплено ли обсуждение наверху списка.
     *  Возможные значения:
     *      0 — не закреплено;
     *      1 — закреплено.
     */
    @Getter
    @JsonProperty("comments")
    Integer comments;

    /**
     *  Текст первого комментария в обсуждении.
     *  (для preview = 1)
     */
    @Getter
    @JsonProperty("first_comment")
    Optional<String> firstComment = Optional.empty();

    /**
     *  Текст последнего комментария в обсуждении.
     *  (для preview = 2)
     */
    @Getter
    @JsonProperty("last_comment")
    Optional<String> lastComment = Optional.empty();

}
