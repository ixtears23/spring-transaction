package junseok.snr.inventory;

import junseok.snr.core.PlayCoreConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(PlayCoreConfiguration.class)
@SpringBootApplication
public class SpringPlayInventoryApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application-core, application-play-inventory");
        SpringApplication.run(SpringPlayInventoryApplication.class, args);
    }

}
