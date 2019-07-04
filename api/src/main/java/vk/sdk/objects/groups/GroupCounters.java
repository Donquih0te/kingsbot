package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

/**
 *  Объект, описывающий счетчики сообщества.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupCounters {

    /**
     *  Колличество изображений.
     */
    @Getter
    @JsonProperty("photos")
    Optional<Integer> photos = Optional.empty();

    /**
     *  Колличество альбомов.
     */
    @Getter
    @JsonProperty("albums")
    Optional<Integer> albums = Optional.empty();

    /**
     *  Колличество аудиозаписей.
     */
    @Getter
    @JsonProperty("audios")
    Optional<Integer> audios = Optional.empty();

    /**
     *  Колличество видеозаписей.
     */
    @Getter
    @JsonProperty("videos")
    Optional<Integer> videos = Optional.empty();

    /**
     *  Колличество обсуждений.
     */
    @Getter
    @JsonProperty("topics")
    Optional<Integer> topics = Optional.empty();

    /**
     *  Колличество документов.
     */
    @Getter
    @JsonProperty("docs")
    Optional<Integer> docs = Optional.empty();

}
