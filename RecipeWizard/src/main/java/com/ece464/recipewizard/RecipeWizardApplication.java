package com.ece464.recipewizard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class RecipeWizardApplication {
    // TODO need to setup the mongo database
    public static void main(String[] args) {
        SpringApplication.run(RecipeWizardApplication.class, args);
    }

}
