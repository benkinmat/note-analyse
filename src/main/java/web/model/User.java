package web.model;

import java.security.Principal;

public class User implements Principal{

	private String username;
	private String email;
	private String password;
	private String role;

	public User() {
		super();
	}

	private User(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public static User getInstance(String username, String email) {
		return new User(username, email);
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.username + "@" + this.email;
	}
}
