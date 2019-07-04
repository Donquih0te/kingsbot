package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

/**
 *  Объект, описывающий информацию из блока контактов публичной страницы.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupContact {

    /**
     *  Идентификатор пользователя.
     */
    @Getter
    @JsonProperty("user_id")
    Optional<Integer> userId = Optional.empty();

    /**
     *  Должность.
     */
    @Getter
    @JsonProperty("description")
    Optional<String> description = Optional.empty();

    /**
     *  Номер телефона.
     */
    @Getter
    @JsonProperty("phone")
    Optional<String> phone = Optional.empty();

    /**
     *  Адрес e-mail.
     */
    @Getter
    @JsonProperty("email")
    Optional<String> email = Optional.empty();

}
