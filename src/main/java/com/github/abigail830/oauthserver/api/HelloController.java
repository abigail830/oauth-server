package com.github.abigail830.oauthserver.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();

        if(auth != null)
            log.info(auth.toString());

        return "Hello World";
    }
}
