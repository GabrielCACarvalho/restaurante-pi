package com.unaerp.restaurantepi.controller;

import com.unaerp.restaurantepi.dto.PedidoDTO;
import com.unaerp.restaurantepi.model.Pedido;
import com.unaerp.restaurantepi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/pedido/salvar")
    public ResponseEntity<Pedido> gerarPedido(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.gerarPedido(pedido));
    }

    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<PedidoDTO> listarPedido(@PathVariable Integer idPedido) {
        return ResponseEntity.ok(pedidoService.listarPedido(idPedido));
    }

    @DeleteMapping("/pedido/{idPedido}")
    public ResponseEntity deletaPedido(@PathVariable Integer idPedido) {
        pedidoService.deletarPedido(idPedido);
        return ResponseEntity.ok().build();
    }
}
