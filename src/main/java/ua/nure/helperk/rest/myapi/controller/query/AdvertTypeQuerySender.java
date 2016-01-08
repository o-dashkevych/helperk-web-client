package ua.nure.helperk.rest.myapi.controller.query;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
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
		AdvertType advertType;
		try {
			String url = params[0];

			DefaultHttpClient httpClient = new DefaultHttpClient();
			ResponseHandler<String> res = new BasicResponseHandler();

			HttpGet get = new HttpGet(url);

			String response = httpClient.execute(get, res);
			JSONObject result = new JSONObject(response);
			advertType = new AdvertType(result);

		} catch (Throwable t) {
			advertType = new AdvertType();
			advertType.setId(-1L);
			throwable = t;
		}
		return advertType;
	}

	public List<AdvertType> executeAllAdvertTypes(String... params) {
		final List<AdvertType> advertTypes;
		try {
			String url = params[0];

			DefaultHttpClient httpClient = new DefaultHttpClient();
			ResponseHandler<String> res = new BasicResponseHandler();

			HttpGet get = new HttpGet(url);

			String response = httpClient.execute(get, res);
			JSONArray result = new JSONArray(response);
			advertTypes = new ArrayList<>(result.length());
			result.forEach(o -> advertTypes.add(new AdvertType((JSONObject) o)));
		} catch (Throwable t) {
			throwable = t;
			return new ArrayList<>(0);
		}
		return advertTypes;
	}

}
