package web.model;

public class UserImpl implements User{

	private String username;
	private String email;
	
	private UserImpl(String username, String email) {
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

	public static User getInstance(String username, String email) {
		return new UserImpl(username, email);
	}
	
}
