package vk.sdk.objects.pages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.utils.BoolInt;

import java.net.URL;
import java.util.Optional;

/**
 *  Объект, описывающий вики-страницу.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WikiPage {

    /**
     *  Идентификатор вики-страницы.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Идентификатор сообщества.
     */
    @Getter
    @JsonProperty("group_id")
    Integer groupId;

    /**
     *  Идентификатор создателя вики-страницы.
     */
    @Getter
    @JsonProperty("creator_id")
    Integer creatorId;

    /**
     *  Название вики-страницы.
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
     *  1, если текущий пользователь может редактировать текст вики-страницы, иначе — 0.
     */
    @Getter
    @JsonProperty("current_user_can_edit")
    BoolInt currentUserCanEdit;

    /**
     *  1, если текущий пользователь может изменять права доступа на вики-страницу, иначе — 0.
     */
    @Getter
    @JsonProperty("current_user_can_edit_access")
    BoolInt currentUserCanEditAccess;

    /**
     *  Информация о том, кто может просматривать вики-страницу.
     */
    @Getter
    @JsonProperty("who_can_view")
    PrivacySetting whoCanView;

    /**
     *  Указывает, кто может редактировать вики-страницу.
     */
    @Getter
    @JsonProperty("who_can_edit")
    PrivacySetting whoCanEdit;

    /**
     *  Дата последнего изменения вики-страницы в формате UnixTime.
     */
    @Getter
    @JsonProperty("edited")
    Long edited;

    /**
     *  Дата создания вики-страницы в формате UnixTime.
     */
    @Getter
    @JsonProperty("created")
    Long created;

    /**
     *  Идентификатор пользователя, который редактировал вики-страницу последним.
     */
    @Getter
    @JsonProperty("editor_id")
    Integer editorId;

    /**
     *  Количество просмотров вики-страницы.
     */
    @Getter
    @JsonProperty("views")
    Integer views;

    /**
     *  Заголовок родительской страницы для навигации, если есть.
     */
    @Getter
    @JsonProperty("parent")
    Optional<String> parent = Optional.empty();

    /**
     *  Заголовок второй родительской страницы для навигации, если есть
     */
    @Getter
    @JsonProperty("parent2")
    Optional<String> parent2 = Optional.empty();

    /**
     *  Текст страницы в вики-формате, если был запрошен.
     */
    @Getter
    @JsonProperty("source")
    Optional<String> source = Optional.empty();

    /**
     *  Текст страницы в html-формате, если был запрошен.
     */
    @Getter
    @JsonProperty("html")
    Optional<String> html = Optional.empty();

    /**
     *  Адрес страницы для отображения вики-страницы.
     */
    @Getter
    @JsonProperty("view_url")
    URL viewUrl;

}
