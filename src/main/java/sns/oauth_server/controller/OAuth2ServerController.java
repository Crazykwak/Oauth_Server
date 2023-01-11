package sns.oauth_server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sns.oauth_server.entity.OAuth2Server;
import sns.oauth_server.entity.Role;
import sns.oauth_server.entity.dto.OAuth2ResponseDto;
import sns.oauth_server.entity.dto.OAuthRequestDto;
import sns.oauth_server.mapper.OAuth2ServerMapper;
import sns.oauth_server.service.OAuth2Service;

@Controller
@RequiredArgsConstructor
@Slf4j
public class OAuth2ServerController {

    private final OAuth2Service oAuth2Service;
    private final OAuth2ServerMapper mapper;

    @GetMapping("/request_api_url")
    public String viewRequestApiUrl(Model model) {
        model.addAttribute(new OAuthRequestDto());
        model.addAttribute("roles", Role.values());
        return "oauth";
    }

    @PostMapping("/request_api_url")
    public String giveOAuth2LoginUrl(Model model, OAuthRequestDto oAuthRequestDto) {

        OAuth2Server save = oAuth2Service.save(oAuthRequestDto);
        OAuth2ResponseDto responseDto = mapper.entityToResponseDto(save);
        model.addAttribute(responseDto);

        return "redirect:oauthURL";
    }


}
