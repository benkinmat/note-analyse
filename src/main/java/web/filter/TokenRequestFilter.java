package web.filter;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

import web.model.User;
import web.utilities.Configuration;

public class TokenRequestFilter implements ContainerRequestFilter{
	
	@Context
	SecurityContext securityContext;

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	
	public ContainerRequest filter(ContainerRequest request) {
		// TODO Auto-generated method stub

		String token = request.getHeaderValue(AUTHORIZATION_PROPERTY);
		User user = new User();
		
		try {
			DecodedJWT decoded = verify(token);
			user.setRole(decoded.getClaim(Configuration.getJwtClaimRole()).asString());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
//			throw new WebApplicationException(Status.UNAUTHORIZED);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
//			throw new WebApplicationException(Status.UNAUTHORIZED);
			
		}
		
		request.setSecurityContext(new web.service.SecurityContext(user));
		
		SecurityContext securityContext = request.getSecurityContext();
		System.out.println(securityContext.isUserInRole("ADMIN"));
		
		return request;
		
	}
	
	private final DecodedJWT verify(String token) throws IllegalArgumentException, UnsupportedEncodingException {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(Configuration.getJwtTokenSign()))
				.withIssuer(Configuration.getJwtTokenIssuer())
		        .withSubject(Configuration.getJwtSubject())
				.build();

		return verifier.verify(token);
	}
	
	

}
