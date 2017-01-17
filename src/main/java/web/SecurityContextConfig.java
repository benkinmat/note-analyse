package web;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import web.model.User;

public class SecurityContextConfig implements SecurityContext{
	
	User user;
	String scheme;

	public SecurityContextConfig(User user) {
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
