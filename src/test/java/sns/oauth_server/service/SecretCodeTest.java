package sns.oauth_server.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SecretCodeTest {

    Logger log = LoggerFactory.getLogger(SecretCodeTest.class);

    @Autowired
    SecretCode secretCode;

    @Test
    void generateSecretCode() {

        String uuid = secretCode.generateSecretCode();
        log.info("줄인 UUID = {}", uuid);
    }
}