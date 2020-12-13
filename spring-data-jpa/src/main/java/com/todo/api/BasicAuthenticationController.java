package com.todo.api;


import com.todo.dto.AuthenticationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BasicAuthenticationController {

    @GetMapping("/basicauth")
    public AuthenticationDto basicAuth() {
        log.debug("basicAuth çalıştı");
        return new AuthenticationDto("Login oldunuz.");
    }

}
