package com.example.orgs2.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.orgs2.R
import com.example.orgs2.dao.ProdutosDao
import com.example.orgs2.databinding.ActivityFormProdutoBinding
import com.example.orgs2.model.Produto
import java.math.BigDecimal

class FormProdutoActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityFormProdutoBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraBotãoSalvar()
    }

    private fun configuraBotãoSalvar() {
        val botaoSalvar = binding.salvarF
        val dao = ProdutosDao()
        botaoSalvar.setOnClickListener {
                val novoProduto = criaProduto()
                dao.adiciona(novoProduto)
                finish()
            }
        }
    private fun criaProduto(): Produto {
        val campoNome = binding.nomeF
        val nome = campoNome.text.toString()
        val campoDesc = binding.descricaoF
        val descricao = campoDesc.text.toString()
        val campoValor = binding.valorF
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }
}