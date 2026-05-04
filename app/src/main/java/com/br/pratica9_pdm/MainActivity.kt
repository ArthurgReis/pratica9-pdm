package com.br.pratica9_pdm

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lista = listOf(
            Destino("Caribe", R.drawable.caribe, "Paraíso tropical", "Região formada por diversas ilhas e praias paradisíacas no Mar do Caribe.", listOf("Punta Cana", "Cancún", "Aruba")),
            Destino("Chile", R.drawable.chile, "Natureza extrema", "País sul-americano conhecido pela Cordilheira dos Andes e pelo Deserto do Atacama.", listOf("Deserto do Atacama", "Valle Nevado", "Santiago")),
            Destino("China", R.drawable.chine, "Gigante asiático", "País de cultura milenar, vasta extensão territorial e grande potência global.", listOf("Muralha da China", "Cidade Proibida", "Exército de Terracota")),
            Destino("França", R.drawable.france, "Centro cultural europeu", "Nação europeia famosa por sua gastronomia, moda, arte e história.", listOf("Torre Eiffel", "Museu do Louvre", "Palácio de Versalhes")),
            Destino("Japão", R.drawable.japan, "Tradição e tecnologia", "Arquipélago asiático que mescla cultura ancestral com alta modernidade.", listOf("Monte Fuji", "Tóquio", "Templos de Kyoto")),
            Destino("Rio de Janeiro", R.drawable.rio, "Cidade Maravilhosa", "Metrópole brasileira mundialmente famosa por suas praias e o carnaval.", listOf("Cristo Redentor", "Pão de Açúcar", "Copacabana")),
            Destino("Singapura", R.drawable.singapure, "Cidade-estado moderna", "Polo financeiro global localizado no sudeste asiático com arquitetura futurista.", listOf("Marina Bay Sands", "Gardens by the Bay", "Ilha de Sentosa")),
            Destino("Suíça", R.drawable.switzerland, "Alpes e lagos", "País montanhoso da Europa Central famoso por suas paisagens e neutralidade.", listOf("Alpes Suíços", "Lago Genebra", "Zurique")),
            Destino("Veneza", R.drawable.veneza, "Cidade dos canais", "Cidade italiana histórica construída sobre um arquipélago no Mar Adriático.", listOf("Praça São Marcos", "Ponte Rialto", "Grande Canal")),
            Destino("Vietnã", R.drawable.vietnam, "História e natureza", "País do sudeste asiático caracterizado por rios, praias e cidades movimentadas.", listOf("Baía de Ha Long", "Hanói", "Hoi An"))
        )

        val rv = findViewById<RecyclerView>(R.id.rvDestinos)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = DestinoAdapter(lista) { destino ->
            val intent = Intent(this, DetalheActivity::class.java)
            intent.putExtra("obj", destino)
            startActivity(intent)
        }
    }
}

class DestinoAdapter(val dados: List<Destino>, val click: (Destino) -> Unit) : RecyclerView.Adapter<DestinoAdapter.VH>() {
    class VH(v: View) : RecyclerView.ViewHolder(v)
    override fun onCreateViewHolder(p: ViewGroup, t: Int) = VH(LayoutInflater.from(p.context).inflate(R.layout.item_destino, p, false))
    override fun getItemCount() = dados.size
    override fun onBindViewHolder(h: VH, p: Int) {
        val d = dados[p]
        h.itemView.findViewById<TextView>(R.id.txtNome).text = d.nome
        h.itemView.findViewById<TextView>(R.id.txtDescCurta).text = d.descCurta
        h.itemView.findViewById<ImageView>(R.id.imgFoto).setImageResource(d.foto)
        h.itemView.setOnClickListener { click(d) }
    }
}