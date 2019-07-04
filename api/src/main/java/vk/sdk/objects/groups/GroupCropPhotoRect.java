package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, описывающий миниатюрную фотографию сообщества.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupCropPhotoRect {

    /**
     *  Координата X левого верхнего угла в процентах.
     */
    @Getter
    @JsonProperty("x")
    Float x;

    /**
     *  Координата Y левого верхнего угла в процентах.
     */
    @Getter
    @JsonProperty("y")
    Float y;

    /**
     *  Координата X правого нижнего угла в процентах.
     */
    @Getter
    @JsonProperty("x2")
    Float x2;

    /**
     *  Координата Y правого нижнего угла в процентах.
     */
    @Getter
    @JsonProperty("y2")
    Float y2;

}
