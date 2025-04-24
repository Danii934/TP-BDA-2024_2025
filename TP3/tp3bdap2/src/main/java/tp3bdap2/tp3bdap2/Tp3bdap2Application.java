package tp3bdap2.tp3bdap2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tp3bdap2.tp3bdap2.entities.Adherent;
import tp3bdap2.tp3bdap2.repository.AdherentRepository;

@SpringBootApplication
public class Tp3bdap2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp3bdap2Application.class, args);
	}

	@Bean
	CommandLineRunner runner(AdherentRepository repository)
	{
		return args -> {
			
			repository.saveAndFlush(new Adherent(null, "A", "B", 29));
			repository.saveAndFlush(new Adherent(null, "C", "D", 30));
			repository.saveAndFlush(new Adherent(null, "E", "F", 31));
			repository.saveAndFlush(new Adherent(null, "G", "H", 32));

		};
	}
		
}
