package ro.msg.learning.odata.core;

import org.apache.olingo.odata2.api.ODataCallback;
import org.apache.olingo.odata2.api.ODataDebugCallback;
import org.apache.olingo.odata2.api.ODataService;
import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.apache.olingo.odata2.api.commons.HttpStatusCodes;
import org.apache.olingo.odata2.api.edm.provider.EdmProvider;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.exception.ODataApplicationException;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataContext;
import org.apache.olingo.odata2.api.processor.ODataErrorCallback;
import org.apache.olingo.odata2.api.processor.ODataErrorContext;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class CoreServiceFactory extends ODataServiceFactory {

    private final EdmProvider edmProvider;

    @Autowired
    public CoreServiceFactory(EdmProvider edmProvider) {
        this.edmProvider = edmProvider;
    }

    @Override
    public ODataService createService(ODataContext ctx) throws ODataException {
        return createODataSingleProcessorService(edmProvider, new CoreProcessor());
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
