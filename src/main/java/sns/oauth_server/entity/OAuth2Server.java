package sns.oauth_server.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class OAuth2Server {
    @Id @GeneratedValue()
    private Long id;
    private String requestURI;
    private String secretCode;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public OAuth2Server(String requestURI, String secretCode, Role role) {
        this.requestURI = requestURI;
        this.secretCode = secretCode;
        this.role = role;
    }
}
