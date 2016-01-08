package ua.nure.helperk.rest.myapi.constant;

/**
 * @author Oleg Dashkevych.
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

	/* ADVERT */

	public static final String ADVERT_ID = "id=";

	public static final String ADVERT_CREATOR = "creator=";

	public static final String ADVERT_EXECUTOR = "executor=";

	public static final String ADVERT_TITLE = "title=";

	public static final String ADVERT_DESC = "description=";

	public static final String ADVERT_START_DATE = "startDate=";

	public static final String ADVERT_END_DATE = "endDate=";

	public static final String ADVERT_PRICE = "price=";

	public static final String ADVERT_ADVERT_TYPE = "type=";

	/* ADVERT CONTROLLER */

	public static final String ADVERT = SERVER + "/advert/";

	public static final String ALL_ADVERTS = ADVERT + "all";

	public static final String ADD_ADVERT = ADVERT + "add?";

	public static final String UPDATE_ADVERT = ADVERT + "update?";

	public static final String EXEC_ADVERT = ADVERT + "execute?";

	public static final String GET_ADVERT_BY_ID = ADVERT + "get?";

	/* ADVERT TYPE */

	public static final String ADVERT_TYPE_NAME = "name=";

	/* ADVERT TYPE CONTROLLER */

	public static final String ADVERT_TYPE = SERVER + "/advert_type/";

	public static final String GET_ADVERTS_TYPE = ADVERT_TYPE + "get?";

	public static final String ALL_ADVERT_TYPES = ADVERT_TYPE + "all";

}
