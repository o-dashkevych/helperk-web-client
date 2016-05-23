package ua.nure.helperk.rest.myapi.controller.impl;

import org.apache.log4j.Logger;
import ua.nure.helperk.rest.myapi.constant.PathConstant;
import ua.nure.helperk.rest.myapi.controller.AdvertController;
import ua.nure.helperk.rest.myapi.controller.query.AdvertQuerySender;
import ua.nure.helperk.rest.myapi.entity.Advert;
import ua.nure.helperk.rest.myapi.entity.User;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public class DefaultAdvertController implements AdvertController {

    private static final Logger LOGGER = Logger.getLogger(DefaultUserAccountController.class);

    private final AdvertQuerySender querySender = new AdvertQuerySender();

    @Override
    public List<Advert> getAll() {
        String query = PathConstant.ALL_ADVERTS;
        LOGGER.info("query: " + query);
        List<Advert> adverts = querySender.executeAllAdverts(query);
        LOGGER.info("All adverts size: " + adverts.size());
        return adverts;
    }

    @Override
    public Advert getById(String id) {
        String query = PathConstant.GET_ADVERT_BY_ID + PathConstant.ADVERT_ID + id;
        LOGGER.info("query: " + query);
        Advert advert = querySender.executeAdvert(query);
        LOGGER.info("Advert id: " + advert.getId());
        return advert;
    }

    @Override
    public boolean addAdvert(Advert advert) {
        // TODO Fix potential bug
        String query = buildAddAdvertQuery(advert);
        return processAdvertQueryAndGetResult(query);
    }

    private String buildAddAdvertQuery(Advert advert) {
        String query = PathConstant.ADD_ADVERT + PathConstant.ADVERT_CREATOR + advert.getCreator().getEmail() +
                PathConstant.AMPERSAND + PathConstant.ADVERT_TITLE + advert.getTitleName() +
                PathConstant.AMPERSAND + PathConstant.ADVERT_DESC + advert.getDescription() +
                PathConstant.AMPERSAND + PathConstant.ADVERT_START_DATE + advert.getStartDate().getTime() +
                PathConstant.AMPERSAND + PathConstant.ADVERT_PRICE + advert.getPrice() +
                PathConstant.AMPERSAND + PathConstant.ADVERT_ADVERT_TYPE + advert.getType().getName();
        return query.replaceAll(" ", "%20");
    }

    @Override
    public boolean execAdvert(Advert advert, User user) {
        // TODO Fix potential bug
        String query = PathConstant.EXEC_ADVERT + PathConstant.ADVERT_ID + advert.getId() +
                PathConstant.AMPERSAND + PathConstant.ADVERT_EXECUTOR + user.getId();
        query = query.replaceAll(" ", "%20");
        return processAdvertQueryAndGetResult(query);
    }

    private boolean processAdvertQueryAndGetResult(String query) {
        LOGGER.info("query: " + query);
        Advert advertResult = querySender.executeAdvert(query);
        return advertResult.getId() > -1;
    }
}
