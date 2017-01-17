package web.dao;

import java.util.List;

import web.model.User;

public interface UserDao {
	public static final String MONGO_COLLECTION_ID = "_id";
	public static final String MONGO_COLLECTION_USERS = "users";
	public static final String MONGO_USERS_EMAIL = "email";
	public static final String MONGO_USERS_PASSWORD = "password";
	public static final String MONGO_USERS_ROLE = "role";

	public void insertOneUserToDb(User user);	
	public void insertManyUsersToDb(List<User> users);
	
	public List<User> findAll();	
	public List<User> findUserByEmail(String email);
	
	public void updateOneUserToDb(User user);
//	public void updateManyUserToDb(List<User> users);
	
	public void deleteAll();
	public void deleteOneUserFromDb(String email);
	
	public User authenticate(String email, String password);
	
}
