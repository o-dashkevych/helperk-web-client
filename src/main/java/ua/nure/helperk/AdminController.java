package ua.nure.helperk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.nure.helperk.rest.myapi.RestServer;
import ua.nure.helperk.rest.myapi.controller.UserAccountController;
import ua.nure.helperk.rest.myapi.entity.User;
import ua.nure.helperk.rest.myapi.impl.DefaultRestServer;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final RestServer restServer = new DefaultRestServer();

    private final UserAccountController userAccountController = restServer.getUserController();

    @RequestMapping(method = RequestMethod.GET)
    public String goAdmin(ModelMap model) {
        return "admin_page";
    }

    @RequestMapping("/users")
    public String goUsersPage(ModelMap model) {
        List<User> users = userAccountController.getAll();
        model.addAttribute("users", users);
        return "admin_users_page";
    }
}
