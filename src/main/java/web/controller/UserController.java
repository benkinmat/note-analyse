package web.controller;

import java.util.List;

import web.model.User;

public interface UserController{
	
	public void addUsers(User user);	
//	public void insertManyUsersToDb(List<User> users);
	
	public List<User> getUserByEmail(String email);
	public List<User> getAllUsers();
	
	public void updateUser(User user);
//	public void updateManyUserToDb(List<User> users);
	
//	public void deleteAll();
	public void deleteUserByEmail(String email);

}
