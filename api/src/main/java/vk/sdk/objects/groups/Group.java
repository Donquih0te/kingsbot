package vk.sdk.objects.groups;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * Объект содержит информацию о сообществе ВКонтакте.
 */
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group {

    /**
     * 	Идентификатор сообщества.
     */
    @Getter
    @SerializedName("id")
    Integer id;

    /**
     *  Название сообщества.
     */
    @Getter
    @SerializedName("name")
    String name;

    /**
     *  Короткий адрес.
     */
    @Getter
    @SerializedName("screen_name")
    String screenName;

    /**
     *  Является ли сообщество закрытым.
     *  Возможные значения:
     *      0 — открытое;
     *      1 — закрытое;
     *      2 — частное.
     */
    @Getter
    @SerializedName("is_closed")
    Integer isClosed;

    /**
     *  Возвращается в случае, если сообщество удалено или заблокировано.
     *  Возможные значения:
     *      deleted — сообщество удалено;
     *      banned — сообщество заблокировано;
     */
    @Getter
    @SerializedName("deactivated")
    String deactivated;

    /**
     *  Информация о том, является ли текущий пользователь руководителем.
     *  Возможные значения:
     *      1 — является;
     *      0 — не является.
     */
    @Getter
    @SerializedName("is_admin")
    Integer isAdmin;

    /**
     *  Уровень полномочий текущего пользователя (если is_admin = 1):
     *      1 — модератор;
     *      2 — редактор;
     *      3 — администратор.
     */
    @Getter
    @SerializedName("admin_level")
    Integer adminLevel;

    /**
     *  Информация о том, является ли текущий пользователь участником.
     *  Возможные значения:
     *      1 — является;
     *      0 — не является.
     */
    @Getter
    @SerializedName("is_member")
    Integer isMember;

    /**
     *  Информация о том, является ли текущий пользователь рекламодателем.
     *  Возможные значения:
     *      1 — является;
     *      0 — не является.
     */
    @Getter
    @SerializedName("is_advertiser")
    Integer isAdvertiser;

    /**
     *  Идентификатор пользователя, который отправил приглашение в сообщество.
     *  Поле возвращается только для метода groups.getInvites.
     */
    @Getter
    @SerializedName("invited_by")
    Integer invitedBy;

    /**
     *  Тип сообщества:
     *      group — группа;
     *      page — публичная страница;
     *      event — мероприятие.
     */
    @Getter
    @SerializedName("type")
    String type;

    /**
     *  URL главной фотографии с размером 50x50px.
     */
    @Getter
    @SerializedName("photo_50")
    String photo50;

    /**
     *	URL главной фотографии с размером 100x100px.
     */
    @Getter
    @SerializedName("photo_100")
    String photo100;

    /**
     *  URL главной фотографии в максимальном размере.
     */
    @Getter
    @SerializedName("photo_200")
    String photo200;

}
