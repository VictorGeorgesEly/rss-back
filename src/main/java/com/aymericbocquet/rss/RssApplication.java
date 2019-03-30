package com.aymericbocquet.rss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RssApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(RssApplication.class, args);
		DatabaseSeeder databaseSeeder = configurableApplicationContext.getBeanFactory().createBean(DatabaseSeeder.class);
		databaseSeeder.seedDatabase();
	}

}
