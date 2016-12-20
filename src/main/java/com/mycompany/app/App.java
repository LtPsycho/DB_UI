package com.mycompany.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
@EnableAutoConfiguration

public class App {
    //Spring start-up
    public static void main(String[] args) throws IOException {
        SpringApplication.run(App.class, args);
    }

}



