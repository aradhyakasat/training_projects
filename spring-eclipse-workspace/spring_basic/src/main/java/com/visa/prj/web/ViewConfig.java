package com.visa.prj.web;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ViewConfig {

	@Bean
	public ResourceBundleMessageSource messageSource() {     //used to read from the property file
		ResourceBundleMessageSource bundle = new ResourceBundleMessageSource();
		bundle.setBasename("messages");
		
		return bundle;
	}

}
