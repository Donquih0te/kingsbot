package ru.kingsbot.client.objects.users;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 *  users.get response example:
 *
 *  {
 *      "response": [{
 *          "id": 210700286,
 *          "first_name": "Lindsey",
 *          "last_name": "Stirling",
 *          "is_closed": false,
 *          "can_access_closed": true
 *      }]
 *  }
 *
 */
public class User {

    @Getter
    @SerializedName("id")
    private Integer id;

    @Getter
    @SerializedName("first_name")
    private String firstName;

    @Getter
    @SerializedName("last_name")
    private String lastName;

    @Getter
    @SerializedName("is_closed")
    private boolean isClosed;

    @Getter
    @SerializedName("can_access_closed")
    private boolean canAccessClosed;

}
