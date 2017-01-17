package web.model;

import java.security.Principal;

public class User implements Principal{

	private String _id;
	private String email;
	private String password;
	private String role;

	public User() {
		super();
	}

	private User(String _id, String email, String password, String role) {
		super();
		
		this._id = _id;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static User getInstance(String _id, String username, String email, String role) {
		return new User(_id, username, email, role);
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.email;
	}
}
