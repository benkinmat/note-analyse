package web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import web.model.User;
import web.utilities.Configuration;

@Provider
@PreMatching
public class TokenRequestFilter implements ContainerRequestFilter{

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	
	private final DecodedJWT verify(String token) throws IllegalArgumentException, UnsupportedEncodingException {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(Configuration.getJwtTokenSign()))
				.withIssuer(Configuration.getJwtTokenIssuer())
		        .withSubject(Configuration.getJwtSubject())
				.build();

		return verifier.verify(token);
	}

	public void filter(ContainerRequestContext requestContext) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("hello");
		String token = requestContext.getHeaderString(AUTHORIZATION_PROPERTY);
		User user = new User();
		
		try {
			DecodedJWT decoded = verify(token);
			user.setRole(decoded.getClaim(Configuration.getJwtClaimRole()).asString());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
//					throw new WebApplicationException(Status.UNAUTHORIZED);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
//					throw new WebApplicationException(Status.UNAUTHORIZED);
			
		}
		
		requestContext.setSecurityContext(new web.service.SecurityContext(user));
		
		SecurityContext securityContext = requestContext.getSecurityContext();
		System.out.println(securityContext.isUserInRole("ADMIN"));
		
	}

}
