package br.org.unisenaipr.comercial.login.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.org.unisenaipr.comercial.login.entity.Login;
import br.org.unisenaipr.comercial.login.repositorio.LoginRepositorio;

@Service
public class LoginService {

    private LoginRepositorio loginRepository;

    public LoginService(LoginRepositorio loginRepository) {
        this.loginRepository = loginRepository;
    }

    public List<Login> findAll() {
        return loginRepository.findAll();
    }

    public Login findByEmailAndSenha(String email, String senha) {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            return null; // or throw an exception, depending on your requirements
        }
        return loginRepository.findByEmailUserAndSenhaUser(email, senha);
    }

    public void save(Login login) {
        loginRepository.save(login);
    }
}