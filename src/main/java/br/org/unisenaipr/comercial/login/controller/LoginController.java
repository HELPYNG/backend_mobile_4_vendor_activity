package br.org.unisenaipr.comercial.login.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.org.unisenaipr.comercial.login.entity.Login;
import br.org.unisenaipr.comercial.login.service.LoginService;

@RestController
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public ResponseEntity<List<Login>> getAllLogins() {
        List<Login> logins = loginService.findAll();
        return new ResponseEntity<>(logins, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Login> authenticate(@RequestBody Login login) {
        Login authenticatedLogin = loginService.findByEmailAndSenha(login.getEmailUser(), login.getSenhaUser());
        if (authenticatedLogin != null) {
            return new ResponseEntity<>(authenticatedLogin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}