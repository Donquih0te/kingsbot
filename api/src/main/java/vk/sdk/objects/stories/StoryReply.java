package vk.sdk.objects.stories;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, описывающий информацию об ответах на историю.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StoryReply {

    /**
     *  Число ответов.
     */
    @Getter
    @JsonProperty("count")
    Integer count;

    /**
     *  Число новых ответов. Возвращается только для историй текущего пользователя.
     */
    @Getter
    @JsonProperty("new")
    Integer newCount;

}
