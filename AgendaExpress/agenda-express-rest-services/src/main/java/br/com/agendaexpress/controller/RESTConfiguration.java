package br.com.agendaexpress.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

@Configuration
public class RESTConfiguration {
	@Bean
	public View jsonTemplate() {
		/*MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setPrettyPrint(true);
		return view;*/
		return null;
	}

	@Bean
	public ViewResolver viewResolver() {
		//return new BeanNameViewResolver();
		return null;
	}
}