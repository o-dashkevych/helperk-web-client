package ua.nure.helperk.rest.myapi.controller.query;

import org.json.JSONArray;
import org.json.JSONObject;
import ua.nure.helperk.rest.myapi.entity.Advert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public class AdvertQuerySender extends QuerySender {


    public List<Advert> executeAllAdverts(String... params) {
        setUpConnectionParams(params[0]);
        final List<Advert> adverts = new ArrayList<>();
        try {
            JSONArray result = getJSONArrayResponse();
            result.forEach(o -> adverts.add(new Advert((JSONObject) o)));
        } catch (Throwable t) {
            throwable = t;
            return new ArrayList<>(0);
        }
        return adverts;
    }


    public Advert executeAdvert(String... params) {
        setUpConnectionParams(params[0]);
        Advert advert;
        try {
            JSONObject result = getJSONObjectResponse();
            advert = new Advert(result);
        } catch (Throwable t) {
            advert = new Advert();
            advert.setId(-1L);
            throwable = t;
        }
        return advert;
    }

}
