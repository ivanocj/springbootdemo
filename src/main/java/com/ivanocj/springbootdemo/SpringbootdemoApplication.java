package com.ivanocj.springbootdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Properties;

@SpringBootApplication
@RestController
@Slf4j
public class SpringbootdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

    @GetMapping("/greet")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name, @RequestHeader(value = "User-Agent") String userAgent) {
        log.info(userAgent);
        return String.format("Hi %s!", name);
    }

    @GetMapping("/")
    Properties properties() {

        return System.getProperties();
    }
}
