package com.unaerp.restaurantepi.repository;

import com.unaerp.restaurantepi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}