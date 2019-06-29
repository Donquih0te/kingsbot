package vk.sdk.objects.wall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum WallPostAttachmentType implements EnumParam {

    @JsonProperty("photo")
    PHOTO("photo"),

    @JsonProperty("posted_photo")
    POSTED_PHOTO("posted_photo"),

    @JsonProperty("video")
    VIDEO("video"),

    @JsonProperty("audio")
    AUDIO("audio"),

    @JsonProperty("doc")
    DOC("doc"),

    @JsonProperty("graffity")
    GRAFFITY("graffity"),

    @JsonProperty("link")
    LINK("link"),

    @JsonProperty("note")
    NOTE("note"),

    @JsonProperty("app")
    APP("app"),

    @JsonProperty("poll")
    POLL("poll"),

    @JsonProperty("page")
    PAGE("page"),

    @JsonProperty("album")
    ALBUM("album"),

    @JsonProperty("photos_list")
    PHOTOS_LIST("photos_list"),

    @JsonProperty("market")
    MARKET("market"),

    @JsonProperty("market_album")
    MARKET_ALBUM("market_album"),

    @JsonProperty("sticker")
    STICKER("sticker"),

    @JsonProperty("pretty_cards")
    PRETTY_CARDS("pretty_cards");

    private String value;

    @Override
    public String getValue() {
        return value;
    }

}
