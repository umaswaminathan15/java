package com.example.TNTRANSPORT.controller;


import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class DemoController {

    @GetMapping("api/public")
    public  String home(){
        return "this is public service";
    }

    @GetMapping("/private")
    public String privateapi(OAuth2AuthenticationToken token){
        return "Welcome" + token.getPrincipal().getAttribute("email");
    }
}
