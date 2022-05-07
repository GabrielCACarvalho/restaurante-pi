package com.unaerp.restaurantepi.controller;

import com.unaerp.restaurantepi.dto.ItemDTO;
import com.unaerp.restaurantepi.model.Item;
import com.unaerp.restaurantepi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/carrinho/{idPedido}")
    public List<Item> adicionarItens(
            @PathVariable Integer idPedido,
            @RequestBody List<ItemDTO> itensDTO) {

        return itemService.adicionarItens(idPedido, itensDTO);
    }
}
