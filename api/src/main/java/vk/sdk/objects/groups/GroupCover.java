package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.utils.BoolInt;

import java.util.Collections;
import java.util.List;

/**
 *  Объект, описывающий обложку сообщества.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupCover {

    /**
     *  Информация о том, включена ли обложка (1 — да, 0 — нет).
     */
    @Getter
    @JsonProperty("enabled")
    BoolInt enabled;

    /**
     *  Копии изображений обложки.
     */
    @Getter
    @JsonProperty("images")
    List<GroupCoverImage> images = Collections.emptyList();

}
