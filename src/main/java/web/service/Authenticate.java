package web.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import web.model.User;

public final class Authenticate {

	public final static void sendJwsToken(User user) throws AddressException, MessagingException{
		
		if (user != null){
			//Generate jwt token
			String token = TokenGenerator.getJwtToken(user);
			
			//Sending email
			EmailExchange.sendEmail(user.getEmail(), token);
		}
	}
	
}
