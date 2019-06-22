package vk.sdk.objects.wall.comments;

import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

@AllArgsConstructor
public enum WallPostCommentAttachmentType implements EnumParam {

    PHOTO("photo"),
    POSTED_PHOTO("posted_photo"),
    VIDEO("video"),
    AUDIO("audio"),
    DOC("doc"),
    GRAFFITY("graffity"),
    LINK("link"),
    NOTE("note"),
    APP("app"),
    POLL("poll"),
    PAGE("page"),
    ALBUM("album"),
    PHOTOS_LIST("photos_list"),
    MARKET("market"),
    MARKET_ALBUM("market_album"),
    STICKER("sticker"),
    PRETTY_CARDS("pretty_cards");

    private String value;

    @Override
    public String getValue() {
        return value;
    }

}
