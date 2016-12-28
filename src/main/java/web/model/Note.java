package web.model;

import java.util.ArrayList;

public class Note {

	private String email;
	private String header;
	private String description;
	private String content;
	private ArrayList<Object> data;
	
	public Note() {
		// TODO Auto-generated constructor stub		
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArrayList<Object> getData() {
		return data;
	}

	public void setdata(ArrayList<Object> data) {
		this.data = data;
	}

	private Note(String email, String header, String description, String content, ArrayList<Object> data) {
		super();
		this.email = email;
		this.header = header;
		this.description = description;
		this.content = content;
		this.data = data;
	}
		
	public static Note getInstance(String email, String header, String description, String content, ArrayList<Object> data) {
		return new Note(email, header, description, content, data);
	}
	
}
