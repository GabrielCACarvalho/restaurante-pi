package com.unaerp.restaurantepi.service;

import com.unaerp.restaurantepi.dto.ItemDTO;
import com.unaerp.restaurantepi.model.Item;
import com.unaerp.restaurantepi.model.Pedido;
import com.unaerp.restaurantepi.model.Produto;
import com.unaerp.restaurantepi.repository.ItemRepository;
import com.unaerp.restaurantepi.repository.PedidoRepository;
import com.unaerp.restaurantepi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Item> adicionarItens(Integer idPedido, List<ItemDTO> itensDTO) {
        Optional<Pedido> pedido = pedidoRepository.findById(idPedido);

        if (pedido.isEmpty()) {
            return Collections.emptyList();
        }

        return itemRepository.saveAll(itensDTO.stream().map(itemDTO -> {
            Optional<Produto> produto = produtoRepository.findById(itemDTO.getIdProduto());

            if (produto.isEmpty())
                return null;

            return new Item(pedido.get(), produto.get(), itemDTO.getQuantidade());
        }).collect(Collectors.toList()));
    }

    public void removeItem(List<Integer> idsItem) {
        itemRepository.deleteAllById(idsItem);
    }
}
