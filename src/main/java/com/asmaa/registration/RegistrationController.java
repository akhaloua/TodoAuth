package com.asmaa.registration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.asmaa.DAO.RoleDAOImpl;
import com.asmaa.DAO.UserDAOImpl;
import com.asmaa.Model.Role;

import com.asmaa.Model.User;
import com.asmaa.validation.user.PasswordsEqualConstraintValidator;

@Controller
public class RegistrationController {
	@Autowired
	public UserDAOImpl userService;
	@Autowired
	public RoleDAOImpl roleService;
	@Autowired
	private BCryptPasswordEncoder encoder;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result,RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "register";
		} else {
			User newUser = new User();
			Role userRole = roleService.findRoleByName("USER");
			String hashedPassword = encoder.encode(user.getPassword());
			newUser.setUserName(user.getUserName());
			newUser.setEmail(user.getEmail());
			newUser.setPassword(hashedPassword);

			newUser.setRoles(Arrays.asList(userRole));
			newUser.setStatus("ACTIVE");
			User usr = userService.findUserByName(user.getUserName());
			if (usr != null) {// user found
				result.rejectValue("userName", "error.user", "An account already exists for this username");
				return "register";

			}
			if (usr == null) {

				User usr2 = userService.findUserByEmail(user.getEmail());
				if (usr2 != null) { // email found
					result.rejectValue("email", "error.user", "An account already exists for this email.");
					return "register";
				} 
				else {
					userService.addUser(newUser);
					 redirectAttributes.addFlashAttribute("success_reg", "true");
			            return "redirect:login";
				}
			}

		}
		return null;
	}

}