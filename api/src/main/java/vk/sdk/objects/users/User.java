package vk.sdk.objects.users;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Объект содержит информацию о пользователе ВКонтакте.
 */
@ToString
@EqualsAndHashCode
public class User {

    /**
     *  Идентификатор пользователя.
     */
    @Getter
    @SerializedName("id")
    private Integer id;

    /**
     *  Имя пользователя.
     */
    @Getter
    @SerializedName("first_name")
    private String firstName;

    /**
     *  Фамилия пользователя.
     */
    @Getter
    @SerializedName("last_name")
    private String lastName;

    /**
     *  Поле возвращается, если страница пользователя удалена или заблокирована, содержит значение deleted или banned.
     *  В этом случае опциональные поля не возвращаются.
     */
    @Getter
    @SerializedName("deactivated")
    private String deactivated;

    /**
     *  Скрыт ли профиль пользователя настройками приватности.
     */
    @Getter
    @SerializedName("is_closed")
    private boolean isClosed;

    /**
     *  Может ли текущий пользователь видеть профиль при is_closed = 1
     *  (например, он есть в друзьях).
     */
    @Getter
    @SerializedName("can_access_closed")
    private boolean canAccessClosed;

}
