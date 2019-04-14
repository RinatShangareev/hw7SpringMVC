package ru.shangareevrr.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.shangareevrr.common.entity.User;

@Controller
public class LoginController {

//	@RequestMapping(method = RequestMethod.GET)
//	public String printWelcome(ModelMap model) {
//
//		model.addAttribute("message", "Spring 4 MVC - Hello World");
//		return "welcome";
//
//	}

	@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}


	@PostMapping("/login")
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


//    @RequestMapping("/Login")
//    public String doLogin(Model model, @ModelAttribute("userName")
//            String userName, @ModelAttribute("password")  String password,  HttpServletRequest req) {
//
//        System.out.println("userName = " + userName);
//
//        System.out.println("password = " + password);

//        // Get the web application context, all spring beans are managed in this context.
//        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());
//
//        UserAccountBean userAccountBean = (UserAccountBean)context.getBean("userAccountBean");
//
//        boolean checkResult = userAccountBean.checkUserLogin(userName, password);

//        if(checkResult)
//        {
//            model.addAttribute(STATUS_MESSAGE, "User account is correct. ");
//            return "success";
//        }else
//        {
//            model.addAttribute(STATUS_MESSAGE, "User account is not correct. ");
//            return "error";
//        }
//        return "success";
//    }


	@GetMapping("/login")
	public String loginForm(@ModelAttribute("user") User theUser, BindingResult theBindingResult, Model theModel) {

		if (theBindingResult.hasErrors()) {
			return "error";
		}

		if (theUser.getUserName().equals("admin") &&
                theUser.getPassword().equals("admin"))
        {
            return "success";
        }
		return  "error";


//		User existing = userService.findByUserName(userName);
//		if (existing != null) {
//			theModel.addAttribute("systemUser", new SystemUser());
//			theModel.addAttribute("registrationError", "User name already exists.");
//			return "success";
//		}
//		return "registration-confirmation";
	}
	
}