package com.mining.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mining.exception.MiningException;
import com.mining.model.JSON.UserInfo;
import com.mining.service.MailService;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	private SimpleMailMessage message;

	public void sendEmail(UserInfo userInfo) throws MiningException {

		try {
			message.setFrom("admin@scbdom.com");
			message.setTo(userInfo.getEmail());
			message.setText("Dear " + userInfo.getUserName()
					+ ", thank you for placing forgot password request. Your password is  "
					+ userInfo.getPassword());
			message.setSubject("Your password request");
			mailSender.send(message);
			System.out.println("Message Send...");
		} catch (MailException ex) {
			throw new MiningException("Error occured while sending the mail",
					ex.getMessage());
		}catch (Exception e) {
			throw new MiningException("Error occured while sending the mail",
					e.getMessage());
		}
	}

}
