package vk.sdk.objects.utils;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonProperty;
=======
>>>>>>> modularity
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum YesParam implements EnumParam {

<<<<<<< HEAD
    @JsonProperty("1")
    YES(1);

    private final Integer value;
=======
    YES(1);

    private Integer value;
>>>>>>> modularity

    @Override
    public String getValue() {
        return value.toString();
    }
<<<<<<< HEAD

=======
>>>>>>> modularity
}
