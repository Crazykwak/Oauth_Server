package sns.oauth_server.entity.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sns.oauth_server.entity.Role;

@Data
@NoArgsConstructor
public class OAuth2ResponseDto {

    private String requestURI;
    private String secretCode;
    private Role role;

    @Builder
    public OAuth2ResponseDto(String requestURI, String secretCode, Role role) {
        this.requestURI = requestURI;
        this.secretCode = secretCode;
        this.role = role;
    }
}
