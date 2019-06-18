package ru.kingsbot.client.objects.longpool.responses;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@ToString
@EqualsAndHashCode
public class LongPoolUpdateObject {

    @Getter
    @SerializedName("date")
    private Long date;

    @Getter
    @SerializedName("from_id")
    private Integer fromId;

    @Getter
    @SerializedName("id")
    private Integer id;

    @Getter
    @SerializedName("out")
    private Integer out;

    @Getter
    @SerializedName("peer_id")
    private Integer peerId;

    @Getter
    @SerializedName("text")
    private String text;

    @Getter
    @SerializedName("conversation_message_id")
    private Integer conversationMessageId;

    @Getter
    @SerializedName("fwd_messages")
    private List<Object> fwdMessages;

    @Getter
    @SerializedName("important")
    private boolean important;

    @Getter
    @SerializedName("random_id")
    private Integer randomId;

    @Getter
    @SerializedName("attachments")
    private List<Object> attachments;

    @Getter
    @SerializedName("is_hidden")
    private boolean isHidden;

    @Getter
    @SerializedName("payload")
    private Map<String, String> payload;


}
