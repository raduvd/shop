package ro.msg.learning.shop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ro.msg.learning.controller.TestController;
import ro.msg.learning.repository.ProductRepository;
import ro.msg.learning.service.Test;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@ComponentScan(basePackageClasses = {ProductRepository.class, TestController.class, Test.class})
@EntityScan(basePackages = {"ro.msg.learning.entity"})
@EnableJpaRepositories(basePackageClasses = ProductRepository.class)
public class ShopApplication {

    public static void main(String[] args) {
        run(ShopApplication.class, args);
    }
}

