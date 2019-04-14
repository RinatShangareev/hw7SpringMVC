package ru.shangareevrr.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.shangareevrr.common.entity.User;

@Controller
public class LoginController {


	@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}


	@PostMapping("/authUser")
	public String processloginForm(@ModelAttribute("user") User theUser, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "error";
		}

		if (theUser.getUserName().equals("admin") &&
				theUser.getPassword().equals("admin"))
		{
			return "success";
		}
		return  "error";
	}

	@GetMapping("/login")
	public String loginForm() {

	    return "login";
	}
//		User existing = userService.findByUserName(userName);
//		if (existing != null) {
//			theModel.addAttribute("systemUser", new SystemUser());
//			theModel.addAttribute("registrationError", "User name already exists.");
//			return "success";
//		}
//		return "registration-confirmation";

}