package com.dinesh.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dinesh.ds.model.Product;
import com.dinesh.ds.repository.ProductRepository;

@Controller
public class managmentController {

	@Autowired
	ProductRepository productRepository;

	
	
	
	
	
	@RequestMapping("manage/product")
	public ModelAndView manageProduct(@RequestParam(name = "success", required = false) String success) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickedManageProduct", "true");
		
		
		if(success!=null) {
		if (success.equals("product")) {
			mv.addObject("msg", "Product submitted successfully!");
		}
		}
		return mv;
	}

	@RequestMapping("manage/{id}/product")
	public ModelAndView manageProductEdit(@PathVariable int id) throws Exception {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Product Management");
		mv.addObject("userClickedManageProduct", true);

		// Product nProduct = new Product();
		mv.addObject("product", productRepository.getByProductId(id));
		return mv;

	}
	
	@RequestMapping("view/{id}/product")
	public ModelAndView testSpring(@PathVariable int id) throws Exception {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickedViewSingleProduct","true");
		Product p=productRepository.getByProductId(id);
		mv.addObject("product",p);
		return mv;
	}

}
