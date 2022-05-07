package com.unaerp.restaurantepi.repository;

import com.unaerp.restaurantepi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
