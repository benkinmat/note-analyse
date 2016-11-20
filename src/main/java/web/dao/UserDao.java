package web.dao;

import java.util.List;

import web.model.User;

public interface UserDao {
	public static final String MONGO_DATABASE_NAME = "note";
	public static final String MONGO_COLLECTION_USERS = "users";

	public void insertOneUserToDb(User user);	
	public void insertManyUsersToDb(List<User> users);
	
	public List<User> findAll();	
	public void findOneUserFromDb(User user);
	
	public void updateOneUserToDb(User user);
//	public void updateManyUserToDb(List<User> users);
	
	public void deleteAll();
	public void deleteOneUserFromDb(User users);
	
}
