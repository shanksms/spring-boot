package org.test.bookpub;

import java.util.concurrent.TimeUnit;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.test.bookpub.formatter.BookFormatter;
import org.test.bookpub.repository.BookRespository;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter{
	
	@Autowired
	private BookRespository bookRepository;

	@Bean
	public RemoteIpFilter remoteIpFilter() {
		
		return new RemoteIpFilter();
		
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		return new LocaleChangeInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(localeChangeInterceptor());
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Auto-generated method stub
		registry.addFormatter(new BookFormatter(bookRepository));
	}
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		// TODO Auto-generated method stub
		//super.configurePathMatch(configurer);
		configurer.setUseSuffixPatternMatch(false)
				  .setUseTrailingSlashMatch(true);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/internal/**")
		        .addResourceLocations("classpath:/");
	}
	
	public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
		
		return new EmbeddedServletContainerCustomizer() {

			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.setSessionTimeout(1, TimeUnit.MINUTES);
			}
			
		};
		
	}
}
