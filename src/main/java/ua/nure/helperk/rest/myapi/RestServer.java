package ua.nure.helperk.rest.myapi;

import ua.nure.helperk.rest.myapi.controller.AdvertController;
import ua.nure.helperk.rest.myapi.controller.AdvertTypeController;
import ua.nure.helperk.rest.myapi.controller.UserAccountController;

public interface RestServer {

    UserAccountController getUserController();

    AdvertController getAdvertController();

    AdvertTypeController getAdvertTypeController();
}
