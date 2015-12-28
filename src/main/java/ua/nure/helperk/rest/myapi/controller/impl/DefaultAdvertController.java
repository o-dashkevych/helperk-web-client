package ua.nure.helperk.rest.myapi.controller.impl;

import org.apache.log4j.Logger;
import ua.nure.helperk.rest.myapi.constant.PathConstant;
import ua.nure.helperk.rest.myapi.controller.AdvertController;
import ua.nure.helperk.rest.myapi.controller.query.AdvertQuerySender;
import ua.nure.helperk.rest.myapi.entity.Advert;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public class DefaultAdvertController implements AdvertController {

	private static final Logger LOGGER = Logger.getLogger(DefaultUserAccountController.class);

	AdvertQuerySender querySender = new AdvertQuerySender();

	@Override
	public List<Advert> getAll() {
		String query = PathConstant.ALL_ADVERTS;
		LOGGER.info("query: " + query);
		System.out.println("query: " + query);
		List<Advert> adverts = querySender.executeAllAdverts(query);
		System.out.println("All adverts size: " + adverts.size());
		return adverts;
	}
}
