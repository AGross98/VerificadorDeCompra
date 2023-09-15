package com.example.orgs2.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs2.R
import com.example.orgs2.databinding.ProdutoItemBinding
import com.example.orgs2.model.Produto
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {
    private val produtos = produtos.toMutableList()
    class ViewHolder(private val binding: ProdutoItemBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun vincula(produto: Produto) {
            val nome = binding.none
            nome.text = produto.nome
            val descricao = binding.descricao
            descricao.text = produto.descricao
            val valor = binding.valor
            val valorEmMoeda: String = formataParaReal(produto.valor)
            valor.text = valorEmMoeda
        }

        private fun formataParaReal(valor: BigDecimal): String {
            val formatador: NumberFormat = NumberFormat
                .getCurrencyInstance(Locale("pt", "br"))
            return formatador.format(valor)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val infaldor = LayoutInflater.from(context)
        val binding = ProdutoItemBinding.inflate(infaldor, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size
    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

}
