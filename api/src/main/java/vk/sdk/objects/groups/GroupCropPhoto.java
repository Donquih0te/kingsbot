package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.photos.Photo;

/**
 *  Объект, описывающий данные о точках, по которым вырезаны профильная и миниатюрная фотографии сообщества
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupCropPhoto {

    /**
     *  Объект фотографии пользователя, из которой вырезается главное фото сообщества.
     */
    @Getter
    @JsonProperty("photo")
    Photo photo;

    /**
     *  Вырезанная фотография сообщества.
     */
    @Getter
    @JsonProperty("crop")
    GroupCropPhotoRect crop;

    /**
     *  Миниатюрная квадратная фотография, вырезанная из фотографии crop.
     */
    @Getter
    @JsonProperty("rect")
    GroupCropPhotoRect rect;

}
