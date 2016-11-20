package web.dao;

import java.util.ArrayList;
import java.util.List;

import web.model.User;
import web.model.UserImpl;

public class AppDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDao userDao = new MongoDaoFactory().getUserDao();
//		User user = new User("user1", "user1@gmail.com");
		User user = UserImpl.getInstance("user1", "user1@gmail.com");
		
//		userDao.insertOneUserToDb(user);
//		userDao.deleteOneUserFromDb(user);
//		userDao.findOneUserFromDb(user);
		userDao.findAll();
//		userDao.deleteAll();
		
	}

}
