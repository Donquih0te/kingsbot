package vk.sdk.objects.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import vk.sdk.objects.utils.BoolInt;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    GroupAccessType isClosed;

    /**
     *  Возвращается в случае, если сообщество удалено или заблокировано.
     *  Возможные значения:
     *      deleted — сообщество удалено;
     *      banned — сообщество заблокировано;
     */
    @Getter
    @JsonProperty("deactivated")
    Optional<GroupDeactivationType> deactivated = Optional.empty();

    /**
     *  Информация о том, является ли текущий пользователь руководителем.
     *  Возможные значения:
     *      1 — является;
     *      0 — не является.
     *
     *  Требуется scope = groups.
     */
    @Getter
    @JsonProperty("is_admin")
    Optional<BoolInt> isAdmin = Optional.empty();

    /**
     *  Уровень полномочий текущего пользователя (если is_admin = 1):
     *      1 — модератор;
     *      2 — редактор;
     *      3 — администратор.
     *
     *  Требуется scope = groups.
     */
    @Getter
    @JsonProperty("admin_level")
    Optional<GroupUserAuthorityLevel> adminLevel = Optional.empty();

    /**
     *  Информация о том, является ли текущий пользователь участником.
     *  Возможные значения:
     *      1 — является;
     *      0 — не является.
     *
     *  Требуется scope = groups.
     */
    @Getter
    @JsonProperty("is_member")
    Optional<BoolInt> isMember = Optional.empty();

    /**
     *  Информация о том, является ли текущий пользователь рекламодателем.
     *  Возможные значения:
     *      1 — является;
     *      0 — не является.
     *
     *  Требуется scope = groups.
     */
    @Getter
    @JsonProperty("is_advertiser")
    Optional<BoolInt> isAdvertiser = Optional.empty();

    /**
     *  Идентификатор пользователя, который отправил приглашение в сообщество.
     *  Поле возвращается только для метода "groups.getInvites".
     *  Требуется scope = groups.
     */
    @Getter
    @JsonProperty("invited_by")
    Optional<Integer> invitedBy = Optional.empty();

    /**
     *  Тип сообщества:
     *      group — группа;
     *      page — публичная страница;
     *      event — мероприятие.
     */
    @Getter
    @JsonProperty("type")
    GroupType type;

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

    /********************************************************************
     *
     *  Опциальные поля.
     *
     *///////////////////////////////////////////////////////////////////

    /**
     *  Строка тематики паблика.
     *  У групп возвращается строковое значение, открыта ли группа или нет, а у событий дата начала.
     */
    @Getter
    @JsonProperty("activity")
    Optional<String> activity = Optional.empty();

    /**
     *  Возрастное ограничение.
     *      1 — нет;
     *      2 — 16+;
     *      3 — 18+.
     */
    @Getter
    @JsonProperty("age_limit")
    Optional<GroupAgeLimit> ageLimit = Optional.empty();

    /**
     *  Информация о занесении в черный список сообщества
     *  (поле возвращается только при запросе информации об одном сообществе).
     */
    @Getter
    @JsonProperty("ban_info")
    Optional<GroupBanInfo> banInfo = Optional.empty();

    /**
     *  Информация о том, может ли текущий пользователь создать новое обсуждение в группе.
     *  Возможные значения:
     *      1 — может;
     *      0 — не может.
     */
    @Getter
    @JsonProperty("can_create_topic")
    Optional<BoolInt> canCreateTopic = Optional.empty();

    /**
     *  Информация о том, может ли текущий пользователь написать сообщение сообществу.
     *  Возможные значения:
     *      1 — может;
     *      0 — не может.
     */
    @Getter
    @JsonProperty("can_message")
    Optional<BoolInt> canMessage = Optional.empty();

    /**
     *  Информация о том, может ли текущий пользователь оставлять записи на стене сообщества.
     *  Возможные значения:
     *      1 — может;
     *      0 — не может.
     */
    @Getter
    @JsonProperty("can_post")
    Optional<BoolInt> canPost = Optional.empty();

    /**
     *  Информация о том, разрешено ли видеть чужие записи на стене группы.
     *  Возможные значения:
     *      1 — может;
     *      0 — не может.
     */
    @Getter
    @JsonProperty("can_see_all_posts")
    Optional<BoolInt> canSeeAllPosts = Optional.empty();

    /**
     *  Информация о том, может ли текущий пользователь загружать документы в группу.
     *  Возможные значения:
     *      1 — может;
     *      0 — не может.
     */
    @Getter
    @JsonProperty("can_upload_doc")
    Optional<BoolInt> canUploadDoc = Optional.empty();

    /**
     *  Информация о том, может ли текущий пользователь загружать видеозаписи в группу.
     *  Возможные значения:
     *      1 — может;
     *      0 — не может.
     */
    @Getter
    @JsonProperty("can_upload_video")
    Optional<BoolInt> canUploadVideo = Optional.empty();

    /**
     *  Город, указанный в информации о сообществе.
     */
    @Getter
    @JsonProperty("city")
    Optional<GroupCityCountry> city = Optional.empty();

    /**
     *  Информация из блока контактов публичной страницы.
     */
    @Getter
    @JsonProperty("contacts")
    List<GroupContact> contacts = Collections.emptyList();

    /**
     *  Объект, содержащий счётчики сообщества,
     *  может включать любой набор из следующих полей: photos, albums, audios, videos, topics, docs.
     *
     *  Поле возвращается только при запросе данных об одном сообществе.
     */
    @Getter
    @JsonProperty("counters")
    Optional<GroupCounters> counters = Optional.empty();

    /**
     *  Страна, указанная в информации о сообществе.
     */
    @Getter
    @JsonProperty("country")
    Optional<GroupCityCountry> country = Optional.empty();

    /**
     *  Обложка сообщества.
     */
    @Getter
    @JsonProperty("cover")
    Optional<GroupCover> cover = Optional.empty();

    /**
     *  Возвращает данные о точках, по которым вырезаны профильная и миниатюрная фотографии сообщества.
     */
    @Getter
    @JsonProperty("crop_photo")
    Optional<GroupCropPhoto> cropPhoto = Optional.empty();

    /**
     *  Текст описания сообщества.
     */
    @Getter
    @JsonProperty("description")
    Optional<String> description = Optional.empty();

    /**
     *  Идентификатор закрепленной записи.
     *  Получить дополнительные данные о записи можно методом "wall.getById", передав в поле posts {group_id}_{post_id}.
     */
    @Getter
    @JsonProperty("fixed_post")
    Optional<Integer> fixedPost = Optional.empty();

    /**
     *  Информация о том, установлена ли у сообщества главная фотография.
     *  Возможные значения:
     *      1 — установлена;
     *      0 — не установлена.
     */
    @Getter
    @JsonProperty("has_photo")
    Optional<BoolInt> hasPhoto = Optional.empty();

    /**
     *  Информация о том, находится ли сообщество в закладках у текущего пользователя.
     *  Возможные значения:
     *      1 — находится ;
     *      0 — не находится.
     */
    @Getter
    @JsonProperty("is_favorite")
    Optional<BoolInt> isFavorite = Optional.empty();

    /**
     *  Информация о том, скрыто ли сообщество из ленты новостей текущего пользователя.
     *  Возможные значения:
     *      1 — скрыто ;
     *      0 — не скрыто.
     */
    @Getter
    @JsonProperty("is_hidden_from_feed")
    Optional<BoolInt> isHiddenFromFeed = Optional.empty();

    /**
     *  Информация о том, заблокированы ли сообщения от этого сообщества (для текущего пользователя).
     */
    @Getter
    @JsonProperty("is_message_blocked")
    Optional<BoolInt> isMessageBlocked = Optional.empty();

    /**
     *  Информация из блока ссылок сообщества.
     */
    @Getter
    @JsonProperty("links")
    List<GroupLink> links = Collections.emptyList();

    /**
     *  Идентификатор основного фотоальбома.
     */
    @Getter
    @JsonProperty("main_album")
    Optional<Integer> mainAlbumId = Optional.empty();

    /**
     *  Информация о главной секции.
     *  Возможные значения:
     *      0 — отсутствует;
     *      1 — фотографии;
     *      2 — обсуждения;
     *      3 — аудиозаписи;
     *      4 — видеозаписи;
     *      5 — товары.
     */
    @Getter
    @JsonProperty("main_section")
    Optional<GroupMainSection> mainSection = Optional.empty();

    /**
     *  Информация о магазине.
     */
    @Getter
    @JsonProperty("market")
    Optional<GroupMarket> market = Optional.empty();

    /**
     *  Статус участника текущего пользователя.
     *  Возможные значения:
     *      0 — не является участником;
     *      1 — является участником;
     *      2 — не уверен, что посетит мероприятие;
     *      3 — отклонил приглашение;
     *      4 — запрос на вступление отправлен;
     *      5 — приглашен.
     */
    @Getter
    @JsonProperty("member_status")
    Optional<GroupMemberStatus> memberStatus = Optional.empty();

    /**
     *  Количество участников в сообществе.
     */
    @Getter
    @JsonProperty("members_count")
    Optional<Integer> membersCount = Optional.empty();

    /**
     *  Место, указанное в информации о сообществе.
     */
    @Getter
    @JsonProperty("place")
    Optional<GroupPlace> place = Optional.empty();

    /**
     *  Возвращается для публичных страниц. Текст описания для поля start_date.
     */
    @Getter
    @JsonProperty("public_date_label")
    Optional<String> publicDateLabel = Optional.empty();

    /**
     *  Адрес сайта из поля «веб-сайт» в описании сообщества.
     */
    @Getter
    @JsonProperty("site")
    Optional<URL> site = Optional.empty();

    /**
     *  Время начала встречи в формате UnixTime.
     *  Для публичных групп - дата основания в формате YYYYMMDD.
     */
    @Getter
    @JsonProperty("start_date")
    Optional<String> startDate = Optional.empty();

    /**
     *  Время окончания встречи в формате UnixTime.
     */
    @Getter
    @JsonProperty("finish_date")
    Optional<String> finishDate = Optional.empty();

    /**
     *  Статус сообщества.
     */
    @Getter
    @JsonProperty("status")
    Optional<String> status = Optional.empty();

    /**
     *  Информация о том, есть ли у сообщества «огонёк».
     */
    @Getter
    @JsonProperty("trending")
    Optional<BoolInt> trending = Optional.empty();

    /**
     *  Информация о том, верифицировано ли сообщество.
     *  Возможные значения:
     *      1 — является;
     *      0 — не является.
     */
    @Getter
    @JsonProperty("verified")
    Optional<BoolInt> verified = Optional.empty();

    /**
     *  Стена.
     *  Возможные значения:
     *      0 — выключена;
     *      1 — открытая;
     *      2 — ограниченная;
     *      3 — закрытая.
     */
    @Getter
    @JsonProperty("wall")
    Optional<GroupWallType> wall = Optional.empty();

    /**
     *  название главной вики-страницы.
     */
    @Getter
    @JsonProperty("wiki_page")
    Optional<String> wikiPage = Optional.empty();

}
