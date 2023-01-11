package sns.oauth_server.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import sns.oauth_server.entity.Role;


@Data
@NoArgsConstructor
public class OAuthRequestDto {

    private String url;
    private String email;
    private Role role;


}
