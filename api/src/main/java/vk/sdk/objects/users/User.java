package vk.sdk.objects.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.utils.DeactivationType;

import java.util.Optional;

/**
 * Объект содержит информацию о пользователе ВКонтакте.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    /**
     *  Идентификатор пользователя.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Имя пользователя.
     */
    @Getter
    @JsonProperty("first_name")
    String firstName;

    /**
     *  Фамилия пользователя.
     */
    @Getter
    @JsonProperty("last_name")
    String lastName;

    /**
     *  Поле возвращается, если страница пользователя удалена или заблокирована, содержит значение deleted или banned.
     *  В этом случае опциональные поля не возвращаются.
     */
    @Getter
    @JsonProperty("deactivated")
    Optional<DeactivationType> deactivated;

    /**
     *  Скрыт ли профиль пользователя настройками приватности.
     */
    @Getter
    @JsonProperty("is_closed")
    boolean isClosed;

    /**
     *  Может ли текущий пользователь видеть профиль при is_closed = 1
     *  (например, он есть в друзьях).
     */
    @Getter
    @JsonProperty("can_access_closed")
    Optional<Boolean> canAccessClosed = Optional.empty();

    // TODO: add optional fields

}
