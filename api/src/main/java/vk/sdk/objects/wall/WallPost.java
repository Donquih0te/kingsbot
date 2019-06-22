package vk.sdk.objects.wall;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.utils.BoolInt;
import vk.sdk.objects.utils.YesParam;
import vk.sdk.objects.wall.comments.WallPostCommentsInfo;
import vk.sdk.objects.wall.postsource.WallPostSource;

import java.util.List;

/**
 *  Объект, описывающий запись на стене пользователя или сообщества.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WallPost {

    /**
     *  Идентификатор записи.
     */
    @Getter
    @SerializedName("id")
    Integer id;

    /**
     *  Идентификатор владельца стены, на которой размещена запись.
     */
    @Getter
    @SerializedName("owner_id")
    Integer ownerId;

    /**
     *  Идентификатор автора записи (от чьего имени опубликована запись).
     */
    @Getter
    @SerializedName("from_id")
    Integer fromId;

    /**
     *  Идентификатор администратора, который опубликовал запись
     *  (возвращается только для сообществ при запросе с ключом доступа администратора).
     */
    @Getter
    @SerializedName("created_by")
    Integer createdBy;

    /**
     *  Время публикации записи в формате UnixTime.
     */
    @Getter
    @SerializedName("date")
    Long date;

    /**
     *  Текст записи.
     */
    @Getter
    @SerializedName("text")
    String text;

    /**
     *  Идентификатор владельца записи, в ответ на которую была оставлена текущая.
     */
    @Getter
    @SerializedName("reply_owner_id")
    Integer replyOwnerId;

    /**
     *  Идентификатор записи, в ответ на которую была оставлена текущая.
     */
    @Getter
    @SerializedName("reply_post_id")
    Integer replyPostId;

    /**
     *  1, если запись была создана с опцией «Только для друзей».
     */
    @Getter
    @SerializedName("friends_only")
    YesParam friendsOnly;

    /**
     *  Информация о комментариях к записи.
     */
    @Getter
    @SerializedName("comments")
    WallPostCommentsInfo comments;

    /**
     *  Информация о лайках к записи.
     */
    @Getter
    @SerializedName("likes")
    WallPostLikesInfo likes;

    /**
     *  Информация о репостах записи («Рассказать друзьям»).
     */
    @Getter
    @SerializedName("reposts")
    WallPostRepostsInfo reposts;

    /**
     *  Информация о просмотрах записи.
     */
    @Getter
    @SerializedName("views")
    WallPostViewsInfo views;

    /**
     *  Тип записи.
     *  Может принимать следующие значения:
     *  post, copy, reply, postpone, suggest.
     */
    @Getter
    @SerializedName("post_type")
    PostType postType;

    /**
     *  Информация о способе размещения записи.
     *  Поле возвращается только для Standalone-приложений с ключом доступа, полученным в Implicit Flow.
     */
    @Getter
    @SerializedName("post_source")
    WallPostSource postSource;

    /**
     *  Медиавложения записи (фотографии, ссылки и т.п.)
     *
     *  TODO: create object Attachment
     */
    @Getter
    @SerializedName("attachments")
    Object attachments;

    /**
     *  Информация о местоположении.
     */
    @Getter
    @SerializedName("geo")
    Geo geo;

    /**
     *  Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
     */
    @Getter
    @SerializedName("signer_id")
    Integer signerId;

    /**
     *  Массив, содержащий историю репостов для записи.
     *  Возвращается только в том случае, если запись является репостом.
     *  Каждый из объектов массива, в свою очередь, является объектом-записью стандартного формата.
     */
    @Getter
    @SerializedName("copy_history")
    List<Object> copyHistory;

    /**
     *  Информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может).
     */
    @Getter
    @SerializedName("can_pin")
    BoolInt canPin;

    /**
     *  Информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может).
     */
    @Getter
    @SerializedName("can_delete")
    BoolInt canDelete;

    /**
     *  Информация о том, может ли текущий пользователь редактировать запись (1 — может, 0 — не может).
     */
    @Getter
    @SerializedName("can_edit")
    BoolInt canEdit;

    /**
     *  Информация о том, что запись закреплена.
     *  Если не закреплена, то параметр отсутствует.
     */
    @Getter
    @SerializedName("is_pinned")
    YesParam isPinned;

    /**
     *  Информация о том, содержит ли запись отметку "реклама" (1 — да, 0 — нет).
     */
    @Getter
    @SerializedName("marked_as_ads")
    BoolInt markedAsAds;

    /**
     *  true, если объект добавлен в закладки у текущего пользователя.
     */
    @Getter
    @SerializedName("is_favorite")
    boolean isFavorite;

}
