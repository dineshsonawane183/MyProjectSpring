package com.dinesh.ds.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dinesh.ds.model.User;
import com.dinesh.ds.repository.UserRepository;

@Controller

public class PageController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping({ "home", "/", "index" })
	public ModelAndView page(HttpServletRequest req) throws Exception {
		ModelAndView mv = new ModelAndView("page");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!authentication.getName().equals("anonymousUser")) {
			String username = authentication.getName();
			User u = userRepository.getByUsername(username);
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			session.setAttribute("userRole", u.getUser().toString());
		}

		mv.addObject("UserClickedHome", "true");

		return mv;
	}

	@RequestMapping("contact")
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("UserClickedContact", "true");
		return mv;
	}

	@RequestMapping("about")
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("UserClickedAbout", "true");
		return mv;
	}

	@RequestMapping("user/testSpring")
	public ModelAndView testSpring() {

		ModelAndView mv = new ModelAndView("TestSpringSecurity");
		return mv;
	}

	@RequestMapping("manage/testSpring")
	public ModelAndView manageSpring() {

		ModelAndView mv = new ModelAndView("TestSpringSecurity");
		return mv;
	}

	@RequestMapping("signUpPage")
	public ModelAndView signUpPage() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("UserClickedSignUp", "true");
		return mv;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		ModelAndView mv = new ModelAndView("login");

		if (error != null) {
			mv.addObject("message", "Username and Password is invalid!");
		}

		if (logout != null) {
			mv.addObject("logout", "You have logged out successfully!");
		}
		return mv;
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest req, HttpServletResponse resp) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(req, resp, authentication);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Aha! Caught You.");
		mv.addObject("errorDescription", "You are not authorized to view this page!");
		mv.addObject("title", "403 Access Denied");
		return mv;
	}

}
