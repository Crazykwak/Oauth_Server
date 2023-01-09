package sns.oauth_server.mapper;

import org.springframework.stereotype.Component;
import sns.oauth_server.entity.OAuth2Server;
import sns.oauth_server.entity.dto.OAuth2ResponseDto;
import sns.oauth_server.entity.dto.OAuthRequestDto;

@Component
public class OAuth2ServerMapper {
    public OAuth2Server OAuthRequestDtoToOAuth2Server(OAuthRequestDto oAuthRequestDto, String secretCode) {

        return OAuth2Server.builder()
                .requestURI(oAuthRequestDto.getUrl())
                .secretCode(secretCode)
                .role(oAuthRequestDto.getRole())
                .build();
    }

    public OAuth2ResponseDto entityToResponseDto(OAuth2Server save) {

        return OAuth2ResponseDto.builder()
                .requestURI(save.getRequestURI())
                .secretCode(save.getSecretCode())
                .role(save.getRole())
                .build();
    }
}
