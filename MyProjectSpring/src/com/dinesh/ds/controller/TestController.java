package com.dinesh.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dinesh.ds.repository.UserRepository;

@Controller
public class TestController {
	@Autowired
	UserRepository userRepository;
	@Transactional
	@RequestMapping("addFeedback")
	public ModelAndView test( ) throws Exception {
		ModelAndView mv=new ModelAndView("page");
	
userRepository.getAll().forEach(System.out::println);
//System.out.println(	userRepository.delete(4));
	System.out.println("success");
		return mv;
	}

}
