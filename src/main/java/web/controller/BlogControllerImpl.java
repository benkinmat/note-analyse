package web.controller;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import web.dao.BlogDao;
import web.dao.DaoFactory;
import web.dao.NoteDao;
import web.model.Blog;

@PermitAll
@Path("/blogs")
public class BlogControllerImpl implements BlogController{
		
	BlogDao blogDao = DaoFactory
			.getDaoFactory(DaoFactory.MONGO_DATABASE)
			.getBlogDao();
	
	@RolesAllowed("ADMIN")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addBlog(Blog blog) {
		// TODO Auto-generated method stub
		
		blogDao.insertOneToDb(blog);
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		
		return blogDao.findAll();
		
	}

	@GET
	@Path("{_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Blog getBlogById(@PathParam(NoteDao.MONGO_NOTE_ID) String blogId) {
		// TODO Auto-generated method stub
		
		return blogDao.findById(blogId);
		
	}

	@RolesAllowed("ADMIN")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		
		blogDao.updateOneToDb(blog);
		
	}

	@RolesAllowed("ADMIN")
	@DELETE
	@Path("{_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteBlogById(@PathParam(NoteDao.MONGO_NOTE_ID) String blogId) {
		// TODO Auto-generated method stub
		
		blogDao.deleteById(blogId);
		
	}

}
