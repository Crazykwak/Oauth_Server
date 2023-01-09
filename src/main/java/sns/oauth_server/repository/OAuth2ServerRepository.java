package sns.oauth_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sns.oauth_server.entity.OAuth2Server;

public interface OAuth2ServerRepository extends JpaRepository<OAuth2Server, Long> {
}
