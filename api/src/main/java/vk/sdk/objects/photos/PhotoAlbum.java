package vk.sdk.objects.photos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, описывающий альбом с фотографиями.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhotoAlbum {

    /**
     *  Идентификатор альбома.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Обложка альбома.
     */
    @Getter
    @JsonProperty("thumb")
    Photo thumb;

    /**
     *  Идентификатор владельца альбома.
     */
    @Getter
    @JsonProperty("owner_id")
    Integer ownerId;

    /**
     *  Название альбома.
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
     *  Описание альбома.
     */
    @Getter
    @JsonProperty("description")
    String description;

    /**
     *  Дата создания альбома в формате UnixTime.
     */
    @Getter
    @JsonProperty("created")
    Long created;

    /**
     *  Дата последнего обновления альбома в формате UnixTime.
     */
    @Getter
    @JsonProperty("updated")
    Long updated;

    /**
     *  Количество фотографий в альбоме.
     */
    @Getter
    @JsonProperty("size")
    Integer size;

}
