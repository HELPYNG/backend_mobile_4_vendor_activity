package br.org.unisenaipr.comercial.login.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.unisenaipr.comercial.login.entity.Login;

@Repository("loginRepositorio")
public interface LoginRepositorio extends JpaRepository<Login, Long>{

    Login findByEmailUserAndSenhaUser(String emailUser, String senhaUser);
}