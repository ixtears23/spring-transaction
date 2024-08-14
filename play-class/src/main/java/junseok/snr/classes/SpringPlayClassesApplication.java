package junseok.snr.classes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringPlayClassesApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-core, application-play-classes");
        SpringApplication.run(SpringPlayClassesApplication.class, args);
    }

}
