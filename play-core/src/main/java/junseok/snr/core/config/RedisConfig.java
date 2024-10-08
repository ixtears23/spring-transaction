package junseok.snr.core.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"aws", "default"})
@Configuration
public class RedisConfig {

    @Bean
    public RedissonClient redisson() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://clustercfg.spring-transaction.8hqjuq.apn2.cache.amazonaws.com:6379");

        return Redisson.create(config);
    }
}
