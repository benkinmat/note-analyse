package web.controller;

import java.util.List;

import web.model.Note;

public interface NoteController {

	public void addNote(Note note);
	
	public List<Note> getAllNotes();
	
	public Note getNoteById(String noteId);
	
	public void deleteNoteById(String noteId);
	
}
