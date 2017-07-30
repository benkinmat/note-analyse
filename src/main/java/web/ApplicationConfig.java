package web;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

public class ApplicationConfig extends ResourceConfig{
	
	public ApplicationConfig(){
		register(RolesAllowedDynamicFeature.class);
		
//		final ResourceConfig resourceConfig = new ResourceConfig(HttpSessionProd.class);
//		resourceConfig.register(RolesAllowedDynamicFeature.class);
		
//		register(new AbstractBinder() {
//            @Override
//            protected void configure() {
//                bindFactory(HttpSessionFactory.class).to(HttpSession.class)
//                .proxy(true).proxyForSameScope(false).in(RequestScoped.class);
//            }
//        });
	}

}
