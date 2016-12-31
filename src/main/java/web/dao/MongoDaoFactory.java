package web.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public final class MongoDaoFactory extends DaoFactory{
	private final static String MONGO_REMOTE_USER = "root";
	private final static String MONGO_REMOTE_PASSWORD = "*Root123#";
	private final static String MONGO_REMOTE_ADDRESS = "ds149278.mlab.com";
	private final static int MONGO_REMOTE_PORT = 49278;
	private final static String MONGO_REMOTE_DATABASE = "heroku_r047cz0c";
	
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
		
	public static MongoDatabase getDatabase(String databaseName){
		
		return mongoClient.getDatabase(databaseName);
		
	}
	
}
