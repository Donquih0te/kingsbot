package ru.kingsbot.client.objects.longpool.responses;


import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/*

    {
        "ts":"22",
        "updates":[{
            "type":"message_new",
            "group_id":174156055,
            "object":{
                "date":1543569026,
                "from_id":145565650,
                "id":21,
                "out":0,
                "peer_id":145565650,
                "text":"f",
                "conversation_message_id":21,
                "fwd_messages":[],
                "important":false,
                "random_id":0,
                "attachments":[],
                "is_hidden":false
            }
        }]
    }


*/

@ToString
@EqualsAndHashCode
public class LongPoolResponse {

    @Getter
    @SerializedName("ts")
    private String ts;

    @Getter
    @SerializedName("updates")
    private List<LongPoolUpdate> updates;

}
