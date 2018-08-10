package com.visa.prj.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.visa.prj.entity.User;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(User.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName","user.firstName.required","Book ID is required!!" );
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "user.lastName.required","Title is required!!!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "user.email.required","Email is required!!!");
		

	}

}
