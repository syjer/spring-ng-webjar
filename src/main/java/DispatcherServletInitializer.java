import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
    
    @Override
    protected void registerDispatcherServlet(ServletContext servletContext) {
    	
    	
    	//IGNORE THIS TEST :), the creation could be controlled by a system property...
    	Dynamic servlet = servletContext.addServlet("proxy", "org.mitre.dsmiley.httpproxy.ProxyServlet");
    	servlet.setInitParameter("targetUri", "http://www.cdt.ch/");
    	servlet.addMapping("/cdt/*");
    	//
    	
    	
    	super.registerDispatcherServlet(servletContext);
    }
}
