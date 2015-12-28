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
public class NavigationController {
	private final RestServer restServer = new DefaultRestServer();

	UserAccountController userAccountController = restServer.getUserController();

	@RequestMapping(method = RequestMethod.GET)
	public String goAdmin(ModelMap model) {
		return "admin_page";
	}

	@RequestMapping("/users")
	public String goUsersPage(ModelMap model) {
		List<User> users = userAccountController.getAll();
		model.addAttribute("users", users);
		return "users_page";
	}

	@RequestMapping("/charts")
	public String goChartsPage(ModelMap model) {
		return "charts";
	}

	@RequestMapping("/device")
	public String goDevicePage(ModelMap model) {
		return "devices";
	}

	@RequestMapping("/device/edit")
	public String goEditDevicePage(ModelMap model) {
		return "edit_device";
	}

	@RequestMapping("/outlet/add")
	public String goAddOutletPage(ModelMap model) {
		return "add_outlet";
	}

}
