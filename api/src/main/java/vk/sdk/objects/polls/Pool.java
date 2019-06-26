package vk.sdk.objects.polls;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.photos.Photo;

import java.util.List;

/**
 *  Объект, описывающий опрос.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Pool {

    /**
     *  Идентификатор опроса для получения информации о нем через метод "polls.getById".
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Идентификатор владельца опроса.
     */
    @Getter
    @JsonProperty("owner_id")
    Integer ownerId;

    /**
     *  Дата создания в формате UnixTime.
     */
    @Getter
    @JsonProperty("created")
    Long created;

    /**
     *  Текст вопроса.
     */
    @Getter
    @JsonProperty("question")
    String question;

    /**
     *  Количество голосов.
     */
    @Getter
    @JsonProperty("votes")
    Integer votes;

    /**
     *  Массив объектов, которые содержат информацию о вариантах ответа.
     */
    @Getter
    @JsonProperty("answers")
    List<PoolAnswer> answers;

    /**
     *  Является ли опрос анонимным.
     */
    @Getter
    @JsonProperty("anonymous")
    boolean anonymous;

    /**
     *  Допускает ли опрос выбор нескольких вариантов ответа.
     */
    @Getter
    @JsonProperty("multiple")
    boolean multiple;

    /**
     *  Идентификаторы вариантов ответа, выбранных текущим пользователем.
     */
    @Getter
    @JsonProperty("answer_ids")
    List<Integer> answerIds;

    /**
     *  Дата завершения опроса в UnixTime.
     *  0, если опрос бессрочный.
     */
    @Getter
    @JsonProperty("end_date")
    Long endDate;

    /**
     *  Является ли опрос завершенным.
     */
    @Getter
    @JsonProperty("closed")
    boolean closed;

    /**
     *  Прикреплён ли опрос к обсуждению.
     */
    @Getter
    @JsonProperty("is_board")
    boolean isBoard;

    /**
     *  Можно ли отредактировать опрос.
     */
    @Getter
    @JsonProperty("can_edit")
    boolean canEdit;

    /**
     *  Можно ли проголосовать в опросе.
     */
    @Getter
    @JsonProperty("can_vote")
    boolean canVote;

    /**
     *  Можно ли пожаловаться на опрос.
     */
    @Getter
    @JsonProperty("can_report")
    boolean canReport;

    /**
     *  Можно ли поделиться опросом.
     */
    @Getter
    @JsonProperty("can_share")
    boolean canShare;

    /**
     *  Идентификатор автора опроса.
     */
    @Getter
    @JsonProperty("author_id")
    Integer authorId;

    /**
     *  Фотография — фон сниппета опроса.
     */
    @Getter
    @JsonProperty("photo")
    Photo photo;

    /**
     *  Фон сниппета опроса.
     */
    @Getter
    @JsonProperty("background")
    PoolBackground background;

    /**
     *  Идентификаторы 3 друзей, которые проголосовали в опросе.
     */
    @Getter
    @JsonProperty("friends")
    List<Integer> friends;

}
