package web.dao;

import java.util.List;

import web.model.Note;

public interface NoteDao {
	public static final String MONGO_COLLECTION_NOTES = "notes";
	public static final String MONGO_NOTE_ID = "_id";
	public static final String MONGO_NOTE_EMAIL = "email";
	public static final String MONGO_NOTE_HEADER = "header";
	public static final String MONGO_NOTE_DESCRIPTION = "description";
	public static final String MONGO_NOTE_CONTENT = "content";
	public static final String MONGO_NOTE_DATA = "data";

	public void insertOneToDb(Note note);	
//	public void insertManyUsersToDb(List<User> users);
	
	public List<Note> findAll();	
	public Note findById(String id);
	
	public void updateOneToDb(Note note);
//	public void updateManyUserToDb(List<User> users);
//	
	public void deleteAll();
	public void deleteById(String id);

}
