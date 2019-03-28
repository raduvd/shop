package ro.msg.learning.odata;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.msg.learning.odata.core.CoreServlet;
import ro.msg.learning.odata.jpa.JPAServlet;


@Configuration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean odataJPAServlet(JPAServlet servlet) {
        return new ServletRegistrationBean(servlet, "/odata/jpa/*");
    }

    @Bean
    public ServletRegistrationBean odataCoreServlet(CoreServlet servlet) {
        return new ServletRegistrationBean(servlet, "/odata/core/*");
    }
}