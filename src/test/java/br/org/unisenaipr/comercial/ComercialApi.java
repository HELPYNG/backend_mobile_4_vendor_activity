package br.org.unisenaipr.comercial;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComercialApi {
    public static void main(String[] args) {
        SpringApplication.run(ComercialApi.class, args);
    }
}
