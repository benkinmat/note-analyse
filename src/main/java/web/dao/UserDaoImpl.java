package web.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

import web.model.User;
import web.model.UserFactory;

public class UserDaoImpl implements UserDao{

	public void insertOneUserToDb(User user) {
		// TODO Auto-generated method stub
		
		
		MongoDaoFactory
		.getDatabase(UserDao.MONGO_DATABASE_NAME)
		.getCollection(UserDao.MONGO_COLLECTION_USERS)
		.insertOne(UserFactory.convertPojoToDocument(user));
		
	}

	public void insertManyUsersToDb(List<User> users) {
		// TODO Auto-generated method stub
		
		List<Document> documents = new ArrayList<Document>();
		
		for (User user : users) {
			documents.add(UserFactory.convertPojoToDocument(user));
		}
		
		MongoDaoFactory
		.getDatabase(UserDao.MONGO_DATABASE_NAME)
		.getCollection(UserDao.MONGO_COLLECTION_USERS)
		.insertMany(documents);
		
	}
	
	public List<User> findAll() {
		// TODO Auto-generated method stub
		final List<User> users = new ArrayList<User>();
		
		FindIterable<Document> documentIterator = MongoDaoFactory
				.getDatabase(UserDao.MONGO_DATABASE_NAME)
				.getCollection(UserDao.MONGO_COLLECTION_USERS)
				.find();
		
		documentIterator.forEach(new Block<Document>() {
			
			public void apply(Document document) {
				// TODO Auto-generated method stub
				users.add(UserFactory.converDocumentToPojo(document));
				System.out.println(document);
			}
			
		});
		
		return users;
		
	}

	public List<User> findUserByEmail(String email) {
		// TODO Auto-generated method stub
		
		final List<User> users = new ArrayList<User>();
		
		FindIterable<Document> documentIterator = MongoDaoFactory
				.getDatabase(UserDao.MONGO_DATABASE_NAME)
				.getCollection(UserDao.MONGO_COLLECTION_USERS)
				.find(Filters.eq(UserDao.MONGO_USERS_EMAIL, email));
		
		documentIterator.forEach(new Block<Document>() {

			public void apply(Document document) {
				// TODO Auto-generated method stub
				users.add(UserFactory.converDocumentToPojo(document));
				System.out.println(document);
			}
			
		});
		
		return users;
		
	}

	public void updateOneUserToDb(User user) {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MONGO_DATABASE_NAME)
		.getCollection(MONGO_COLLECTION_USERS)
		.updateOne(Filters.eq(UserDao.MONGO_USERS_EMAIL, user.getEmail()), new Document("$set", UserFactory.convertPojoToDocument(user)));
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MONGO_DATABASE_NAME)
		.getCollection(MONGO_COLLECTION_USERS)
		.deleteMany(new Document());
		
	}

	public void deleteOneUserFromDb(String email) {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MONGO_DATABASE_NAME)
		.getCollection(MONGO_COLLECTION_USERS)
		.deleteOne(new Document(UserDao.MONGO_USERS_EMAIL, email));
		
	}
}
