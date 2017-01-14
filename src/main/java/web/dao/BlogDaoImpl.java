package web.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

import web.model.Blog;
import web.model.BlogFactory;

public class BlogDaoImpl implements BlogDao {

	public void insertOneToDb(Blog blog) {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MongoDaoFactory.mongoClientUri.getDatabase())
		.getCollection(BlogDao.MONGO_COLLECTION_BLOGS)
		.insertOne(BlogFactory.convertPojoToDocument(blog));
		
	}

	public List<Blog> findAll() {
		// TODO Auto-generated method stub
		
		final List<Blog> blogs = new ArrayList<Blog>();
		
		FindIterable<Document> documentIterator = MongoDaoFactory
				.getDatabase(MongoDaoFactory.mongoClientUri.getDatabase())
				.getCollection(BlogDao.MONGO_COLLECTION_BLOGS)
				.find();
		
		documentIterator.forEach(new Block<Document>() {
			
			public void apply(Document document) {
				// TODO Auto-generated method stub
				blogs.add(BlogFactory.converDocumentToPojo(document));
			}
			
		});
		
		return blogs;
	}

	public Blog findById(String id) {
		// TODO Auto-generated method stub
		
		Document blogDoc =  MongoDaoFactory
		.getDatabase(MongoDaoFactory.mongoClientUri.getDatabase())
		.getCollection(BlogDao.MONGO_COLLECTION_BLOGS)
		.find(Filters.eq(BlogDao.MONGO_BLOG_ID, new ObjectId(id)))
		.first();
		
		Blog blog = (blogDoc != null) ? BlogFactory.converDocumentToPojo(blogDoc) : null;
		
		return blog;
		
	}

	public void updateOneToDb(Blog blog) {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MongoDaoFactory.mongoClientUri.getDatabase())
		.getCollection(BlogDao.MONGO_COLLECTION_BLOGS)
		.updateOne(Filters.eq(BlogDao.MONGO_BLOG_ID, new ObjectId(blog.get_id())), new Document("$set", BlogFactory.convertPojoToDocument(blog)));
		
	}

	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MongoDaoFactory.mongoClientUri.getDatabase())
		.getCollection(BlogDao.MONGO_COLLECTION_BLOGS)
		.deleteOne(Filters.eq(BlogDao.MONGO_BLOG_ID, new ObjectId(id)));
		
	}

}
