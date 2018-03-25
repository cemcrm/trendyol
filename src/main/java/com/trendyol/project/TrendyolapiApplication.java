package com.trendyol.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class TrendyolapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrendyolapiApplication.class, args);
	}
}
