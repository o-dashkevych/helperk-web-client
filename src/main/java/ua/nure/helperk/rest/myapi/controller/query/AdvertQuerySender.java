package ua.nure.helperk.rest.myapi.controller.query;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
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
		final List<Advert> adverts;
		try {
			String url = params[0];

			DefaultHttpClient httpClient = new DefaultHttpClient();
			ResponseHandler<String> res = new BasicResponseHandler();

			HttpGet get = new HttpGet(url);

			String response = httpClient.execute(get, res);
			JSONArray result = new JSONArray(response);
			adverts = new ArrayList<>(result.length());
			result.forEach(o -> adverts.add(new Advert((JSONObject) o)));
		} catch (Throwable t) {
			throwable = t;
			return new ArrayList<>(0);
		}
		return adverts;
	}
}
