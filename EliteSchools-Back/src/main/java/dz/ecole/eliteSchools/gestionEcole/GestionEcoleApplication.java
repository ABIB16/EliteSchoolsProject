package dz.ecole.eliteSchools.gestionEcole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GestionEcoleApplication {

	/*@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(GestionEcoleApplication.class, args);
	}

}
