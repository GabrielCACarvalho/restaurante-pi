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

import java.util.List;
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
        Pedido pedido = pedidoRepository.findById(idPedido).get();

        return itemRepository.saveAll(itensDTO.stream().map(itemDTO -> {
            Produto produto = produtoRepository.findById(itemDTO.getIdProduto()).get();
            return new Item(pedido, produto, itemDTO.getQuantidade());
        }).collect(Collectors.toList()));
    }
}
