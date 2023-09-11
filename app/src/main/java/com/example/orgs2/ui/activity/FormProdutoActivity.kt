package com.example.orgs2.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.orgs2.R
import com.example.orgs2.dao.ProdutosDao
import com.example.orgs2.model.Produto
import java.math.BigDecimal

class FormProdutoActivity : AppCompatActivity(R.layout.activity_form_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configuraBotãoSalvar()


    }

    private fun configuraBotãoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.salvarF)
        val dao = ProdutosDao()
        botaoSalvar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val novoProduto = criaProduto()
                dao.adiciona(novoProduto)
                finish()
            }
        })
    }

    private fun criaProduto(): Produto {
        val campoNome = findViewById<TextView>(R.id.nomeF)
        val nome = campoNome.text.toString()
        val campoDesc = findViewById<TextView>(R.id.descricaoF)
        val descricao = campoDesc.text.toString()
        val campoValor = findViewById<TextView>(R.id.valorF)
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