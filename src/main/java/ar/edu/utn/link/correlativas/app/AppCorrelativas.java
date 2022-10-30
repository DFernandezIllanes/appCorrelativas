package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppCorrelativas {

    /*@Autowired
    private RepoMateria repo;
*/
    public static void main(String[] args) {
        SpringApplication.run(AppCorrelativas.class, args);
    }

    @Bean
    public CommandLineRunner ejemplo(RepoMateria repo){
        return (cosas) -> {

            repo.save(new Materia("SO"));
            repo.save(new Materia("DDS"));
            repo.save(new Materia("Algo"));
            repo.save(new Materia("Analisis"));
            repo.save(new Materia("Sintaxis"));
        };
    }
}
