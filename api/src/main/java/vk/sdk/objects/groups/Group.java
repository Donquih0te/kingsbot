package vk.sdk.objects.groups;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Объект содержит информацию о сообществе ВКонтакте.
 */
@ToString
@EqualsAndHashCode
public class Group {

    /**
     * 	Идентификатор сообщества.
     */
    @Getter
    @SerializedName("id")
    private Integer id;

    /**
     *  Название сообщества.
     */
    @Getter
    @SerializedName("name")
    private String name;

    /**
     *  Короткий адрес.
     */
    @Getter
    @SerializedName("screen_name")
    private String screenName;

    /**
     *  Является ли сообщество закрытым.
     *  Возможные значения:
     *      0 — открытое;
     *      1 — закрытое;
     *      2 — частное.
     */
    @Getter
    @SerializedName("is_closed")
    private Integer isClosed;

    /**
     *  Возвращается в случае, если сообщество удалено или заблокировано.
     *  Возможные значения:
     *      deleted — сообщество удалено;
     *      banned — сообщество заблокировано;
     */
    @Getter
    @SerializedName("deactivated")
    private String deactivated;

    /**
     *  Информация о том, является ли текущий пользователь руководителем.
     *  Возможные значения:
     *      1 — является;
     *      0 — не является.
     */
    @Getter
    @SerializedName("is_admin")
    private Integer isAdmin;

    /**
     *  Уровень полномочий текущего пользователя (если is_admin = 1):
     *      1 — модератор;
     *      2 — редактор;
     *      3 — администратор.
     */
    @Getter
    @SerializedName("admin_level")
    private Integer adminLevel;

    /**
     *  Информация о том, является ли текущий пользователь участником.
     *  Возможные значения:
     *      1 — является;
     *      0 — не является.
     */
    @Getter
    @SerializedName("is_member")
    private Integer isMember;

    /**
     *  Информация о том, является ли текущий пользователь рекламодателем.
     *  Возможные значения:
     *      1 — является;
     *      0 — не является.
     */
    @Getter
    @SerializedName("is_advertiser")
    private Integer isAdvertiser;

    /**
     *  Идентификатор пользователя, который отправил приглашение в сообщество.
     *  Поле возвращается только для метода groups.getInvites.
     */
    @Getter
    @SerializedName("invited_by")
    private Integer invitedBy;

    /**
     *  Тип сообщества:
     *      group — группа;
     *      page — публичная страница;
     *      event — мероприятие.
     */
    @Getter
    @SerializedName("type")
    private String type;

    /**
     *  URL главной фотографии с размером 50x50px.
     */
    @Getter
    @SerializedName("photo_50")
    private String photo50;

    /**
     *	URL главной фотографии с размером 100x100px.
     */
    @Getter
    @SerializedName("photo_100")
    private String photo100;

    /**
     *  URL главной фотографии в максимальном размере.
     */
    @Getter
    @SerializedName("photo_200")
    private String photo200;

}
