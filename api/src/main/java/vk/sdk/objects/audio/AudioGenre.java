package vk.sdk.objects.audio;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import vk.sdk.objects.utils.EnumParam;

/**
 *  Жанр аудиозаписи.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum AudioGenre implements EnumParam {

    @JsonProperty("1")
    ROCK(1),

    @JsonProperty("2")
    POP(2),

    @JsonProperty("3")
    RAP_AND_HIPHOP(3),

    @JsonProperty("4")
    EASY_LISTENING(4),

    @JsonProperty("5")
    HOUSE_AND_DANCE(5),

    @JsonProperty("6")
    INSTRUMENTAL(6),

    @JsonProperty("7")
    METAL(7),

    @JsonProperty("8")
    DUBSTEP(8),

    @JsonProperty("10")
    DRUM_AND_BASE(10),

    @JsonProperty("11")
    TRANCE(11),

    @JsonProperty("12")
    CHANSON(12),

    @JsonProperty("13")
    ETHNIC(13),

    @JsonProperty("14")
    ACOUSTIC_AND_VOCAL(14),

    @JsonProperty("15")
    REGGAE(15),

    @JsonProperty("16")
    CLASSICAL(16),

    @JsonProperty("17")
    INDIE_POP(17),

    @JsonProperty("18")
    OTHER(18),

    @JsonProperty("19")
    SPEECH(19),

    @JsonProperty("22")
    ELECTROPOP_AND_DISCO(22),

    @JsonProperty("21")
    ALTERNATIVE(21),

    @JsonProperty("1001")
    JAZZ_AND_BLUES(1001);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
