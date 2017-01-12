package web.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Filters;

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

	public void deleteAll() {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MongoDaoFactory.mongoClientUri.getDatabase())
		.getCollection(NoteDao.MONGO_COLLECTION_NOTES)
		.deleteMany(new Document());
	}

	public Note findById(String id) {
		// TODO Auto-generated method stub
		
		Document noteDoc = MongoDaoFactory
				.getDatabase(MongoDaoFactory.mongoClientUri.getDatabase())
				.getCollection(NoteDao.MONGO_COLLECTION_NOTES)
				.find(Filters.eq(NoteDao.MONGO_NOTE_ID, new ObjectId(id)))
				.first();
		
		Note note = (noteDoc != null) ? NoteFactory.converDocumentToPojo(noteDoc) : null;
		
		return note;
	}

	public void insertOneToDb(Note note) {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MongoDaoFactory.mongoClientUri.getDatabase())
		.getCollection(NoteDao.MONGO_COLLECTION_NOTES)
		.insertOne(NoteFactory.convertPojoToDocument(note));
		
	}

	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MongoDaoFactory.mongoClientUri.getDatabase())
		.getCollection(NoteDao.MONGO_COLLECTION_NOTES)
		.deleteOne(Filters.eq(NoteDao.MONGO_NOTE_ID, new ObjectId(id)));
		
	}

	public void updateOneToDb(Note note) {
		// TODO Auto-generated method stub
		
		MongoDaoFactory
		.getDatabase(MongoDaoFactory.mongoClientUri.getDatabase())
		.getCollection(NoteDao.MONGO_COLLECTION_NOTES)
		.updateOne(Filters.eq(NoteDao.MONGO_NOTE_ID, new ObjectId(note.get_id())), new Document("$set", NoteFactory.convertPojoToDocument(note)));
		
	}

}
