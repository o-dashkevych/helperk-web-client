package ua.nure.helperk.rest.myapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * @author Oleg Dashkevych.
 */
@SuppressWarnings({"CanBeFinal", "FieldCanBeLocal"})
@Data
@NoArgsConstructor
public class UserRole implements Serializable {

    private Long id;

    private String name;

    public UserRole(String name) {
        this.name = name;
    }

    public UserRole(JSONObject jsonObject) {
        try {
            this.id = jsonObject.getLong("id");
            this.name = jsonObject.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
