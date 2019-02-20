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
    String home( @PathVariable Long id) {

        return test.test(id).toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TestController.class, args);
    }

}
