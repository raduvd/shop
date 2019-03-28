package ro.msg.learning.odata.core;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.core.servlet.ODataServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class CoreServlet extends ODataServlet {

    private final transient ApplicationContext context;

    @Autowired
    public CoreServlet(ApplicationContext context) {
        this.context = context;
    }

    @Override
    protected ODataServiceFactory getServiceFactory(HttpServletRequest request) {
        return context.getBean(CoreServiceFactory.class);
    }
}