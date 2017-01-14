package web.service;

import java.security.Principal;

import web.model.User;

public class SecurityContext implements javax.ws.rs.core.SecurityContext{
	
	User user;
	String scheme;

	public SecurityContext(User user) {
		super();
		this.user = user;
	}

	public Principal getUserPrincipal() {
		// TODO Auto-generated method stub
		return this.user;
	}

	public boolean isUserInRole(String role) {
		// TODO Auto-generated method stub
		return this.user.getRole().contains(role);
	}

	public boolean isSecure() {
		// TODO Auto-generated method stub
		return "https".equals(this.scheme);
	}

	public String getAuthenticationScheme() {
		// TODO Auto-generated method stub
		return this.scheme;
	}

}
