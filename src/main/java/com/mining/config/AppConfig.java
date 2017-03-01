package com.mining.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mining")
public class AppConfig {

	// Put Other Application configuration here.
	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		// Using gmail
		mailSender.setHost("inchcmpc10608");
		mailSender.setPort(125);
		mailSender.setUsername("admin@scbdom.com");
		mailSender.setPassword("admin");
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", "true");
		javaMailProperties.put("mail.smtp.auth", "true");
		javaMailProperties.put("mail.transport.protocol", "smtp");
		javaMailProperties.put("mail.smtp.ssl.trust", "inchcmpc10608");
		javaMailProperties.put("mail.debug", "true");// Prints out everything on screen
		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
	}
	@Bean
	public SimpleMailMessage getMailMessage() {
		return new SimpleMailMessage();
	}
	
	/*@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		// Set the maximum allowed size (in bytes) for each individual file.
		resolver.setMaxUploadSizePerFile(5242880);// 5MB
		// You may also set other available properties.
		return resolver;
	}*/

}