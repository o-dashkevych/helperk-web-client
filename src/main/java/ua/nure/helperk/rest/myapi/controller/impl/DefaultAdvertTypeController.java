package ua.nure.helperk.rest.myapi.controller.impl;

import org.apache.log4j.Logger;
import ua.nure.helperk.rest.myapi.constant.PathConstant;
import ua.nure.helperk.rest.myapi.controller.AdvertTypeController;
import ua.nure.helperk.rest.myapi.controller.query.AdvertTypeQuerySender;
import ua.nure.helperk.rest.myapi.entity.AdvertType;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
public class DefaultAdvertTypeController implements AdvertTypeController {


    private static final Logger LOGGER = Logger.getLogger(DefaultUserAccountController.class);

    AdvertTypeQuerySender querySender = new AdvertTypeQuerySender();

    @Override
    public AdvertType getAdvertTypeByName(String name) {
        String query = PathConstant.GET_ADVERTS_TYPE + PathConstant.ADVERT_TYPE_NAME + name;
        LOGGER.info("query: " + query);
        AdvertType advertType = querySender.executeAdvertType(query);
        return (advertType.getId() != -1) ? advertType : null;
    }

    @Override
    public List<AdvertType> getAll() {
        String query = PathConstant.ALL_ADVERT_TYPES;
        LOGGER.info("query: " + query);
        List<AdvertType> advertTypes = querySender.executeAllAdvertTypes(query);
        System.out.println("All advertTypes size: " + advertTypes.size());
        return advertTypes;
    }
}
