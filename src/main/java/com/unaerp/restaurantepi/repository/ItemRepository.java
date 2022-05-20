package com.unaerp.restaurantepi.repository;

import com.unaerp.restaurantepi.model.Item;
import com.unaerp.restaurantepi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByPedido(Pedido pedido);

    void deleteAllByPedidoCodigo(Integer codigo);
}
