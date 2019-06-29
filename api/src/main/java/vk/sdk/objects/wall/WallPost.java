package vk.sdk.objects.wall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.utils.BoolInt;
import vk.sdk.objects.utils.YesParam;
import vk.sdk.objects.wall.comments.WallPostCommentsInfo;
import vk.sdk.objects.wall.postsource.WallPostSource;

<<<<<<< HEAD
import java.util.Collections;
import java.util.List;
import java.util.Optional;
=======
import java.util.List;
>>>>>>> modularity

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
    @JsonProperty("id")
    Integer id;

    /**
     *  Идентификатор владельца стены, на которой размещена запись.
     */
    @Getter
    @JsonProperty("owner_id")
    Integer ownerId;

    /**
     *  Идентификатор автора записи (от чьего имени опубликована запись).
     */
    @Getter
    @JsonProperty("from_id")
    Integer fromId;

    /**
     *  Идентификатор администратора, который опубликовал запись
     *  (возвращается только для сообществ при запросе с ключом доступа администратора).
     */
    @Getter
    @JsonProperty("created_by")
<<<<<<< HEAD
    Optional<Integer> createdBy = Optional.empty();
=======
    Integer createdBy;
>>>>>>> modularity

    /**
     *  Время публикации записи в формате UnixTime.
     */
    @Getter
    @JsonProperty("date")
    Long date;

    /**
     *  Текст записи.
     */
    @Getter
    @JsonProperty("text")
    String text;

    /**
     *  Идентификатор владельца записи, в ответ на которую была оставлена текущая.
     */
    @Getter
    @JsonProperty("reply_owner_id")
    Integer replyOwnerId;

    /**
     *  Идентификатор записи, в ответ на которую была оставлена текущая.
     */
    @Getter
    @JsonProperty("reply_post_id")
    Integer replyPostId;

    /**
     *  1, если запись была создана с опцией «Только для друзей».
     */
    @Getter
    @JsonProperty("friends_only")
<<<<<<< HEAD
    Optional<YesParam> friendsOnly = Optional.empty();
=======
    YesParam friendsOnly;
>>>>>>> modularity

    /**
     *  Информация о комментариях к записи.
     */
    @Getter
    @JsonProperty("comments")
    WallPostCommentsInfo comments;

    /**
     *  Информация о лайках к записи.
     */
    @Getter
    @JsonProperty("likes")
    WallPostLikesInfo likes;

    /**
     *  Информация о репостах записи («Рассказать друзьям»).
     */
    @Getter
    @JsonProperty("reposts")
    WallPostRepostsInfo reposts;

    /**
     *  Информация о просмотрах записи.
     */
    @Getter
    @JsonProperty("views")
    WallPostViewsInfo views;

    /**
     *  Тип записи.
     *  Может принимать следующие значения:
     *  post, copy, reply, postpone, suggest.
     */
    @Getter
    @JsonProperty("post_type")
    PostType postType;

    /**
     *  Информация о способе размещения записи.
     *  Поле возвращается только для Standalone-приложений с ключом доступа, полученным в Implicit Flow.
     */
    @Getter
    @JsonProperty("post_source")
<<<<<<< HEAD
    Optional<WallPostSource> postSource = Optional.empty();
=======
    WallPostSource postSource;
>>>>>>> modularity

    /**
     *  Медиавложения записи (фотографии, ссылки и т.п.)
     */
    @Getter
    @JsonProperty("attachments")
<<<<<<< HEAD
    List<WallPostAttachment> attachments = Collections.emptyList();
=======
    WallPostAttachment attachments;
>>>>>>> modularity

    /**
     *  Информация о местоположении.
     */
    @Getter
    @JsonProperty("geo")
    Geo geo;

    /**
     *  Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем;
     */
    @Getter
    @JsonProperty("signer_id")
<<<<<<< HEAD
    Optional<Integer> signerId = Optional.empty();
=======
    Integer signerId;
>>>>>>> modularity

    /**
     *  Массив, содержащий историю репостов для записи.
     *  Возвращается только в том случае, если запись является репостом.
     *  Каждый из объектов массива, в свою очередь, является объектом-записью стандартного формата.
     */
    @Getter
    @JsonProperty("copy_history")
<<<<<<< HEAD
    List<Object> copyHistory = Collections.emptyList();
=======
    List<Object> copyHistory;
>>>>>>> modularity

    /**
     *  Информация о том, может ли текущий пользователь закрепить запись (1 — может, 0 — не может).
     */
    @Getter
    @JsonProperty("can_pin")
    BoolInt canPin;

    /**
     *  Информация о том, может ли текущий пользователь удалить запись (1 — может, 0 — не может).
     */
    @Getter
    @JsonProperty("can_delete")
    BoolInt canDelete;

    /**
     *  Информация о том, может ли текущий пользователь редактировать запись (1 — может, 0 — не может).
     */
    @Getter
    @JsonProperty("can_edit")
    BoolInt canEdit;

    /**
     *  Информация о том, что запись закреплена.
     *  Если не закреплена, то параметр отсутствует.
     */
    @Getter
    @JsonProperty("is_pinned")
<<<<<<< HEAD
    Optional<YesParam> isPinned = Optional.empty();
=======
    YesParam isPinned;
>>>>>>> modularity

    /**
     *  Информация о том, содержит ли запись отметку "реклама" (1 — да, 0 — нет).
     */
    @Getter
    @JsonProperty("marked_as_ads")
    BoolInt markedAsAds;

    /**
     *  true, если объект добавлен в закладки у текущего пользователя.
     */
    @Getter
    @JsonProperty("is_favorite")
    boolean isFavorite;

}
