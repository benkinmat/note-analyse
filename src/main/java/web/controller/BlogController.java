package web.controller;

import java.util.List;

import web.model.Blog;

public interface BlogController {
	
	public void addBlog(Blog blog);
	
	public List<Blog> getAllBlogs();
	
	public List<Blog> getBlogsWithFields(List<String> fields);
	
	public Blog getBlogById(String blogId);
	
	public void updateBlog(Blog blog);
	
	public void deleteBlogById(String blogId);

}
