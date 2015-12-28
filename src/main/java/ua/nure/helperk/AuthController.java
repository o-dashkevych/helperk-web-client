package ua.nure.helperk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nure.helperk.rest.myapi.RestServer;
import ua.nure.helperk.rest.myapi.constant.Roles;
import ua.nure.helperk.rest.myapi.controller.UserAccountController;
import ua.nure.helperk.rest.myapi.entity.Advert;
import ua.nure.helperk.rest.myapi.entity.User;
import ua.nure.helperk.rest.myapi.entity.UserRole;
import ua.nure.helperk.rest.myapi.impl.DefaultRestServer;

import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
@Controller
@RequestMapping("/login")
public class AuthController {

	private final RestServer restServer = new DefaultRestServer();

	@RequestMapping(method = RequestMethod.POST)
	public String loginUser(ModelMap model, @RequestParam(value = "email") String email,
							@RequestParam(value = "password") String password) {
		UserAccountController userAccountController = restServer.getUserController();
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		model.addAttribute("user", user);
		if (userAccountController.loginUser(user)) {
			UserRole role = userAccountController.getRoleByEmail(user.getEmail());
			if(role.getName().equals(Roles.ADMIN.name())) {
				return "admin_page";
			}else {
				List<Advert> adverts = restServer.getAdvertController().getAll();
				model.addAttribute("adverts", adverts);
				return "user_page";
			}
		}
		model.addAttribute("error", "Sorry, user with this email/pass does not exist");
		return "login";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String loginAccount(ModelMap model) {
		model.addAttribute("user", new User());
		return "login";
	}
}
