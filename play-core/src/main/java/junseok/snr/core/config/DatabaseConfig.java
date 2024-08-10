package junseok.snr.core.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import junseok.snr.core.secret.SecretManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Map;

@RequiredArgsConstructor
@Configuration
public class DatabaseConfig {
    private final SecretManagerService secretManagerService;
    @Value("${spring.profiles.active}")
    private String springActiveProfile;

    @Bean
    public DataSource dataSource() {
        String dbSecretName = "rds!db-ecd1f9b7-3d59-435c-b631-aa6522de891f";
        String defaultSecretName = "spring-transaction";
        Map<String, String> dbSecretMap = secretManagerService.getSecret(dbSecretName);
        Map<String, String> defaultSecretMap = secretManagerService.getSecret(defaultSecretName);

        String url = defaultSecretMap.get("url");

        if ("default".equals(springActiveProfile)) {
            url = "jdbc:mysql://localhost:3306";
        }

        String username = dbSecretMap.get("username");
        String password = dbSecretMap.get("password");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url + "/testdb?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false&allowPublicKeyRetrieval=true");
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setMinimumIdle(1);
        config.setMaximumPoolSize(200);
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
