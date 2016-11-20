package web.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

import web.model.User;
import web.model.UserFactory;

@Path("/users")
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

	@GET
	@Produces(MediaType.APPLICATION_JSON)
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

	public void findOneUserFromDb(User user) {
		// TODO Auto-generated method stub
		
		FindIterable<Document> documentIterator = MongoDaoFactory
				.getDatabase(UserDao.MONGO_DATABASE_NAME)
				.getCollection(UserDao.MONGO_COLLECTION_USERS)
				.find(Filters.eq("email", user.getEmail()));
		
		documentIterator.forEach(new Block<Document>() {

			public void apply(Document document) {
				// TODO Auto-generated method stub
				System.out.println(document);
			}
			
		});
		
	}

	public void updateOneUserToDb(User user) {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MONGO_DATABASE_NAME)
		.getCollection(MONGO_COLLECTION_USERS)
		.updateOne(Filters.eq("email", user.getEmail()), UserFactory.convertPojoToDocument(user));
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MONGO_DATABASE_NAME)
		.getCollection(MONGO_COLLECTION_USERS)
		.deleteMany(new Document());
		
	}

	public void deleteOneUserFromDb(User user) {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MONGO_DATABASE_NAME)
		.getCollection(MONGO_COLLECTION_USERS)
		.deleteOne(UserFactory.convertPojoToDocument(user));
		
	}
}
