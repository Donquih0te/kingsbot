package vk.sdk.objects.wall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.utils.BoolInt;

/**
 *  Информация о репостах записи («Рассказать друзьям»).
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WallPostRepostsInfo {

    /**
     *  Число пользователей, скопировавших запись.
     */
    @Getter
    @JsonProperty("count")
    Integer count;

    /**
     *  Наличие репоста от текущего пользователя
     *  (1 — есть, 0 — нет)
     */
    @Getter
    @JsonProperty("user_reposted")
    BoolInt userReposted;

}
