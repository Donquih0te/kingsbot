package vk.sdk.objects.wall;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import vk.sdk.objects.utils.BoolInt;
import vk.sdk.objects.wall.enums.FriendsOnly;
import vk.sdk.objects.wall.enums.PostType;

import java.util.List;

/**
 *  Объект, описывающий запись на стене пользователя или сообщества.
 */
@ToString
@EqualsAndHashCode
public class WallPost {

    /**
     *  Идентификатор записи.
     */
    @Getter
    @SerializedName("id")
    private Integer id;

    /**
     *  Идентификатор владельца стены, на которой размещена запись.
     */
    @Getter
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     *  Идентификатор автора записи (от чьего имени опубликована запись).
     */
    @Getter
    @SerializedName("from_id")
    private Integer fromId;

    /**
     *  Идентификатор администратора, который опубликовал запись
     *  (возвращается только для сообществ при запросе с ключом доступа администратора).
     */
    @Getter
    @SerializedName("created_by")
    private Integer createdBy;

    /**
     *  Время публикации записи в формате UnixTime.
     */
    @Getter
    @SerializedName("date")
    private Long date;

    /**
     *  Текст записи.
     */
    @Getter
    @SerializedName("text")
    private String text;

    /**
     *  Идентификатор владельца записи, в ответ на которую была оставлена текущая.
     */
    @Getter
    @SerializedName("reply_owner_id")
    private Integer replyOwnerId;

    /**
     *  Идентификатор записи, в ответ на которую была оставлена текущая.
     */
    @Getter
    @SerializedName("reply_post_id")
    private Integer replyPostId;

    /**
     *  1, если запись была создана с опцией «Только для друзей».
     */
    @Getter
    @SerializedName("friends_only")
    private FriendsOnly friendsOnly;

    /**
     *  Информация о комментариях к записи.
     */
    @Getter
    @SerializedName("comments")
    private WallPostCommentsInfo comments;

    /**
     *  Информация о лайках к записи.
     */
    @Getter
    @SerializedName("likes")
    private WallPostLikesInfo likes;

    /**
     *  Информация о репостах записи («Рассказать друзьям»).
     */
    @Getter
    @SerializedName("reposts")
    private WallPostRepostsInfo reposts;

    /**
     *  Информация о просмотрах записи.
     */
    @Getter
    @SerializedName("views")
    private WallPostViews views;

    /**
     *  Тип записи.
     *  Может принимать следующие значения:
     *  post, copy, reply, postpone, suggest.
     */
    @Getter
    @SerializedName("post_type")
    private PostType postType;

    /**
     *  Информация о способе размещения записи.
     *  Поле возвращается только для Standalone-приложений с ключом доступа, полученным в Implicit Flow.
     */
    @Getter
    @SerializedName("post_source")
    private WallPostSource postSource;

    /**
     *  Медиавложения записи (фотографии, ссылки и т.п.)
     *
     *  TODO: create object Attachment
     */
    @Getter
    @SerializedName("attachments")
    private Object attachments;

    /**
     *  Информация о местоположении
     *
     *  TODO: create object Geo
     */
    @Getter
    @SerializedName("geo")
    private Object geo;

    /**
     *  Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
     */
    @Getter
    @SerializedName("signer_id")
    private Integer signerId;

    /**
     *  Массив, содержащий историю репостов для записи.
     *  Возвращается только в том случае, если запись является репостом.
     *  Каждый из объектов массива, в свою очередь, является объектом-записью стандартного формата.
     */
    @Getter
    @SerializedName("copy_history")
    private List<Object> copyHistory;

    /**
     *  Информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может).
     */
    @Getter
    @SerializedName("can_pin")
    private BoolInt canPin;

    /**
     *  Информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может).
     */
    @Getter
    @SerializedName("can_delete")
    private BoolInt canDelete;

    /**
     *  Информация о том, может ли текущий пользователь редактировать запись (1 — может, 0 — не может).
     */
    @Getter
    @SerializedName("can_edit")
    private BoolInt canEdit;

    /**
     *  Информация о том, что запись закреплена.
     *  Если не закреплена, то параметр отсутствует.
     */
    @Getter
    @SerializedName("is_pinned")
    private BoolInt isPinned;

    /**
     *  Информация о том, содержит ли запись отметку "реклама" (1 — да, 0 — нет).
     */
    @Getter
    @SerializedName("marked_as_ads")
    private BoolInt markedAsAds;

    /**
     *  true, если объект добавлен в закладки у текущего пользователя.
     */
    @Getter
    @SerializedName("is_favorite")
    private boolean isFavorite;

}
