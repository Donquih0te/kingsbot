package ru.kingsbot.client.objects.longpool;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/*
    groups.getLongPoolServer response example:
    {
        "response":{
            "key":"3bc9d7e0e16298ec41469550c2b4bc6d4db0d202",
            "server":"https:\/\/lp.vk.com\/wh123281395",
            "ts":"12816757"
        }
    }

 */

@ToString
@EqualsAndHashCode
public class LongPoolServer {

    @Getter
    @SerializedName("key")
    private String key;

    @Getter
    @SerializedName("server")
    private String server;

    @Getter
    @Setter
    @SerializedName("ts")
    private String ts;

}
