package junseok.snr.order;

import junseok.snr.core.PlayCoreConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(PlayCoreConfiguration.class)
@SpringBootApplication
public class SpringPlayOrderApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-core, application-play-order");
        SpringApplication.run(SpringPlayOrderApplication.class, args);
    }

}
