package org.simplesecurity.config;

import org.simplesecurity.security.spring.config.SimpleSecurityConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:simplesecurity.properties")
@Import({ DispatcherConfig.class, SimpleSecurityConfig.class })
@ComponentScan({ "org.simplesecurity" })
public class ApplicationConfig implements WebMvcConfigurer {
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
