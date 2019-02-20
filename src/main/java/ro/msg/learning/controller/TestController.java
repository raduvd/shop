package ro.msg.learning.controller;

/**
 * Created by vancer at 2/18/2019
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.service.Test;

@RestController
public class TestController {

    @Autowired
    private Test test;

    @RequestMapping("/test/{id}")
    String home(@PathVariable Long id) {

        //save a Product and get that product, to demonstrate that the JDBC settings are working
        return test.test(id).toString();
    }
}
