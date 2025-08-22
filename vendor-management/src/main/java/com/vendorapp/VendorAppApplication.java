package com.vendorapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VendorAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(VendorAppApplication.class, args);
    }
}
