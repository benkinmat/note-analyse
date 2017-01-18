package web.dao;

import java.util.List;

import web.model.Blog;

public interface BlogDao {
	
	public static final String MONGO_COLLECTION_BLOGS = "blogs";
	public static final String MONGO_BLOG_ID = "_id";
	public static final String MONGO_BLOG_CATEGORY = "category";
	public static final String MONGO_BLOG_PROMOTEPIC = "promotepic";
	public static final String MONGO_BLOG_AUTHOR = "author";
	public static final String MONGO_BLOG_HEADER = "header";
	public static final String MONGO_BLOG_DESCRIPTION = "description";
	public static final String MONGO_BLOG_CONTENT = "content";
	public static final String MONGO_BLOG_DATE = "date";

	public void insertOneToDb(Blog blog);	
//	public void insertManyToDb(List<User> users);
	
	public List<Blog> findAll();	
	public List<Blog> findAllWithFields(List<String> fields);
	public Blog findById(String id);
	
	public void updateOneToDb(Blog blog);
//	public void updateManyToDb(List<User> users);
//	
//	public void deleteAll();
	public void deleteById(String id);

}
