package ua.nure.helperk.rest.myapi.controller;

import ua.nure.helperk.rest.myapi.entity.Advert;
import ua.nure.helperk.rest.myapi.entity.User;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public interface AdvertController {

    List<Advert> getAll();

    Advert getById(String id);

    boolean addAdvert(Advert advert);

    boolean execAdvert(Advert advert, User user);
}
