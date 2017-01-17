package web.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

import web.utilities.ConfigurationInfo;

public final class MongoDaoFactory extends DaoFactory{
	
	private final static String MONGO_REMOTE_USER = 
			ConfigurationInfo.getMongoRemoteUser();
	private final static String MONGO_REMOTE_PASSWORD = 
			ConfigurationInfo.getMongoRemotePass();
	private final static String MONGO_REMOTE_ADDRESS = 
			ConfigurationInfo.getMongoRemoteAddr();
	private final static int MONGO_REMOTE_PORT = 
			ConfigurationInfo.getMongoRemotePort();
	private final static String MONGO_REMOTE_DATABASE = 
			ConfigurationInfo.getMongoRemoteDatabase();
	
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
