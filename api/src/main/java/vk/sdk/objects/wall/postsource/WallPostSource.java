package vk.sdk.objects.wall.postsource;

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
 *  Объект, описывающий способ размещения записи на стене.
 */
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class WallPostSource {

    /**
     *  Тип источника.
     *  Возможные значения:
     *      vk — запись создана через основной интерфейс сайта (http://vk.com/);
     *      widget — запись создана через виджет на стороннем сайте;
     *      api — запись создана приложением через API;
     *      rss — запись создана посредством импорта RSS-ленты со стороннего сайта;
     *      sms — запись создана посредством отправки SMS-сообщения на специальный номер.
     */
    @Getter
    @JsonProperty("type")
    PostSourceType type;

    /**
     *  Название платформы, если оно доступно.
     *  Возможные значения:
     *      android;
     *      iphone;
     *      wphone.
     */
    @Getter
    @JsonProperty("platform")
<<<<<<< HEAD
    Optional<PostSourcePlatform> platform = Optional.empty();
=======
    PostSourcePlatform platform;
>>>>>>> modularity

    /**
     *  Тип действия (только для type = vk или widget).
     *  Возможные значения:
     *      profile_activity — изменение статуса под именем пользователя (для type = vk);
     *      profile_photo — изменение профильной фотографии пользователя (для type = vk);
     *      comments — виджет комментариев (для type = widget);
     *      like — виджет «Мне нравится» (для type = widget);
     *      poll — виджет опросов (для type = widget);
     */
    @Getter
    @JsonProperty("data")
<<<<<<< HEAD
    Optional<PostSourceData> data = Optional.empty();
=======
    PostSourceData data;
>>>>>>> modularity

    /**
     *  URL ресурса, с которого была опубликована запись.
     */
    @Getter
    @JsonProperty("url")
    URL url;

}
