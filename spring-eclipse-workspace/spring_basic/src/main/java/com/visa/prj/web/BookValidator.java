package com.visa.prj.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.visa.prj.entity.Book;

@Component
public class BookValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Book.class); //appicable to book and its subclasses
	}

	@Override
	public void validate(Object obj, Errors errors) { 	//obj is object to validate
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id","book.id.required","Book ID is required!!" );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "book.title.required","Title is required!!!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "book.price.required","Price is required!!!");
		
		Book b=(Book) obj;     //for further authentication
		if(b.getPrice()<0) {
			errors.rejectValue("price", "invalid.price","Price should be greater than Zero :(");
		}
			
		

	}

}
