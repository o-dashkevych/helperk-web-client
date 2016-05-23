package ua.nure.helperk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nure.helperk.rest.myapi.RestServer;
import ua.nure.helperk.rest.myapi.constant.Roles;
import ua.nure.helperk.rest.myapi.controller.AdvertTypeController;
import ua.nure.helperk.rest.myapi.controller.UserAccountController;
import ua.nure.helperk.rest.myapi.entity.Advert;
import ua.nure.helperk.rest.myapi.entity.AdvertType;
import ua.nure.helperk.rest.myapi.entity.User;
import ua.nure.helperk.rest.myapi.entity.UserRole;
import ua.nure.helperk.rest.myapi.impl.DefaultRestServer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
@Controller
@RequestMapping("/login")
public class AuthController {

    private final RestServer restServer = new DefaultRestServer();

    private final AdvertTypeController advertTypeController = restServer.getAdvertTypeController();

    private User user;

    private String page;

    private ModelMap model;

    @RequestMapping(method = RequestMethod.POST)
    public String loginUser(ModelMap model, @RequestParam(value = "email") String email,
                            @RequestParam(value = "password") String password, HttpServletRequest request) {
		user = new User();
		this.model = model;
        page = "login";
        buildUser(email, password);
        if (!isExist(request)) {
            model.addAttribute("error", "Sorry, user with this email/pass does not exist");
        }
        return page;
    }

    private boolean isExist(HttpServletRequest request) {
        UserAccountController userAccountController = restServer.getUserController();
        if (userAccountController.loginUser(user)) {
            user = userAccountController.getUserByEmail(user.getEmail());
            request.getSession().setAttribute("user", user);
            setLoggedUserProperties();
            return true;
        }
        return false;
    }

    private void setLoggedUserProperties() {
        UserRole role = user.getRole();
        if (role.getName().equals(Roles.ADMIN.name())) {
            setAdminProperties();
        } else setDefaultUserProperties();
    }

    private void setDefaultUserProperties() {
        List<Advert> adverts = restServer.getAdvertController().getAll();
        List<AdvertType> advertTypes = advertTypeController.getAll();
        model.addAttribute("advertTypes", advertTypes);
        model.addAttribute("adverts", adverts);
        page = "adverts_page";
    }

    private void setAdminProperties() {
        page = "admin_page";
    }

    private void buildUser(String email, String password) {
        user.setEmail(email);
        user.setPassword(password);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String loginAccount(ModelMap model) {
        model.addAttribute("user", new User());
        return "login";
    }
}
