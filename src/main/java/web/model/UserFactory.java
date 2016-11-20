package web.model;

import org.bson.Document;

public class UserFactory {

	public static Document convertPojoToDocument(User user){
			
		Document document = new Document();
		
		document.append("name", user.getUsername());
		document.append("email", user.getEmail());
		
		return document;
		
	}
	
	public static User converDocumentToPojo(Document document){
		
		String username = (String) document.get("username");
		String email = (String) document.get("email");
		
		return UserImpl.getInstance(username, email);
		
	}
	
}
