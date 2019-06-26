package vk.sdk.objects.polls;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Информация о варианте ответа в опросе.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PoolAnswer {

    /**
     *  Идентификатор ответа.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Текст ответа.
     */
    @Getter
    @JsonProperty("text")
    String text;

    /**
     *  Число проголосовавших за этот ответ.
     */
    @Getter
    @JsonProperty("votes")
    Integer votes;

    /**
     *  Рейтинг ответа.
     */
    @Getter
    @JsonProperty("rate")
    Float rate;

}
