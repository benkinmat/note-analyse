package web.provider;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.glassfish.hk2.api.Factory;

public class HttpSessionProd implements Factory<HttpSession> {
	 
    private final HttpServletRequest request;
 
    @Inject
    public HttpSessionProd(HttpServletRequest request) {
        this.request = request;
    }

	public HttpSession provide() {
		// TODO Auto-generated method stub
		return this.request.getSession();
	}

	public void dispose(HttpSession instance) {
		// TODO Auto-generated method stub
		
	}

}