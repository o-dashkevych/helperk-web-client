package ua.nure.helperk.rest.myapi;

import ua.nure.helperk.rest.myapi.controller.AdvertController;
import ua.nure.helperk.rest.myapi.controller.UserAccountController;

/**
 * Created by helperk on 12/20/2015.
 */
public interface RestServer {

	UserAccountController getUserController();

	AdvertController getAdvertController();
}
