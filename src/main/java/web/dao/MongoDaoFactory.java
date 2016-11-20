package web.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public final class MongoDaoFactory extends DaoFactory{
	
	public static MongoClient mongoClient = new MongoClient();
	
	@Override
	public UserDao getUserDao() {
		// TODO Auto-generated method stub
		return new UserDaoImpl();
	}
		
	public static MongoDatabase getDatabase(String databaseName){
		
		return mongoClient.getDatabase(databaseName);
		
	}
	
}
