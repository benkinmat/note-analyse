package web.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;

import web.model.Note;
import web.model.NoteFactory;

public class NoteDaoImpl implements NoteDao{

	public List<Note> findAll() {
		// TODO Auto-generated method stub
		final List<Note> notes = new ArrayList<Note>();
		
		FindIterable<Document> documentIterator = MongoDaoFactory
				.getDatabase(MongoDaoFactory.mongoClientUri.getDatabase())
				.getCollection(NoteDao.MONGO_COLLECTION_NOTES)
				.find();
		
		documentIterator.forEach(new Block<Document>() {
			
			public void apply(Document document) {
				// TODO Auto-generated method stub
				notes.add(NoteFactory.converDocumentToPojo(document));
				System.out.println(document);
			}
			
		});
		
		return notes;
		
	}

	public void insertOneNoteToDb(Note note) {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MongoDaoFactory.mongoClientUri.getDatabase())
		.getCollection(NoteDao.MONGO_COLLECTION_NOTES)
		.insertOne(NoteFactory.convertPojoToDocument(note));
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MongoDaoFactory.mongoClientUri.getDatabase())
		.getCollection(NoteDao.MONGO_COLLECTION_NOTES)
		.deleteMany(new Document());
	}

}
