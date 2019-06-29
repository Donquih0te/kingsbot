package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.net.URL;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> modularity

/**
 * Объект содержит информацию о сообществе ВКонтакте.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group {

    /**
     * 	Идентификатор сообщества.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Название сообщества.
     */
    @Getter
    @JsonProperty("name")
    String name;

    /**
     *  Короткий адрес.
     */
    @Getter
    @JsonProperty("screen_name")
    String screenName;

    /**
     *  Является ли сообщество закрытым.
     *  Возможные значения:
     *      0 — открытое;
     *      1 — закрытое;
     *      2 — частное.
     */
    @Getter
    @JsonProperty("is_closed")
    Integer isClosed;

    /**
     *  Возвращается в случае, если сообщество удалено или заблокировано.
     *  Возможные значения:
     *      deleted — сообщество удалено;
     *      banned — сообщество заблокировано;
     */
    @Getter
    @JsonProperty("deactivated")
<<<<<<< HEAD
    Optional<String> deactivated = Optional.empty();
=======
    String deactivated;
>>>>>>> modularity

    /**
     *  Информация о том, является ли текущий пользователь руководителем.
     *  Возможные значения:
     *      1 — является;
     *      0 — не является.
     */
    @Getter
    @JsonProperty("is_admin")
    Integer isAdmin;

    /**
     *  Уровень полномочий текущего пользователя (если is_admin = 1):
     *      1 — модератор;
     *      2 — редактор;
     *      3 — администратор.
     */
    @Getter
    @JsonProperty("admin_level")
<<<<<<< HEAD
    Optional<Integer> adminLevel = Optional.empty();
=======
    Integer adminLevel;
>>>>>>> modularity

    /**
     *  Информация о том, является ли текущий пользователь участником.
     *  Возможные значения:
     *      1 — является;
     *      0 — не является.
     */
    @Getter
    @JsonProperty("is_member")
    Integer isMember;

    /**
     *  Информация о том, является ли текущий пользователь рекламодателем.
     *  Возможные значения:
     *      1 — является;
     *      0 — не является.
     */
    @Getter
    @JsonProperty("is_advertiser")
    Integer isAdvertiser;

    /**
     *  Идентификатор пользователя, который отправил приглашение в сообщество.
     *  Поле возвращается только для метода "groups.getInvites".
     */
    @Getter
    @JsonProperty("invited_by")
<<<<<<< HEAD
    Optional<Integer> invitedBy = Optional.empty();
=======
    Integer invitedBy;
>>>>>>> modularity

    /**
     *  Тип сообщества:
     *      group — группа;
     *      page — публичная страница;
     *      event — мероприятие.
     */
    @Getter
    @JsonProperty("type")
    String type;

    /**
     *  URL главной фотографии с размером 50x50px.
     */
    @Getter
    @JsonProperty("photo_50")
    URL photo50;

    /**
     *	URL главной фотографии с размером 100x100px.
     */
    @Getter
    @JsonProperty("photo_100")
    URL photo100;

    /**
     *  URL главной фотографии в максимальном размере.
     */
    @Getter
    @JsonProperty("photo_200")
    URL photo200;

}
