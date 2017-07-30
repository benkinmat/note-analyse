package web.controller;

import javax.annotation.security.PermitAll;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import web.dao.DaoFactory;
import web.dao.UserDao;
import web.model.User;
import web.service.Authenticate;

@PermitAll
@Path("/authenticate")
public class AuthenticateController{
	
//	@Inject HttpSession httpSession;
	
	UserDao userDao = DaoFactory
			.getDaoFactory(DaoFactory.MONGO_DATABASE)
			.getUserDao();

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public void requestJwsToken(@FormParam("email") String email, @FormParam("password") String password) throws AddressException, MessagingException{
		
		User user = userDao.authenticate(email, password);
		
		Authenticate.sendJwsToken(user);
		
	}
	
}
