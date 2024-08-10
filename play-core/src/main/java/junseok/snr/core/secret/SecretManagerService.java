package junseok.snr.core.secret;

import java.util.Map;

public interface SecretManagerService {
    Map<String, String> getSecret(String secretName);
}
