package vk.sdk.objects.wall;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 *  Информация о просмотрах записи.
 */
@ToString
@EqualsAndHashCode
public class WallPostViews {

    /**
     *  Число просмотров записи.
     */
    @Getter
    @SerializedName("count")
    private Integer count;

}
