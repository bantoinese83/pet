package com.pet.pet;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.pet.pet.utils.DynamoDBTableCreator;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories(basePackages = "com.pet.pet.repository")
public class PetApplication implements CommandLineRunner {

	@Autowired
	private AmazonDynamoDB dynamoDB;

	public static void main(String[] args) {
		SpringApplication.run(PetApplication.class, args);
	}

	@Override
	public void run(String... args) {
		DynamoDBTableCreator.createTables(dynamoDB);
	}
}
