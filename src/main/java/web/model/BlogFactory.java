package web.model;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.Document;
import org.bson.types.ObjectId;

import web.dao.BlogDao;
import web.service.DateConvertion;

public class BlogFactory {

public static Document convertPojoToDocument(Blog blog){
		
		Document document = new Document();
		
		document.append(BlogDao.MONGO_BLOG_CATEGORY, blog.getCategory());
		document.append(BlogDao.MONGO_BLOG_PROMOTEPIC, blog.getPromotepic());
		document.append(BlogDao.MONGO_BLOG_AUTHOR, blog.getAuthor());
		document.append(BlogDao.MONGO_BLOG_HEADER, blog.getHeader());
		document.append(BlogDao.MONGO_BLOG_DESCRIPTION, blog.getDescription());
		document.append(BlogDao.MONGO_BLOG_CONTENT, blog.getContent());
		document.append(BlogDao.MONGO_BLOG_DATE, blog.getDate());
		
		return document;
		
	}
	
	public static Blog converDocumentToPojo(Document document){
		
		String _id = ((ObjectId) document.get(BlogDao.MONGO_BLOG_ID)).toString();
		String category = (String) document.get(BlogDao.MONGO_BLOG_AUTHOR);
		String promotepic = (String) document.get(BlogDao.MONGO_BLOG_PROMOTEPIC);
		String author = (String) document.get(BlogDao.MONGO_BLOG_AUTHOR);
		String header = (String) document.get(BlogDao.MONGO_BLOG_HEADER);
		String description = (String) document.get(BlogDao.MONGO_BLOG_DESCRIPTION);
		String content = (String) document.get(BlogDao.MONGO_BLOG_CONTENT);
		Date date = (Date) document.get(BlogDao.MONGO_BLOG_DATE);
//		Date date = DateConvertion.serialize((Date) document.get(BlogDao.MONGO_BLOG_DATE));
		
		return Blog.getInstance(_id, category, promotepic, author, header, description, content, date);
		
	}
	
}
