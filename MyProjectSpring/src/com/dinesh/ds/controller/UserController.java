package com.dinesh.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dinesh.ds.model.User;
import com.dinesh.ds.repository.UserRepository;

@Controller

public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping("register")
	@Transactional
	public ModelAndView add(@ModelAttribute User u) throws Exception {

		User user = u;

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println(u);

		userRepository.Add(user);

		ModelAndView mv = new ModelAndView("login");
		mv.addObject("msg", "Register successfully...proceed with login!!");

		return mv;
	}
	
	@RequestMapping("user/view/product")
	@Transactional
	public ModelAndView viewProduct() throws Exception {

	


		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickedViewProducts","true");


		return mv;
	}
	
	


}