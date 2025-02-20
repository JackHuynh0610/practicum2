package security;

import org.springframework.stereotype.Component;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

@Component
public class KeyGeneratorUtils {
    private KeyGeneratorUtils() {}

    public static KeyPair generateRsaKey() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (Exception ex) {
            throw new IllegalStateException("Failed to generate RSA key", ex);
        }
    }
}
