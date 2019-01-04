package com.dinesh.ds.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dinesh.ds.model.Product;
import com.dinesh.ds.repository.ProductRepository;
import com.dinesh.ds.util.FileUtil;
import com.dinesh.ds.validator.ProductValidator;

@Controller
@RequestMapping("/manage/product")
public class ProductController {
	
	
	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String ManageProduct(@ModelAttribute Product product,HttpServletRequest req,
			HttpServletResponse resp,Model model,BindingResult results) throws Exception {
		
		System.out.println("In Method");
		System.out.println(product.toString());
		if(product.getId()==null) {
			new ProductValidator().validate(product, results);
		}
		else {
			if(product.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(product, results);
			}
		}
		
		if(results.hasErrors()) {
			model.addAttribute("message", "Validation fails for adding the product!");
			model.addAttribute("userClickedManageProduct",true);
			return "page";	
		}
		
		
		if(product.getId()==null) {
			productRepository.Add(product);
			
		}else {
			productRepository.update(product);	
		}
		
		if(!product.getFile().getOriginalFilename().equals("")){
			
			FileUtil.uploadFile(req, product.getFile(), product.getCode());
		}
		return "redirect:/manage/product?success=product";
		
	}


	@RequestMapping("/product")
	public ModelAndView manageProduct(@RequestParam(name="success",required=false)String success) {		

		ModelAndView mv = new ModelAndView("page");	
		mv.addObject("title","Product Management");		
		mv.addObject("userClickedManageProduct",true);
		
		Product nProduct = new Product();
		
		
		nProduct.setActive(true);

		mv.addObject("product", nProduct);

		
		if(success != null) {
			if(success.equals("product")){
				mv.addObject("message", "Product submitted successfully!");
			}	
			
		}
			
		return mv;
		
	}
	
	

	
}
