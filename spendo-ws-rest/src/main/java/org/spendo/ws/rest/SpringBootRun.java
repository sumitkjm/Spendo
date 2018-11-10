package org.spendo.ws.rest;

import org.springframework.boot.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by skumar6 on 11/10/18.
 */
@RestController
@EnableAutoConfiguration
public class SpringBootRun extends SpringBootServletInitializer {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }


    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringBootRun.class);
    }

}
