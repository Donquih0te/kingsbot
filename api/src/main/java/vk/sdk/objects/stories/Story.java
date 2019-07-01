package vk.sdk.objects.stories;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.photos.Photo;
import vk.sdk.objects.utils.BoolInt;
import vk.sdk.objects.utils.YesParam;
import vk.sdk.objects.video.Video;

import java.util.Optional;

/**
 *  Объект, описывающий историю.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Story {

    /**
     *  Идентификатор истории.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Идентификатор владельца истории.
     */
    @Getter
    @JsonProperty("owner_id")
    Integer ownerId;

    /**
     *  Дата добавления в UnixTime.
     */
    @Getter
    @JsonProperty("date")
    Optional<Long> date = Optional.empty();

    /**
     *  Дата в UnixTime, когда история истечёт.
     */
    @Getter
    @JsonProperty("expires_at")
    Optional<Long> expiresAt = Optional.empty();

    /**
     *  True, если срок хранения истории истёк.
     *  В этом случае объект истории содержит только поля "id", "owner_id", "date", "expires_at", "is_expired".
     */
    @Getter
    @JsonProperty("is_expired")
    Optional<Boolean> isExpired = Optional.empty();

    /**
     *  True, если история удалена или не существует.
     *
     *  В этом случае объект истории содержит только поля "id", "owner_id", "is_deleted".
     */
    @Getter
    @JsonProperty("Is_deleted")
    Optional<Boolean> isDeleted = Optional.empty();

    /**
     *  Информация о том, может ли пользователь просмотреть историю (0 — нет, 1 — да).
     *
     *  Если can_see = 0, объект истории содержит только поля "id", "owner_id", "date", "expires_at", "can_see", "type".
     */
    @Getter
    @JsonProperty("can_see")
    Optional<BoolInt> canSee = Optional.empty();

    /**
     *  1, если история просмотрена текущим пользователем.
     */
    @Getter
    @JsonProperty("seen")
    Optional<YesParam> seen = Optional.empty();

    /**
     *  Тип истории.
     *  Возможные значения:
     *      photo — фотография;
     *      video — видеозапись.
     */
    @Getter
    @JsonProperty("type")
    Optional<StoryType> type = Optional.empty();

    /**
     *  Фотография из истории.
     *  (для type = photo)
     */
    @Getter
    @JsonProperty("photo")
    Optional<Photo> photo = Optional.empty();

    /**
     *  Видео из истории.
     *  (для type = video)
     */
    @Getter
    @JsonProperty("video")
    Optional<Video> video = Optional.empty();

    /**
     *  Ссылка для перехода из истории.
     */
    @Getter
    @JsonProperty("link")
    Optional<StoryLink> link = Optional.empty();

    /**
     *  Идентификатор пользователя, загрузившего историю, ответом на которую является текущая.
     */
    @Getter
    @JsonProperty("parent_story_owner_id")
    Optional<Integer> parentStoryOwnerId = Optional.empty();

    /**
     *  Идентификатор истории, ответом на которую является текущая.
     */
    @Getter
    @JsonProperty("parent_story_id")
    Optional<Integer> parentStoryId = Optional.empty();

    /**
     *  Объект родительской истории.
     */
    @Getter
    @JsonProperty("parent_story")
    Optional<Story> parentStory = Optional.empty();

    /**
     *  Информация об ответах на текущую историю.
     *  Получить истории-ответы можно методом "stories.getReplies".
     */
    @Getter
    @JsonProperty("replies")
    Optional<Object> replies = Optional.empty();

    /**
     *  Информация о том, может ли пользователь ответить на историю
     *  (0 — нет, 1 — да).
     */
    @Getter
    @JsonProperty("can_reply")
    Optional<BoolInt> canReply = Optional.empty();

    /**
     *  Информация о том, может ли пользователь расшарить историю
     *  (0 — нет, 1 — да).
     */
    @Getter
    @JsonProperty("can_share")
    Optional<BoolInt> canShare = Optional.empty();

    /**
     *  Информация о том, может ли пользователь комментировать историю
     *  (0 — нет, 1 — да).
     */
    @Getter
    @JsonProperty("can_comment")
    Optional<BoolInt> canComment = Optional.empty();

    /**
     *  Число просмотров.
     */
    @Getter
    @JsonProperty("views")
    Optional<Integer> views = Optional.empty();

    /**
     *  Ключ доступа для приватного объекта.
     */
    @Getter
    @JsonProperty("access_key")
    Optional<String> accessKey = Optional.empty();

}
