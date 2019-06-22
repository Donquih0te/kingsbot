package vk.sdk.objects.wall;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import vk.sdk.objects.utils.BoolInt;

/**
 *  Информация о репостах записи («Рассказать друзьям»).
 */
@ToString
@EqualsAndHashCode
public class WallPostRepostsInfo {

    /**
     *  Число пользователей, скопировавших запись.
     */
    @Getter
    @SerializedName("count")
    private Integer count;

    /**
     *  Наличие репоста от текущего пользователя
     *  (1 — есть, 0 — нет)
     */
    @Getter
    @SerializedName("user_reposted")
    private BoolInt userReposted;

}
