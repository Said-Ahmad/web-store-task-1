package com.example.webstoretask1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.example.webstoretask1"
})
public class WebStoreTask1Application {

    public static void main(String[] args) {
        SpringApplication.run(WebStoreTask1Application.class, args);
    }

}
