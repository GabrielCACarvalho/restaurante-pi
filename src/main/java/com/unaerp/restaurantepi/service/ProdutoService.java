package com.unaerp.restaurantepi.service;

import com.unaerp.restaurantepi.model.Produto;
import com.unaerp.restaurantepi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProduto() {
        return produtoRepository.findAll();
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deleteProduto(Integer idProduto) {
        produtoRepository.deleteById(idProduto);
    }
}
