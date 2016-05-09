package ua.nure.helperk;

import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nure.helperk.rest.myapi.RestServer;
import ua.nure.helperk.rest.myapi.controller.AdvertController;
import ua.nure.helperk.rest.myapi.controller.AdvertTypeController;
import ua.nure.helperk.rest.myapi.entity.Advert;
import ua.nure.helperk.rest.myapi.entity.User;
import ua.nure.helperk.rest.myapi.impl.DefaultRestServer;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * @author Oleg Dashkevych.
 */
@Controller
@RequestMapping("/advert")
public class DashboardController {

    private final RestServer restServer = new DefaultRestServer();

    private final AdvertController advertController = restServer.getAdvertController();

    private final AdvertTypeController advertTypeController = restServer.getAdvertTypeController();

    @Setter
    private HttpSession session;

    @Setter
    private ModelMap modelMap;

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        setModelMap(model);
        model.addAttribute("adverts", advertController.getAll());
        model.addAttribute("advertTypes", advertTypeController.getAll());
        return "adverts_page";
    }

    @RequestMapping("/add")
    public String goAdvertAddPage(ModelMap model) {
        setModelMap(model);
        model.addAttribute("advertTypes", advertTypeController.getAll());
        return "add_advert";
    }

    @RequestMapping("/view")
    public String goAdvertExecPage(ModelMap model, @RequestParam(value = "id") String advertId, HttpSession session) {
        setControllerProperties(session, model);
        Advert advert = advertController.getById(advertId);
        model.addAttribute("advert", advert);
        return defineAdvertCreatorViewPage(advert, session);
    }

    private String defineAdvertCreatorViewPage(Advert advert, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (!advert.getCreator().getId().equals(currentUser.getId())) {
            return "view_advert";
        } else return "edit_advert";
    }

    @RequestMapping("/view/execute")
    public String executeAdvert(ModelMap model, @RequestParam(value = "id") String advertId, HttpSession session) {
        setControllerProperties(session, model);
        Advert advert = advertController.getById(advertId);
        model.addAttribute("advert", advert);


        return "view_advert";
    }

    private void defineAdvertExecutionMessage(Advert advert, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");
        if (advertController.execAdvert(advert, currentUser)) {
            modelMap.addAttribute("message", "You have a new task");
        } else {
            modelMap.addAttribute("message", "You cannot execute this task");
        }
    }

    @RequestMapping("/add/submit")
    public String addAdvert(ModelMap model,
                            @RequestParam(value = "title") String title,
                            @RequestParam(value = "description") String description,
//							@RequestParam(value = "endDate") Long endDate,
                            @RequestParam(value = "type") String type,
                            @RequestParam(value = "price") Double price, HttpSession session) {
        setControllerProperties(session, model);

        Advert advert = buildAdvert(title, description, type, price);
        return tryToAddAdvertAndGetPage(advert);
    }

    private Advert buildAdvert(String title, String description, String type, Double price) {
        Advert advert = new Advert();
        User creator = (User) session.getAttribute("user");
        advert.setCreator(creator);
        advert.setExecutor(null);
        advert.setTitleName(title);
        advert.setDescription(description);
        advert.setStartDate(new Timestamp(System.currentTimeMillis()));
//		advert.setEndDate(new TiendDatemestamp());
        advert.setPrice(price);
        advert.setType(advertTypeController.getAdvertTypeByName(type));
        modelMap.addAttribute("advert", advert);
        return advert;
    }

    private String tryToAddAdvertAndGetPage(Advert advert) {
        if (advertController.addAdvert(advert)) {
            return "redirect:/advert/";
        }
        modelMap.addAttribute("error", "Sorry, cannot add advert");
        return "add_advert";
    }

    private void setControllerProperties(HttpSession session, ModelMap modelMap) {
        this.session = session;
        this.modelMap = modelMap;
    }
}
