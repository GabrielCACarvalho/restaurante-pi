package com.unaerp.restaurantepi.service;

import com.unaerp.restaurantepi.dto.PedidoDTO;
import com.unaerp.restaurantepi.model.Pedido;
import com.unaerp.restaurantepi.repository.ItemRepository;
import com.unaerp.restaurantepi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRespository;

    @Autowired
    private ItemRepository itemRepository;

    public Pedido gerarPedido(Pedido pedido) {
        return pedidoRespository.save(pedido);
    }

    public PedidoDTO listarPedido(Integer idPedido) {
        Optional<Pedido> pedidoOptional = pedidoRespository.findById(idPedido);

        PedidoDTO pedidoDTO = new PedidoDTO();

        if (pedidoOptional.isPresent()) {
            pedidoDTO.setCodigo(pedidoOptional.get().getCodigo());
            pedidoDTO.setMesaComanda(pedidoOptional.get().getMesaComanda());
            pedidoDTO.setData(pedidoOptional.get().getData());
            pedidoDTO.setTotal(pedidoOptional.get().getTotal());
            pedidoDTO.setItens(itemRepository.findByPedido(pedidoOptional.get()));
        }

        return pedidoDTO;
    }
}
