package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("Reading camions records...");
		System.out.printf("Immatric");
		jdbcTemplate.query("SELECT NOIMMATRIC FROM camion", (rs)-> { //Ta capté tu tej ça, pour faire une query t'apl jdbc et zé barti (aucune id de comment t'implémente ça avec un ORM)
			System.out.printf(rs.getString("NOIMMATRIC"));
		});
	}

}
