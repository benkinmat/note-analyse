package web.service;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import web.model.User;
import web.utilities.ConfigurationInfo;

public final class TokenGenerator {
	private static final String issuer = ConfigurationInfo.getJwtTokenIssuer();
	private static final String role = ConfigurationInfo.getJwtClaimRole();
	private static final long exp = ConfigurationInfo.getJwtTokenExp();
	private static final long leeway = ConfigurationInfo.getJwtLeeWay();
	private static final String sign = ConfigurationInfo.getJwtTokenSign();
	
	public static final String getJwtToken(User user){
		String token = null;
		
		if (user != null){
			try {
				token = JWT.create()
				        .withIssuer(issuer)
				        .withClaim(role, user.getRole())
				        .withExpiresAt(new Date())
				        .sign(Algorithm.HMAC256(sign));
				
				System.out.println(user.getRole());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return token;
	}
	
	public static final boolean isTokenValid(String token){
		try {
			verify(token);
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			
			return false;
		}
	}
	
	public static final DecodedJWT verify(String token) throws NullPointerException, IllegalArgumentException, UnsupportedEncodingException, JWTVerificationException{
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(sign))
				.withIssuer(issuer)
		        .acceptLeeway(leeway)
		        .acceptExpiresAt(exp)
				.build();
		
		return verifier.verify(token);
		
	}
}
