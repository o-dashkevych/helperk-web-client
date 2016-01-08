package ua.nure.helperk.rest.myapi.controller;

import ua.nure.helperk.rest.myapi.entity.AdvertType;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public interface AdvertTypeController {

	AdvertType getAdvertTypeByName(String name);

	List<AdvertType> getAll();
}
