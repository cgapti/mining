package com.mining.service;

import com.mining.exception.MiningException;
import com.mining.model.JSON.UserInfo;

public interface MailService {
	void sendEmail(UserInfo userInfo) throws MiningException;
}
