package web.controller;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import web.dao.BlogDao;
import web.dao.DaoFactory;
import web.dao.NoteDao;
import web.model.Blog;

@Path("/blogs")
public class BlogControllerImpl implements BlogController{
		
	BlogDao blogDao = DaoFactory
			.getDaoFactory(DaoFactory.MONGO_DATABASE)
			.getBlogDao();
	
	@POST
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public void addBlog(Blog blog) {
		// TODO Auto-generated method stub
		
		System.out.println(blog);
		blogDao.insertOneToDb(blog);
		
	}
	
//	@POST
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	@Produces(MediaType.APPLICATION_JSON)
//	public void addBlog(@FormDataParam("file") InputStream uploadedInputStream,
//			@FormDataParam("file") FormDataContentDisposition fileDetail) {
//		// TODO Auto-generated method stub
//		
//		System.out.println(uploadedInputStream);
////		blogDao.insertOneToDb(blog);
//		
//	}

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

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		
		blogDao.updateOneToDb(blog);
		
	}

	@DELETE
	@Path("{_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteBlogById(@PathParam(NoteDao.MONGO_NOTE_ID) String blogId) {
		// TODO Auto-generated method stub
		
		blogDao.deleteById(blogId);
		
	}

}
