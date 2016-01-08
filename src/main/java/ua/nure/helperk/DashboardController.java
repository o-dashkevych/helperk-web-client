package ua.nure.helperk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.nure.helperk.rest.myapi.RestServer;
import ua.nure.helperk.rest.myapi.controller.AdvertController;
import ua.nure.helperk.rest.myapi.controller.AdvertTypeController;
import ua.nure.helperk.rest.myapi.entity.Advert;
import ua.nure.helperk.rest.myapi.entity.AdvertType;
import ua.nure.helperk.rest.myapi.entity.User;
import ua.nure.helperk.rest.myapi.impl.DefaultRestServer;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Oleg Dashkevych.
 */
@Controller
@RequestMapping("/advert")
public class DashboardController {

	private final RestServer restServer = new DefaultRestServer();

	private final AdvertController advertController = restServer.getAdvertController();

	private final AdvertTypeController advertTypeController = restServer.getAdvertTypeController();

	@RequestMapping(method = RequestMethod.GET)
	public String mainPage(ModelMap model) {
		List<Advert> adverts = advertController.getAll();
		List<AdvertType> advertTypes = advertTypeController.getAll();
		model.addAttribute("adverts", adverts);
		model.addAttribute("advertTypes", advertTypes);
		return "adverts_page";
	}

	@RequestMapping("/add")
	public String goAdvertAddPage(ModelMap model) {
		List<Advert> adverts = advertController.getAll();
		List<AdvertType> advertTypes = advertTypeController.getAll();
		model.addAttribute("advertTypes", advertTypes);
		return "add_advert";
	}

	@RequestMapping("/view")
	public String goAdvertExecPage(ModelMap model, @RequestParam(value = "id") String advertId, HttpSession session) {
		Advert advert = advertController.getById(advertId);
		model.addAttribute("advert", advert);
		User currentUser = (User) session.getAttribute("user");
		if (!advert.getCreator().getId().equals(currentUser.getId())) {
			return "view_advert";
		} else return "edit_advert";
	}


	@RequestMapping("/view/execute")
	public String executeAdvert(ModelMap model, @RequestParam(value = "id") String advertId, HttpSession session) {
		Advert advert = advertController.getById(advertId);
		model.addAttribute("advert", advert);
		User currentUser = (User) session.getAttribute("user");
		if (advertController.execAdvert(advert, currentUser)) {
			model.addAttribute("message", "You have a new task");
		} else {
			model.addAttribute("message", "You cannot execute this task");
		}
		return "view_advert";
	}

	@RequestMapping("/add/submit")
	public String addAdvert(ModelMap model,
							@RequestParam(value = "title") String title,
							@RequestParam(value = "description") String description,
//							@RequestParam(value = "endDate") Long endDate,
							@RequestParam(value = "type") String type,
							@RequestParam(value = "price") Double price, HttpSession session) {
		AdvertController advertController = restServer.getAdvertController();
		AdvertTypeController advertTypeController = restServer.getAdvertTypeController();
		Advert advert = new Advert();
		User creator = (User) session.getAttribute("user");
		advert.setImage(null);
		advert.setCreator(creator);
		advert.setExecutor(null);
		advert.setTitleName(title);
		advert.setDescription(description);
		advert.setStartDate(new Timestamp(System.currentTimeMillis()));
//		advert.setEndDate(new TiendDatemestamp());
		advert.setPrice(price);
		advert.setType(advertTypeController.getAdvertTypeByName(type));
		model.addAttribute("advert", advert);
		if (advertController.addAdvert(advert)) {
			return "redirect:/advert/";
		}
		model.addAttribute("error", "Sorry, cannot add advert");
		return "add_advert";
	}
}
