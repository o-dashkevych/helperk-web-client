package ua.nure.helperk;

import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nure.helperk.rest.myapi.RestServer;
import ua.nure.helperk.rest.myapi.controller.UserAccountController;
import ua.nure.helperk.rest.myapi.entity.Advert;
import ua.nure.helperk.rest.myapi.entity.User;
import ua.nure.helperk.rest.myapi.impl.DefaultRestServer;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RestServer restServer = new DefaultRestServer();

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @Setter
    private ModelMap model;

    @RequestMapping(method = RequestMethod.POST)
    public String addUser(ModelMap model, @RequestParam(value = "email") String email,
                          @RequestParam(value = "name") String name,
                          @RequestParam(value = "password") String password) {
        setModel(model);
        User user = buildUser(email, password, name);
        model.addAttribute("user", user);
        return getPageAfterRegisterResult(user);
    }

    private String getPageAfterRegisterResult(User user) {
        UserAccountController userAccountController = restServer.getUserController();
        if (userAccountController.registerNewUser(user)) {
            List<Advert> adverts = restServer.getAdvertController().getAll();
            model.addAttribute("adverts", adverts);
            return "adverts_page";
        }
        model.addAttribute("error", "Sorry, user with this email/pass is already exist");
        return "register";
    }

    private User buildUser(String email, String password, String name) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        return user;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String registerPage(ModelMap model) {
        model.addAttribute("user", new User());
        return "register";
    }

}
