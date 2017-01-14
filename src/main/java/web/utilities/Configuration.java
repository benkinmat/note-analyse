package web.utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Configuration {
	
	private final static Properties props = init();
	
	private Configuration(){
		throw new AssertionError();
	}

	private static Properties init(){
		Properties prop = new Properties();
		String propFileName = "config.properties";
		InputStream inputStream = null;
		
		try {			
			inputStream = Configuration.class.getClassLoader().getResourceAsStream(propFileName);
			
			if(inputStream != null){
				prop.load(inputStream);
			}
			else {
				throw new FileNotFoundException();
			}
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return prop;
	}
	
	public static String getMongoRemoteUser(){
		return props.getProperty("HEROKU_MONGO_REMOTE_USER");
	}
	
	public static String getMongoRemotePass(){
		return props.getProperty("HEROKU_MONGO_REMOTE_PASSWORD");
	}
	
	public static String getMongoRemoteAddr(){
		return props.getProperty("HEROKU_MONGO_REMOTE_ADDRESS");
	}
	
	public static int getMongoRemotePort(){
		return Integer.parseInt(props.getProperty("HEROKU_MONGO_REMOTE_PORT"));
	}
	
	public static String getMongoRemoteDatabase(){
		return props.getProperty("HEROKU_MONGO_REMOTE_DATABASE");
	}
	
	public static String getJwtTokenIssuer(){
		return props.getProperty("JWT_TOKEN_ISSUER");
	}
	
	public static String getJwtTokenSign(){
		return props.getProperty("JWT_TOKEN_SIGN");
	}
	
	public static String getJwtSubject(){
		return props.getProperty("JWT_TOKEN_SUBJECT");
	}
	
	public static String getJwtClaimRole(){
		return props.getProperty("JWT_TOKEN_ROLE");
	}
	
}
