package com.mvc.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.mvc.inteceptor.LoginInteceptor;
import com.mvc.inteceptor.TimeInteceptor;

import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;

@Configuration
@ComponentScan("com.mvc.controller")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	@Bean(name="messageSource")
	public ResourceBundleMessageSource MessageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource=new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("message");
		return resourceBundleMessageSource;
	}
	@Bean("localeResolver")
	public LocaleResolver LocaleResolver() {
		CookieLocaleResolver cookieLocaleResolver=new CookieLocaleResolver();
	     cookieLocaleResolver.setCookieName("cookieName"); 
		return cookieLocaleResolver;
	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry){
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated methd stub
		super.addInterceptors(registry);
//		registry.addInterceptor(new LoginInteceptor());
		registry.addInterceptor(new TimeInteceptor());
//		registry.addInterceptor(new LocaleChangeInterceptor()); 
	}
    @Override
    public void addFormatters(FormatterRegistry registry) {
	// TODO Auto-generated method stub
	super.addFormatters(registry);
	registry.addFormatter(new DateFormatter("yyyy-mm-dd"));
    }
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css");
	}
}
