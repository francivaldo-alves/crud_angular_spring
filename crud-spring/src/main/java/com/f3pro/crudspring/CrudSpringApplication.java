package com.f3pro.crudspring;

import com.f3pro.crudspring.model.Course;
import com.f3pro.crudspring.reposotory.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);


	}
	@Bean
	CommandLineRunner initDabase(CourseRepository repository){
		return args ->{
			repository.deleteAll();
			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory("front-end");
			repository.save(c);

		};

	}

}
