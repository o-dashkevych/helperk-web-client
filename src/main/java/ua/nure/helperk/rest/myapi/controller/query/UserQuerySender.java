package ua.nure.helperk.rest.myapi.controller.query;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import ua.nure.helperk.rest.myapi.entity.User;
import ua.nure.helperk.rest.myapi.entity.UserRole;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public class UserQuerySender extends QuerySender {

	public User executeUser(String... params) {
		User user;
		try {
			String url = params[0];

			DefaultHttpClient httpClient = new DefaultHttpClient();
			ResponseHandler<String> res = new BasicResponseHandler();

			HttpGet get = new HttpGet(url);

			String response = httpClient.execute(get, res);
			JSONObject result = new JSONObject(response);

			user = new User(result);

		} catch (Throwable t) {
			user = new User();
			user.setId(-1L);
			throwable = t;
		}
		return user;
	}

	public Object executeAuthen(String... params) {
		String result = "false";

		try {
			String url = params[0];

			DefaultHttpClient httpClient = new DefaultHttpClient();
			ResponseHandler<String> res = new BasicResponseHandler();

			HttpGet get = new HttpGet(url);

            /* Calling REST server */
			String response = httpClient.execute(get, res);

			result = response;

		} catch (Throwable t) {
			throwable = t;
		}
		System.out.println(result);
		return result;
	}

	public UserRole executeRole(String... params) {
		UserRole userRole;
		try {
			String url = params[0];

			DefaultHttpClient httpClient = new DefaultHttpClient();
			ResponseHandler<String> res = new BasicResponseHandler();

			HttpGet get = new HttpGet(url);

			String response = httpClient.execute(get, res);
			JSONObject result = new JSONObject(response);

			userRole = new UserRole(result);

		} catch (Throwable t) {
			userRole = new UserRole();
			userRole.setId(-1L);
			throwable = t;
		}
		return userRole;
	}

	public List<User> executeAllUsers(String... params) {
		final List<User> users;
		try {
			String url = params[0];

			DefaultHttpClient httpClient = new DefaultHttpClient();
			ResponseHandler<String> res = new BasicResponseHandler();

			HttpGet get = new HttpGet(url);

			String response = httpClient.execute(get, res);
			JSONArray result = new JSONArray(response);
			users = new ArrayList<>(result.length());
			result.forEach(o -> users.add(new User((JSONObject) o)));
		} catch (Throwable t) {
			throwable = t;
			return new ArrayList<>(0);
		}
		return users;
	}
}
