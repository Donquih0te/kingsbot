package vk.sdk.objects.utils;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
=======
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum BoolInt implements EnumParam {
>>>>>>> modularity

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum BoolInt implements EnumParam {

    @JsonProperty("0")
    NO(0),

    @JsonProperty("1")
    YES(1);

    private final Integer value;

    @Override
    public String getValue() {
        return value.toString();
    }

}
