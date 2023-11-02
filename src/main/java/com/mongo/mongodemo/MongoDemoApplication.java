package com.mongo.mongodemo;

import com.mongo.mongodemo.Entity.Category;
import com.mongo.mongodemo.Entity.Product;
import com.mongo.mongodemo.Repository.CategoryRepository;
import com.mongo.mongodemo.Repository.ProductRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition
public class MongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(
			ProductRepository repository,
			CategoryRepository categoryRepository){
		return args -> {

			var category = Category.builder()
					.name("Category 1")
					.description("Category The First")
					.build();

			var category2 = Category.builder()
					.name("Category 2")
					.description("Category The Second")
					.build();
			categoryRepository.insert(category);
			categoryRepository.insert(category2);
			var product = Product.builder()
					.name("iPhone")
					.description("Smart Phone")
					.category(category)
					.build();
			repository.insert(product);
		};
	}

}
