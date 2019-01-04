package com.dinesh.ds.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dinesh.ds.model.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Product.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors error) {

		Product product = (Product) obj;
		if (product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			error.rejectValue("file", null, "please Select File For Upload");
			return;
		}

		if (!(product.getFile().getContentType().equals("image/png")
				|| product.getFile().getContentType().equals("image/jpeg")
				|| product.getFile().getContentType().equals("image/jpg")
				|| product.getFile().getContentType().equals("image/gif"))) {

			error.rejectValue("file", null, "Please Select Image File");
			return;

		}

	}

}
