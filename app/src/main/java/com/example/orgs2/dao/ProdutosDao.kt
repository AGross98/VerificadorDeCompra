package com.example.orgs2.dao

import com.example.orgs2.model.Produto

class ProdutosDao {

    fun adiciona (produto: Produto){
        produtos.add(produto)
    }
    fun buscaTodos() :List<Produto>{
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}