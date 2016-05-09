package ua.nure.helperk.rest.myapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

/**
 * @author Oleg Dashkevych.
 */
@SuppressWarnings({"CanBeFinal", "FieldCanBeLocal"})
@Data
@NoArgsConstructor
public class AdvertType {

    private Long id;

    private String name;

    public AdvertType(JSONObject jsonObject) {
        this.id = jsonObject.getLong("id");
        this.name = jsonObject.getString("name");
    }
}
