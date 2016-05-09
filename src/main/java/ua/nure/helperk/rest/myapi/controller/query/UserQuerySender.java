package ua.nure.helperk.rest.myapi.controller.query;

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
        setUpConnectionParams(params[0]);
        User user;
        try {
            JSONObject result = getJSONObjectResponse();
            user = new User(result);
        } catch (Throwable t) {
            user = new User();
            user.setId(-1L);
            throwable = t;
        }
        return user;
    }

    public Object executeAuthentication(String... params) {
        String result = "false";
        setUpConnectionParams(params[0]);
        try {
            result = getResponseString();
        } catch (Throwable t) {
            throwable = t;
        }
        System.out.println(result);
        return result;
    }

    public UserRole executeRole(String... params) {
        setUpConnectionParams(params[0]);
        UserRole userRole;
        try {
            JSONObject result = getJSONObjectResponse();
            userRole = new UserRole(result);
        } catch (Throwable t) {
            userRole = new UserRole();
            userRole.setId(-1L);
            throwable = t;
        }
        return userRole;
    }

    public List<User> executeAllUsers(String... params) {
        setUpConnectionParams(params[0]);
        final List<User> users = new ArrayList<>();
        try {
            JSONArray result = getJSONArrayResponse();
            result.forEach(o -> users.add(new User((JSONObject) o)));
        } catch (Throwable t) {
            throwable = t;
            return new ArrayList<>(0);
        }
        return users;
    }
}
