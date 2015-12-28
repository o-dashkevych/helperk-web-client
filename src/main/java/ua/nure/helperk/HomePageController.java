package ua.nure.helperk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.nure.helperk.rest.myapi.entity.User;

@Controller
@RequestMapping("/")
public class HomePageController {

	@RequestMapping(method = RequestMethod.GET)
	public String loginPage(ModelMap model) {
		model.addAttribute("user", new User());
		return "index";
	}
}