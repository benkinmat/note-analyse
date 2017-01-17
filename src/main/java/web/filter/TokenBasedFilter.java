package web.filter;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import com.auth0.jwt.interfaces.DecodedJWT;

import web.model.User;
import web.model.UserFactory;
import web.service.TokenGenerator;
import web.utilities.ConfigurationInfo;

@Provider
@PreMatching
public class TokenBasedFilter implements ContainerRequestFilter{

	private static final String AUTHORIZATION_PROPERTY = "Token";

	public void filter(ContainerRequestContext requestContext) throws UnsupportedEncodingException{
		// TODO Auto-generated method stub

		String token = requestContext.getHeaderString(AUTHORIZATION_PROPERTY);
		
		User user = new User();
		
		if (!TokenGenerator.isTokenValid(token)){
			token = TokenGenerator.getJwtToken(user);
		}
		
		DecodedJWT decoded = TokenGenerator.verify(token);
		
		String role = UserFactory.getUserRole(decoded.getClaim(ConfigurationInfo.getJwtClaimRole()).asString());
		
		user.setRole(role);
		
		requestContext.setSecurityContext(new web.SecurityContextConfig(user));
		
	}

}
