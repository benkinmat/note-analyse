package web.model;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

import web.dao.NoteDao;

public class NoteFactory {

	public static Document convertPojoToDocument(Note note){
		
		Document document = new Document();
		
		document.append(NoteDao.MONGO_NOTE_EMAIL, note.getEmail());
		document.append(NoteDao.MONGO_NOTE_HEADER, note.getHeader());
		document.append(NoteDao.MONGO_NOTE_DESCRIPTION, note.getDescription());
		document.append(NoteDao.MONGO_NOTE_CONTENT, note.getContent());
		document.append(NoteDao.MONGO_NOTE_DATA, note.getData());
		
		return document;
		
	}
	
	@SuppressWarnings("unchecked")
	public static Note converDocumentToPojo(Document document){
		
		String _id = ((ObjectId) document.get(NoteDao.MONGO_NOTE_ID)).toString();
		String email = (String) document.get(NoteDao.MONGO_NOTE_EMAIL);
		String header = (String) document.get(NoteDao.MONGO_NOTE_HEADER);
		String description = (String) document.get(NoteDao.MONGO_NOTE_DESCRIPTION);
		String content = (String) document.get(NoteDao.MONGO_NOTE_CONTENT);
		ArrayList<Object> data = (ArrayList<Object>) document.get(NoteDao.MONGO_NOTE_DATA);
		
		return Note.getInstance(_id, email, header, description, content, data);
		
	}

}
