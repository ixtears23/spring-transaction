package junseok.snr.classes.reservation;

import junseok.snr.classes.reservation.application.port.in.SaveClassUseCase;
import junseok.snr.core.PlayCoreConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(PlayCoreConfiguration.class)
@SpringBootApplication
public class SpringPlayClassesReservationApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-core, application-play-classes-reservation");
        SpringApplication.run(SpringPlayClassesReservationApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(SaveClassUseCase saveClassUseCase) {
        return args -> saveClassUseCase.create500Classes();
    }


}
