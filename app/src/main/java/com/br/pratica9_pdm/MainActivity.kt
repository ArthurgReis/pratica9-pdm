package com.br.pratica9_pdm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val data = mutableListOf<Destino>()
        for (i in 1..50) {
            data.add(Destino("Item Título $i", "Descrição do item $i"))
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(data) { clickedItem ->
            android.widget.Toast.makeText(
                this,
                "Clicou em: ${clickedItem.title}",
                android.widget.Toast.LENGTH_SHORT
            ).show()
        }
        recyclerView.adapter = adapter

    }
}