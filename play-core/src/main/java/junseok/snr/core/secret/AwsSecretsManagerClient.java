package junseok.snr.core.secret;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import java.util.Map;

@Component
@Slf4j
public class AwsSecretsManagerClient implements SecretManagerService {
    private static final String REGION = "ap-northeast-2";
    private static final String PROFILE_NAME = "personal";
    private final SecretsManagerClient client;

    public AwsSecretsManagerClient() {
        this.client = SecretsManagerClient.builder()
                .region(Region.of(REGION))
                .credentialsProvider(ProfileCredentialsProvider.create(PROFILE_NAME))
                .build();
    }

    @Override
    public Map<String, String> getSecret(String secretName) {
        GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
                .secretId(secretName)
                .build();

        GetSecretValueResponse getSecretValueResponse;
        try {
            getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
        } catch (Exception e) {
            log.error("Failed to retrieve secret from AWS Secrets Manager", e);
            throw new RuntimeException("Failed to retrieve secret", e);
        }

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(getSecretValueResponse.secretString(), Map.class);
        } catch (JsonProcessingException e) {
            log.error("Failed to parse secret string", e);
            throw new RuntimeException(e);
        }
    }
}
