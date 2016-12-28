package web.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import web.dao.DaoFactory;
import web.dao.NoteDao;
import web.model.Note;

@Path("/notes")
public class NoteControllerImpl implements NoteController{

	NoteDao noteDao = DaoFactory
			.getDaoFactory(DaoFactory.MONGO_DATABASE)
			.getNoteDao();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public void addNote(Note note) {
		// TODO Auto-generated method stub
		
		noteDao.insertOneNoteToDb(note);
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> getAllNotes() {
		// TODO Auto-generated method stub
		
		return noteDao.findAll();
		
	}

	
}
