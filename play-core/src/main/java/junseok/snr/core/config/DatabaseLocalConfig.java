package junseok.snr.core.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import junseok.snr.core.secret.SecretManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.util.Map;

@Profile("local")
@RequiredArgsConstructor
@Configuration
public class DatabaseLocalConfig {
    private final SecretManagerService secretManagerService;
    @Value("${datasource.url}")
    private String jdbcUrl;

    @Bean
    public DataSource dataSource() {

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(jdbcUrl);
        config.setUsername("user");
        config.setPassword("password");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setMinimumIdle(5);
        config.setMaximumPoolSize(10);
        config.setIdleTimeout(30000);
        config.setMaxLifetime(1800000);
        config.setConnectionTimeout(30000);
        config.setConnectionTestQuery("SELECT 1");
        config.setPoolName("HikariCP");
        config.setAutoCommit(true);
        config.setAllowPoolSuspension(false);
        config.setReadOnly(false);
        config.setValidationTimeout(5000);
        config.setLeakDetectionThreshold(2000);

        return new HikariDataSource(config);
    }
}
