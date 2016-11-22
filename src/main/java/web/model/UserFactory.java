package web.model;

import org.bson.Document;

import web.dao.UserDao;

public class UserFactory {

	public static Document convertPojoToDocument(User user){
			
		Document document = new Document();
		
		document.append(UserDao.MONGO_USERS_USERNAME, user.getUsername());
		document.append(UserDao.MONGO_USERS_EMAIL, user.getEmail());
		
		return document;
		
	}
	
	public static User converDocumentToPojo(Document document){
		
		String username = (String) document.get(UserDao.MONGO_USERS_USERNAME);
		String email = (String) document.get(UserDao.MONGO_USERS_EMAIL);
		
		return User.getInstance(username, email);
		
	}
	
}
