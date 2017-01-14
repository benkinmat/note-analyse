package web.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import web.utilities.Configuration;

public final class MongoDaoFactory extends DaoFactory{
	
	private final static String MONGO_REMOTE_USER = 
			Configuration.getMongoRemoteUser();
	private final static String MONGO_REMOTE_PASSWORD = 
			Configuration.getMongoRemotePass();
	private final static String MONGO_REMOTE_ADDRESS = 
			Configuration.getMongoRemoteAddr();
	private final static int MONGO_REMOTE_PORT = 
			Configuration.getMongoRemotePort();
	private final static String MONGO_REMOTE_DATABASE = 
			Configuration.getMongoRemoteDatabase();
	
	//mongodb://user:pass@host:port/db
	public final static MongoClientURI mongoClientUri = 
			new MongoClientURI("mongodb://" + MONGO_REMOTE_USER 
					+ ":" + MONGO_REMOTE_PASSWORD 
					+ "@" + MONGO_REMOTE_ADDRESS 
					+ ":" + MONGO_REMOTE_PORT 
					+ "/" + MONGO_REMOTE_DATABASE);
	public static MongoClient mongoClient = new MongoClient(mongoClientUri);
	
	@Override
	public UserDao getUserDao() {
		// TODO Auto-generated method stub
		return new UserDaoImpl();
	}
	
	@Override
	public NoteDao getNoteDao(){
		return new NoteDaoImpl();
	}
	
	@Override
	public BlogDao getBlogDao(){
		return new BlogDaoImpl();
	}
		
	public static MongoDatabase getDatabase(String databaseName){
		
		return mongoClient.getDatabase(databaseName);
		
	}
	
}
