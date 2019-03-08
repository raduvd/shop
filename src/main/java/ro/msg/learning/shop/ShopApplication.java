package ro.msg.learning.shop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ro.msg.learning.repository.dao.ProductDao;
import ro.msg.learning.repository.daoimpl.ProductDaoImpl;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@ComponentScan(basePackageClasses = {ProductDao.class, ProductDaoImpl.class})
public class ShopApplication {

    public static void main(String[] args) {
        run(ShopApplication.class, args);
    }

}

