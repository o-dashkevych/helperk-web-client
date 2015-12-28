package ua.nure.helperk.rest.myapi.constant;

/**
 * Created by helperk on 12/20/2015.
 */
public class PathConstant {

	/* SERVER CONFIG */

	private static final String IP = "http://159.224.66.191";

	private static final String LH = "http://localhost";

	private static final String SERVER_HOST = LH;

	private static final String SERVER_PORT = ":8181";

	private static final String SERVER = SERVER_HOST + SERVER_PORT;

	/* USER */

	public static final String USER_EMAIL = "email=";

	public static final String USER_NAME = "name=";

	public static final String AMPERSAND = "&";

	public static final String USER_PASS = "password=";

	public static final String USER_ID = "id=";

	/* USER CONTROLLER */

	private static final String USER = SERVER + "/user/";

	public static final String AUTH = USER + "auth?";

	public static final String GETUSER = USER + "get?" + USER_EMAIL;

	public static final String ADD_USER = USER + "add?";

	public static final String VALID_USER = USER + "login?" + USER_EMAIL;

	public static final String ALL_USERS = USER + "all";

	/* USER ROLE TYPE CONTROLLER */

	public static final String USER_ROLE = SERVER + "/user_role/";

	public static final String GET_ROLE = USER_ROLE + "get?" + USER_EMAIL;

	/* ADVERT CONTROLLER */

	public static final String ADVERT = SERVER + "/advert/";

	public static final String ALL_ADVERTS = ADVERT + "all";

}
