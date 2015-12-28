package ua.nure.helperk.rest.myapi.impl;

import ua.nure.helperk.rest.myapi.RestServer;
import ua.nure.helperk.rest.myapi.controller.UserAccountController;
import ua.nure.helperk.rest.myapi.controller.impl.DefaultUserAccountController;

/**
 * @author Oleg Dashkevych.
 */
public class DefaultRestServer implements RestServer {

	@Override
	public UserAccountController getUserController() {
		return new DefaultUserAccountController();
	}
}
