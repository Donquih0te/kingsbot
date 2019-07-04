package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 *  Объект, содержащий информацию о занесении пользователя в черный список сообщества.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupBanInfo {

    /**
     *  Срок окончания блокировки в формате UnixTime.
     */
    @Getter
    @JsonProperty("end_date")
    Long endDate;

    /**
     *  Комментарий к блокировке.
     */
    @Getter
    @JsonProperty("comment")
    String comment;

}
