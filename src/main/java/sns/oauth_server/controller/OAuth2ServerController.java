package sns.oauth_server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;
import sns.oauth_server.entity.OAuth2Server;
import sns.oauth_server.entity.Role;
import sns.oauth_server.entity.dto.OAuth2ResponseDto;
import sns.oauth_server.entity.dto.OAuthRequestDto;
import sns.oauth_server.mapper.OAuth2ServerMapper;
import sns.oauth_server.service.OAuth2Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    public String giveOAuth2LoginUrl(@ModelAttribute OAuthRequestDto oAuthRequestDto, RedirectAttributes redirectAttributes) {

        OAuth2Server save = oAuth2Service.save(oAuthRequestDto);
        OAuth2ResponseDto responseDto = mapper.entityToResponseDto(save);
        redirectAttributes.addFlashAttribute("responseDto", responseDto);
        log.info("아님 여기?");

        return "redirect:/oauthURL";
    }

    @GetMapping("/oauthURL")
    public String giveResult(Model model, HttpServletRequest request) {

        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            OAuth2ResponseDto responseDto = (OAuth2ResponseDto) inputFlashMap.get("responseDto");
            model.addAttribute(responseDto);
        }
        return "oauthURL";
    }
}
