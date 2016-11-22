package web.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import web.dao.DaoFactory;
import web.dao.MongoDaoFactory;
import web.dao.UserDao;
import web.model.User;

@Path("/users")
public class UserControllerImp implements UserController{
	
	DaoFactory dao = new MongoDaoFactory();
	UserDao userDao = dao.getUserDao();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addUsers(User user) {
		// TODO Auto-generated method stub
		System.out.println(user.getUsername() + user.getEmail());
		userDao.insertOneUserToDb(user);
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		
		return userDao.findAll();
		
	}
	
	@GET
	@Path("/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUserByEmail(@PathParam(UserDao.MONGO_USERS_EMAIL) String email) {
		// TODO Auto-generated method stub
		
		return userDao.findUserByEmail(email);
		
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
		userDao.updateOneUserToDb(user);
		
	}

	@DELETE
	@Path("/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteUserByEmail(@PathParam(UserDao.MONGO_USERS_EMAIL) String email) {
		// TODO Auto-generated method stub
		
		userDao.deleteOneUserFromDb(email);
		
	}

}
