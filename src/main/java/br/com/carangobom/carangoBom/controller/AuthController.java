package br.com.carangobom.carangoBom.controller;

import br.com.carangobom.carangoBom.config.security.TokenService;
import br.com.carangobom.carangoBom.dto.TokenDto;
import br.com.carangobom.carangoBom.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Profile("prod")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> authenticate(@RequestBody @Valid LoginForm form) {
        UsernamePasswordAuthenticationToken data = form.converter();
        try {
            Authentication authentication = authManager.authenticate(data);
            String token = tokenService.tokenGenerate(authentication);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        }catch(AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
