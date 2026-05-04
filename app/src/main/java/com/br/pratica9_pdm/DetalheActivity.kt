package com.br.pratica9_pdm

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetalheActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe)

        val d = intent.getSerializableExtra("obj") as Destino

        findViewById<TextView>(R.id.txtNomeDetalhe).text = d.nome
        findViewById<TextView>(R.id.txtDescLonga).text = d.descLonga
        findViewById<ImageView>(R.id.imgDetalhe).setImageResource(d.foto)

        val rv = findViewById<RecyclerView>(R.id.rvPontos)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = PontosAdapter(d.pontosTuristicos)
    }
}

class PontosAdapter(val lista: List<String>) : RecyclerView.Adapter<PontosAdapter.VH>() {
    class VH(v: View) : RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(p: ViewGroup, t: Int) = VH(
        LayoutInflater.from(p.context).inflate(android.R.layout.simple_list_item_1, p, false)
    )

    override fun getItemCount() = lista.size

    override fun onBindViewHolder(h: VH, p: Int) {
        val textView = h.itemView.findViewById<TextView>(android.R.id.text1)
        textView.text = "• ${lista[p]}"
        textView.textSize = 16f
        textView.setPadding(0, 8, 0, 8)
    }
}