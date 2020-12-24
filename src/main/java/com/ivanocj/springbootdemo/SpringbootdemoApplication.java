package com.ivanocj.springbootdemo;

import com.ivanocj.springbootdemo.model.Customer;
import com.ivanocj.springbootdemo.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.Properties;

@SpringBootApplication
@RestController
@Slf4j
public class SpringbootdemoApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

    @GetMapping("/greet")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name, @RequestHeader(value = "User-Agent") String userAgent) {
        log.info(userAgent);
        repository.save(new Customer(String.format("%s", LocalTime.now()), userAgent));
        return String.format("Hi %s!", name);
    }

    @GetMapping("/")
    Properties properties() {

        return System.getProperties();
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
    }
}
