package ru.kingsbot.client.objects.longpool.responses;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class LongPoolUpdate {

    @Getter
    @SerializedName("type")
    private String type;

    @Getter
    @SerializedName("group_id")
    private Integer groupId;

    @Getter
    @SerializedName("object")
    private LongPoolUpdateObject object;

}
