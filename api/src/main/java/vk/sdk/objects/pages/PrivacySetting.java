package vk.sdk.objects.pages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PrivacySetting implements EnumParam {

    /**
     *  Только руководители сообщества.
     */
    @JsonProperty("0")
    COMMUNITY_MANAGERS_ONLY(0),

    /**
     *  Только участники сообщества.
     */
    @JsonProperty("1")
    COMMUNITY_MEMBERS_ONLY(1),

    /**
     *  Просматривать страницу могут все.
     */
    @JsonProperty("2")
    EVERYONE(2);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
