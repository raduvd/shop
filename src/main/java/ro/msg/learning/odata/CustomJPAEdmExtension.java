package ro.msg.learning.odata;


import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmExtension;
import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmSchemaView;

import java.io.InputStream;

public class CustomJPAEdmExtension implements JPAEdmExtension {

    @Override
    public void extendWithOperation(JPAEdmSchemaView jpaEdmSchemaView) {
    }

    @Override
    public void extendJPAEdmSchema(JPAEdmSchemaView jpaEdmSchemaView) {
    }

    @Override
    public InputStream getJPAEdmMappingModelStream() {

        final InputStream resourceAsStream = JPAEdmExtension.class.getClassLoader().getResourceAsStream("odataJpaModel.xml");
        return resourceAsStream;

        /*ClassPathResource classPathResource = new ClassPathResource("odataJpaModel.xml");
        InputStream inputStream = null;
        try {
            inputStream = classPathResource.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputStream;*/
    }
}