package ua.nure.helperk.rest.myapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import java.sql.Timestamp;

/**
 * @author Oleg Dashkevych.
 */
@SuppressWarnings({"CanBeFinal", "FieldCanBeLocal"})
@Data
@NoArgsConstructor
public class Advert {

    private Long id;

    private String titleName;

    private String description;

    private Timestamp startDate;

    private Timestamp endDate;

    private Double price;

    private User creator;

    private User executor;

    private AdvertType type;

    public Advert(JSONObject jsonObject) {
        this.id = jsonObject.getLong("id");
        this.titleName = jsonObject.getString("titleName");
        this.description = jsonObject.getString("description");
        this.startDate = new Timestamp(jsonObject.getLong("startDate"));
        this.price = jsonObject.getDouble("price");
        this.creator = new User((JSONObject) jsonObject.get("creator"));
        this.type = new AdvertType((JSONObject) jsonObject.get("type"));
    }
}
