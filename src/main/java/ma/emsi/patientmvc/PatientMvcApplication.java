package ma.emsi.patientmvc;

import ma.emsi.patientmvc.entities.Patient;
import ma.emsi.patientmvc.repositories.PatientRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;

import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }
    @Bean //Pour que ça s'execute au démarrage
    CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
        return args -> {
            patientRepository.save(new Patient(null, "Ikram", new Date(), false, 12));
            patientRepository.save(new Patient(null, "Hanane", new Date(), true, 20));
            patientRepository.save(new Patient(null, "Zaki", new Date(), false, 50));
            patientRepository.save(new Patient(null, "Rayane", new Date(), true, 90));
            patientRepository.findAll().forEach(
                    p -> {
                        System.out.println(p.getNom());
                    }
            );

        };
    }
}
