package ro.msg.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContext implements ApplicationContextAware {

    @Autowired
    private static ApplicationContext context;

    public void setApplicationContext(ApplicationContext context) {
        SpringApplicationContext.context = context;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }
}