package ru.shangareevrr.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.shangareevrr.common.entity.User;
import ru.shangareevrr.common.service.UserService;

@Controller
public class LoginController {

	private UserService userService;

	@Autowired
	private void setUserService(UserService userService){
		this.userService = userService;
	}

	@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}


	@PostMapping("/authUser")
	public String processloginForm(@ModelAttribute("user") User theUser, Model model, String error, String logout) {

		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		User user = userService.findByUserName(theUser.getUserName());
		if (user != null)
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