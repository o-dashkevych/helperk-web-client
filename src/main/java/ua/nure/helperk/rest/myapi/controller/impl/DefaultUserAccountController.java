package ua.nure.helperk.rest.myapi.controller.impl;

import org.apache.log4j.Logger;
import ua.nure.helperk.rest.myapi.constant.PathConstant;
import ua.nure.helperk.rest.myapi.controller.UserAccountController;
import ua.nure.helperk.rest.myapi.controller.query.UserQuerySender;
import ua.nure.helperk.rest.myapi.entity.User;
import ua.nure.helperk.rest.myapi.entity.UserRole;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public class DefaultUserAccountController implements UserAccountController {

	private static final Logger LOGGER = Logger.getLogger(DefaultUserAccountController.class);

	UserQuerySender querySender = new UserQuerySender();

	@Override
	public boolean loginUser(User user) {

		String query = PathConstant.AUTH + PathConstant.USER_EMAIL
				+ user.getEmail() + PathConstant.AMPERSAND + PathConstant.USER_PASS
				+ user.getPassword();
		LOGGER.info("query: " + query);
		System.out.println("query: " + query);
		String result = querySender.executeAuthen(query).toString();
		System.out.println("result " + result);
		return Boolean.valueOf(result);
	}

	@Override
	public boolean isUserExistByEmail(String email) {
		return false;
	}

	@Override
	public boolean registerNewUser(User user) {
		String query = PathConstant.ADD_USER + PathConstant.USER_EMAIL
				+ user.getEmail() + PathConstant.AMPERSAND + PathConstant.USER_PASS
				+ user.getPassword() + PathConstant.AMPERSAND + PathConstant.USER_NAME + user.getName();
		LOGGER.info("query: " + query);
		System.out.println("query: " + query);
		User resultUser = querySender.executeUser(query);
		return resultUser.getId() > -1;

	}

	@Override
	public UserRole getRoleByEmail(String email) {

		String query = PathConstant.GET_ROLE + email;
		LOGGER.info("query: " + query);
		System.out.println("query: " + query);
		UserRole role = querySender.executeRole(query);
		return (role.getId() != -1) ? role : null;
	}

	@Override
	public List<User> getAll() {
		String query = PathConstant.ALL_USERS;
		LOGGER.info("query: " + query);
		System.out.println("query: " + query);
		List<User> users = (List<User>) querySender.executeAllUsers(query);
		System.out.println("All users size: " + users.size());
		return users;
	}
}
