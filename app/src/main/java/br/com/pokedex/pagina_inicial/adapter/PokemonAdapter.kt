package br.com.pokedex.pagina_inicial.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.pokedex.R
import br.com.pokedex.detalhesPokemon.DetalhesPokemonActivity
import br.com.pokedex.pagina_inicial.model.Pokemon
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class PokemonAdapter(
        private val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        @SuppressLint("SetTextI18n")
        fun bindView(item: Pokemon){
            with(itemView){
                val img_pokemon : ImageView = findViewById(R.id.img_pokemon)
                val id_pokemon : TextView = findViewById(R.id.id_pokemon)
                val nome_pokemon : TextView = findViewById(R.id.nome_pokemon)
                val tipo_pokemon_1: TextView = findViewById(R.id.tipo_pokemon_1)
                val tipo_pokemon_2: TextView = findViewById(R.id.tipo_pokemon_2)


                Picasso.get().load(item.imageURL).into(img_pokemon)
                id_pokemon.text = "Nº ${item.numeroFormatado}"
                nome_pokemon.text = item.name
                tipo_pokemon_1.text = item.types[0].name
                if(item.types.size >1){
                    tipo_pokemon_2.visibility = View.VISIBLE
                    tipo_pokemon_2.text = item.types[1].name
                }else{
                    tipo_pokemon_2.visibility = View.GONE
                }

                itemView.setOnClickListener {
                    val gson = Gson()
                    val intent = Intent(context, DetalhesPokemonActivity::class.java)
                    intent.putExtra("pokemon_item", gson.toJson(item))
                    context.startActivity(intent)
                }

            }
        }


    }


}