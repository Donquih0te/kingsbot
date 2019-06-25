package vk.sdk.objects.note;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;
import java.util.Optional;

/**
 *  Объект, описывающий заметку.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Note {

    /**
     *  Идентификатор заметки.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Идентификатор владельца заметки.
     */
    @Getter
    @JsonProperty("owner_id")
    Integer ownerId;

    /**
     *  Заголовок заметки.
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
     *  Текст заметки.
     */
    @Getter
    @JsonProperty("text")
    String text;

    /**
     *  Дата создания заметки в формате UnixTime.
     */
    @Getter
    @JsonProperty("date")
    Long date;

    /**
     *  Количество комментариев.
     */
    @Getter
    @JsonProperty("comments")
    Integer comments;

    /**
     *  Количество прочитанных комментариев
     *  (только при запросе информации о заметке текущего пользователя).
     */
    @Getter
    @JsonProperty("read_comments")
    Optional<Integer> readComments;

    /**
     *  URL страницы для отображения заметки.
     */
    @Getter
    @JsonProperty("view_url")
    URL viewUrl;

}
