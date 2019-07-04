package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum GroupMemberStatus implements EnumParam {

    @JsonProperty("0")
    NOT_MEMBER(0),

    @JsonProperty("1")
    MEMBER(1),

    @JsonProperty("2")
    NOT_SURE_ATTEND_EVENT(2),

    @JsonProperty("3")
    DECLINED_INVITE(3),

    @JsonProperty("4")
    JOIN_REQUEST_SENT(4),

    @JsonProperty("5")
    INVITED(5);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
