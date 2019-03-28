package ro.msg.learning.odata.jpa;


import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmExtension;
import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmSchemaView;

import java.io.InputStream;

public class CustomJPAEdmExtension implements JPAEdmExtension {

    @Override
    public void extendWithOperation(JPAEdmSchemaView jpaEdmSchemaView) {

        //Not implemented right now
        //Here we can add function imports
    }

    @Override
    public void extendJPAEdmSchema(JPAEdmSchemaView jpaEdmSchemaView) {

        //Not implemented right now
    }

    @Override
    public InputStream getJPAEdmMappingModelStream() {

        return JPAEdmExtension.class.getClassLoader().getResourceAsStream("odataJpaModel.xml");
    }
}