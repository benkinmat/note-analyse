package web;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class ApplicationConfig extends ResourceConfig{
	
	public ApplicationConfig(){
		register(RolesAllowedDynamicFeature.class);
	}

}
