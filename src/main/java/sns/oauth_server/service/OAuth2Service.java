package sns.oauth_server.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sns.oauth_server.entity.OAuth2Server;
import sns.oauth_server.entity.dto.OAuthRequestDto;
import sns.oauth_server.mapper.OAuth2ServerMapper;
import sns.oauth_server.repository.OAuth2ServerRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class OAuth2Service {

    private final OAuth2ServerRepository oAuth2ServerRepository;
    private final OAuth2ServerMapper mapper;
    private final SecretCode secretCode;

    public OAuth2Server save(OAuthRequestDto oAuthRequestDto) {

        String generateSecretCode = secretCode.generateSecretCode();
        OAuth2Server oAuth2Server = mapper.OAuthRequestDtoToOAuth2Server(oAuthRequestDto, generateSecretCode);
        oAuth2ServerRepository.save(oAuth2Server);

        return oAuth2Server;
    }
}
