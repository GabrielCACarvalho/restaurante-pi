package com.unaerp.restaurantepi.repository;

import com.unaerp.restaurantepi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
