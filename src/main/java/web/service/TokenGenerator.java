package web.service;
import java.io.UnsupportedEncodingException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import web.utilities.Configuration;

public class TokenGenerator {

	public static void main(String[] args) throws IllegalArgumentException, JWTCreationException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		String token = JWT.create()
		        .withIssuer(Configuration.getJwtTokenIssuer())
		        .withSubject(Configuration.getJwtSubject())
		        .withClaim(Configuration.getJwtClaimRole(), "USER")
		        .sign(Algorithm.HMAC256(Configuration.getJwtTokenSign()));
		
//		String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJibG9nIiwiYWRtaW5pc3RyYXRvciI6dHJ1ZSwiaXNzIjoidHVhbmFuaGhvZGllbiJ9.Qn3_SrcVKF2oFs05L15qPtxLbK62kqR4SZzoFJfI0Pk";
		
//		JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret"))
//				.withIssuer(Configuration)
//				.withSubject("blog")
//				.withClaim("administrator", true)
//				.build();
//		
//		DecodedJWT jwt = verifier.verify(token);
		
		System.out.println(token);
		
	}

}
