package br.org.unisenaipr.comercial.produto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.unisenaipr.comercial.produto.entity.Produto;

@Repository("produtoRepository")
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
