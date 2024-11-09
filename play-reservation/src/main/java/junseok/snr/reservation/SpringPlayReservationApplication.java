package junseok.snr.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringPlayReservationApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-core, application-play-reservation");
        SpringApplication.run(SpringPlayReservationApplication.class, args);
    }

}
