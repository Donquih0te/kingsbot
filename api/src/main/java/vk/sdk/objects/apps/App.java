package vk.sdk.objects.apps;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.photos.Photo;
import vk.sdk.objects.utils.BoolInt;
import vk.sdk.objects.utils.YesParam;

import java.net.URL;
import java.util.Collections;
import java.util.List;

/**
 *  Объект, описывающий приложение.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class App {

    /**
     *  Идентификатор приложения.
     */
    @Getter
    @JsonProperty("id")
    Integer id;

    /**
     *  Название приложения.
     */
    @Getter
    @JsonProperty("title")
    String title;

    /**
     *  URL-адрес обложки приложения шириной 278px.
     */
    @Getter
    @JsonProperty("icon_278")
    URL icon278;

    /**
     *  URL-адрес обложки приложения шириной 139px.
     */
    @Getter
    @JsonProperty("icon_139")
    URL icon139;

    /**
     *  URL-адрес обложки приложения шириной 150px.
     */
    @Getter
    @JsonProperty("icon_150")
    URL icon150;

    /**
     *  URL-адрес обложки приложения шириной 75px.
     */
    @Getter
    @JsonProperty("icon_75")
    URL icon75;

    /**
     *  URL-адрес баннера шириной 560px.
     */
    @Getter
    @JsonProperty("banner_560")
    URL banner560;

    /**
     *  URL-адрес баннера шириной 1120px.
     */
    @Getter
    @JsonProperty("banner_1120")
    URL banner1120;

    /**
     *  Тип приложения.
     *  Возможные значения:
     *      app — социальное приложение;
     *      game — игра;
     *      site — подключаемый сайт;
     *      standalone — отдельное приложение (для мобильного устройства).
     */
    @Getter
    @JsonProperty("type")
    AppType type;

    /**
     *  Категория приложения.
     */
    @Getter
    @JsonProperty("section")
    String section;

    /**
     *  Адрес страницы автора приложения.
     */
    @Getter
    @JsonProperty("author_url")
    URL authorUrl;

    /**
     *  Идентификатор автора приложения.
     */
    @Getter
    @JsonProperty("author_id")
    Integer authorId;

    /**
     *  Идентификатор официальной группы приложения.
     */
    @Getter
    @JsonProperty("author_group")
    Integer authorGroup;

    /**
     *  Количество участников приложения.
     */
    @Getter
    @JsonProperty("members_count")
    Integer membersCount;

    /**
     *  Дата размещения в UnixTime.
     */
    @Getter
    @JsonProperty("published_date")
    Long publishedDate;

    /**
     *  Позиция в каталоге.
     */
    @Getter
    @JsonProperty("catalog_position")
    Integer catalogPosition;

    /**
     *  Является ли приложение мультиязычным (1).
     */
    @Getter
    @JsonProperty("international")
    BoolInt international;

    /**
     *  Тип турнирной таблицы.
     *  Возможные значения:
     *      0 — не поддерживается;
     *      1 — по уровню;
     *      2 — по очкам.
     */
    @Getter
    @JsonProperty("leaderboard_type")
    AppLeaderBoardType leaderBoardType;

    /**
     *  Идентификатор жанра.
     */
    @Getter
    @JsonProperty("genre_id")
    Integer genreId;

    /**
     *  Название жанра.
     */
    @Getter
    @JsonProperty("genre")
    String genre;

    /**
     *  Идентификатор приложения в магазине приложений.
     */
    @Getter
    @JsonProperty("platform_id")
    String platformId;

    /**
     *  Доступно ли приложение в мобильном каталоге.
     *  Возможные значения:
     *      1 — доступно;
     *      0 — недоступно.
     */
    @Getter
    @JsonProperty("is_in_catalog")
    BoolInt isInCatalog;

    /**
     *  Список идентификаторов друзей текущего пользователя, которые установили приложение.
     *  (если был передан параметр return_friends = 1)
     */
    @Getter
    @JsonProperty("friends")
    List<Integer> friends;

    /**
     *  1, если приложение установлено у текущего пользователя.
     */
    @Getter
    @JsonProperty("installed")
    BoolInt installed;

    /**
     *  1, если приложение — html5 игра.
     */
    @Getter
    @JsonProperty("is_html5_app")
    YesParam isHtml5App;

    /**
     *  Поддерживаемая ориентация экрана.
     *  Возможные значения:
     *      0 — альбомная и портретная;
     *      1 — только альбомная;
     *      2 — только портретная.
     */
    @Getter
    @JsonProperty("screen_orientation")
    AppScreenOrientationType screenOrientation;

    /**
     *  Тип элементов управления игрой на мобильных устройствах.
     *  Возможные значения:
     *      1 — прозрачный элемент управления поверх области с игрой;
     *      0 — чёрная полоска над областью с игрой.
     */
    @Getter
    @JsonProperty("mobile_controls_type")
    BoolInt mobileControlsType;

    /**
     *  1, если игра использует нижнюю часть экрана на iPhoneX.
     */
    @Getter
    @JsonProperty("mobile_view_support_type")
    BoolInt mobileViewSupportType;

    /*************************************************************************
     *
     *  Опциональные поля (при extended = 1)
     *
     *////////////////////////////////////////////////////////////////////////

    /**
     *  Описание приложения.
     */
    @Getter
    @JsonProperty("description")
    String description;

    /**
     *  Короткий адрес приложения (или строка "idXXXXXXX", если короткий адрес не задан).
     */
    @Getter
    @JsonProperty("screen_name")
    String screenName;

    /**
     *  URL-адрес обложки приложения шириной 16px.
     */
    @Getter
    @JsonProperty("icon_16")
    URL icon16;

    /**
     *  Массив объектов фотографий, описывающих скриншоты приложения.
     */
    @Getter
    @JsonProperty("screenshots")
    List<Photo> screenshots = Collections.emptyList();

    /**
     *  1, если у пользователя включены уведомления из этого приложения.
     */
    @Getter
    @JsonProperty("push_enabled")
    BoolInt pushEnabled;

}
