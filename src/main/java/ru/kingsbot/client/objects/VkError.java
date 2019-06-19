package ru.kingsbot.client.objects;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;


/*
    Json error example:
    {
        "error": {
            "error_code":5,
            "error_msg":"User authorization failed: invalid access_token (4).",
            "request_params":[{
                "key":"group_id",
                "value":"123281395"
            }, {
                "key":"v",
                "value":"5.95"
            }, {
                "key":"",
                "value":""
            }, {
                "key":"method",
                "value":"groups.getLongPollServer"
            }, {
                "key":"oauth",
                "value":"1"
            }]
        }
    }
 */
@ToString
@EqualsAndHashCode
public class VkError {

    @Getter
    @SerializedName("error_code")
    private Integer errorCode;

    @Getter
    @SerializedName("error_msg")
    private String errorMessage;

    @Getter
    @SerializedName("request_params")
    private List<Map<String, String>> requestParams;

}
