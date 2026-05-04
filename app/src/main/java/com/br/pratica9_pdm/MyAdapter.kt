package com.br.pratica9_pdm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val itemList: List<Destino>, private val onItemClicked: (Destino) -> Unit) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFoto: ImageView = itemView.findViewById(R.id.imgFoto)
        val txtNome: TextView = itemView.findViewById(R.id.txtNome)
        val txtDescCurta: TextView = itemView.findViewById(R.id.txtDescCurta)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_destino, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.txtNome.text = currentItem.nome
        holder.txtDescCurta.text = currentItem.descCurta
        holder.imgFoto.setImageResource(currentItem.foto)

        holder.itemView.setOnClickListener {
            onItemClicked(currentItem)
        }
    }

    override fun getItemCount(): Int = itemList.size
}