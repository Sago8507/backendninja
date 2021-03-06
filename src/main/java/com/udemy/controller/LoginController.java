package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.model.UserCredential;
import com.udemy.constant.ViewConstant;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/")
	public String redirectToLogin(){
		LOG.info("METHOD: redirectToLogin()");
		return "redirect:/login";
	}
	
	@GetMapping("login")
	public String showLoginForm(Model model, 
			@RequestParam(name="error", required=false)String error,
			@RequestParam(name="logout", required=false)String logout){
		LOG.info("METHOD: showLoginForm() -- PARAMS: error='" + error + "' logout='" + logout + "'");
		model.addAttribute("userCredential", new UserCredential());
		model.addAttribute("logout", logout);
		model.addAttribute("error", error);
		LOG.info("Return to 'login' view");
		return ViewConstant.LOGIN;
	}
	
	@PostMapping("logincheck")
	public String loginCheck(@ModelAttribute(name="userCredential")UserCredential userCredential){
		LOG.info("METHOD: loginCheck() -- PARAMS: userCredential='" + userCredential.toString() + "'");
		if (userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")){
			LOG.info("Return to 'contacts' view");
			return "redirect:/contacts/showcontacts";
		}
		LOG.info("redirect to 'login?error' view");
		return "redirect:/login?error";
	}
	
	
}
