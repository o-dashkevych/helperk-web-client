package ua.nure.helperk.rest.myapi.controller.query;

import org.json.JSONArray;
import org.json.JSONObject;
import ua.nure.helperk.rest.myapi.entity.AdvertType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public class AdvertTypeQuerySender extends QuerySender {

    public AdvertType executeAdvertType(String... params) {
        setUpConnectionParams(params[0]);
        AdvertType advertType;
        try {
            JSONObject result = getJSONObjectResponse();
            advertType = new AdvertType(result);
        } catch (Throwable t) {
            advertType = new AdvertType();
            advertType.setId(-1L);
            throwable = t;
        }
        return advertType;
    }

    public List<AdvertType> executeAllAdvertTypes(String... params) {
        setUpConnectionParams(params[0]);
        final List<AdvertType> advertTypes;
        try {
            JSONArray result = getJSONArrayResponse();
            advertTypes = new ArrayList<>(result.length());
            result.forEach(o -> advertTypes.add(new AdvertType((JSONObject) o)));
        } catch (Throwable t) {
            throwable = t;
            return new ArrayList<>(0);
        }
        return advertTypes;
    }

}
