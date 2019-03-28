package ro.msg.learning.odata.jpa;

import org.apache.olingo.odata2.api.ODataCallback;
import org.apache.olingo.odata2.api.ODataDebugCallback;
import org.apache.olingo.odata2.api.commons.HttpStatusCodes;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.exception.ODataApplicationException;
import org.apache.olingo.odata2.api.processor.ODataErrorCallback;
import org.apache.olingo.odata2.api.processor.ODataErrorContext;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class JpaServiceFactory extends ODataJPAServiceFactory {

    private final LocalContainerEntityManagerFactoryBean factory;

    @Autowired
    public JpaServiceFactory(LocalContainerEntityManagerFactoryBean factory) {

        this.factory = factory;
    }

    @Override
    public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {

        ODataJPAContext context = this.getODataJPAContext();
        context.setEntityManagerFactory(factory.getObject());
        context.setPersistenceUnitName("local");
        context.setJPAEdmExtension(new CustomJPAEdmExtension());
        return context;
    }


    @Override
    @SuppressWarnings("unchecked")
    public <T extends ODataCallback> T getCallback(Class<T> callbackInterface) {

        return (T) (callbackInterface.isAssignableFrom(ScenarioErrorCallback.class) ? new ScenarioErrorCallback()
                : callbackInterface.isAssignableFrom(ODataDebugCallback.class) ? new ScenarioDebugCallback()
                : super.getCallback(callbackInterface));
    }

    private final class ScenarioDebugCallback implements ODataDebugCallback {

        @Override
        public boolean isDebugEnabled() {
            return true;
        }
    }

    private class ScenarioErrorCallback implements ODataErrorCallback {

        @Override
        public ODataResponse handleError(final ODataErrorContext context) throws ODataApplicationException {
            if (context.getHttpStatus() == HttpStatusCodes.INTERNAL_SERVER_ERROR) {
                context.getException().printStackTrace();
            }
            return EntityProvider.writeErrorDocument(context);
        }
    }
}