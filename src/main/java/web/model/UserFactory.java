package web.model;

import org.bson.Document;
import org.bson.types.ObjectId;

import web.dao.UserDao;

public class UserFactory {
	
	public static String getUserRole(String role){
		System.out.println(role);
		
		if (role !=null) 
			return role;
		else 
			return "GUEST";
		
	}

	public static Document convertPojoToDocument(User user){
			
		Document document = new Document();
		
		document.append(UserDao.MONGO_USERS_EMAIL, user.getEmail());
		document.append(UserDao.MONGO_USERS_PASSWORD, user.getPassword());
		document.append(UserDao.MONGO_USERS_ROLE, user.getRole());
		
		return document;
		
	}
	
	public static User converDocumentToPojo(Document document){
		
		String _id = ((ObjectId) document.get(UserDao.MONGO_COLLECTION_ID)).toString();
		String email = (String) document.get(UserDao.MONGO_USERS_EMAIL);
		String password = (String) document.get(UserDao.MONGO_USERS_PASSWORD);
		String role = (String) document.get(UserDao.MONGO_USERS_ROLE);
		
		return User.getInstance(_id, email, password, role);
		
	}
	
}
