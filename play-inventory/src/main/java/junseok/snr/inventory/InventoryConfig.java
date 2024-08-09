package junseok.snr.inventory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryConfig {

    @Bean
    public Inventory inventory() {
        return Inventory.builder()
                .id(1L)
                .productId(1L)
                .quantity(100_000)
                .build();
    }
}
