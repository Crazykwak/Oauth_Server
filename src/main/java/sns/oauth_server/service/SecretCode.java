package sns.oauth_server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class SecretCode {

    public String generateSecretCode() {
        UUID uuid = UUID.randomUUID();
        log.info("생성된 uuid = {}", uuid.toString());
        return uuidLengthChangeToShoter(uuid.toString());
    }

    private String uuidLengthChangeToShoter(String uuid) {
        long tmp = ByteBuffer.wrap(uuid.getBytes()).getLong();
        return Long.toString(tmp, 32);
    }


}
