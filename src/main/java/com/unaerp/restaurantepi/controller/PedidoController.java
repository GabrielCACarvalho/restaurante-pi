package com.unaerp.restaurantepi.controller;

import com.unaerp.restaurantepi.model.Pedido;
import com.unaerp.restaurantepi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/gerar/pedido")
    public ResponseEntity<Pedido> gerarPedido(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.gerarPedido(pedido));
    }
}
