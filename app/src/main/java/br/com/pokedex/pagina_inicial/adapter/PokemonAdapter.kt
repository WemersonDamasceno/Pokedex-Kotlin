package br.com.pokedex.pagina_inicial.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
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
                val item_favoritar: ImageView = findViewById(R.id.item_favoritar)


                Picasso.get().load(item.imageUrl).into(img_pokemon)
                id_pokemon.text = "Nº ${item.formattedNumber}"
                nome_pokemon.text = item.name
                tipo_pokemon_1.text = item.types[0].name.toUpperCase()

                when(tipo_pokemon_1.text.toString()){
                    "grass" -> tipo_pokemon_1.setBackgroundColor(ContextCompat.getColor(context, R.color.amarelo))
                    "poison" -> tipo_pokemon_1.setBackgroundColor(Color.parseColor("#b97fc9"))
                    "fire" -> tipo_pokemon_1.setBackgroundColor(Color.parseColor("#fd7d24"))
                    "psychic" -> tipo_pokemon_1.setBackgroundColor(Color.parseColor("#f366b9"))
                    "bug" -> tipo_pokemon_1.setBackgroundColor(Color.parseColor("#729f3f"))
                    "dark" -> tipo_pokemon_1.setBackgroundColor(Color.parseColor("#707070"))
                    "flying" -> tipo_pokemon_1.setBackgroundColor(Color.parseColor("#3dc7ef"))
                    "eletric" -> tipo_pokemon_1.setBackgroundColor(Color.parseColor("##eed535"))
                }

                if(item.types.size >1){
                    tipo_pokemon_2.visibility = View.VISIBLE
                    tipo_pokemon_2.text = item.types[1].name.toUpperCase()
                }else{
                    tipo_pokemon_2.visibility = View.GONE
                }

                itemView.setOnClickListener {
                    val gson = Gson()
                    val intent = Intent(context, DetalhesPokemonActivity::class.java)
                    intent.putExtra("pokemon_item", gson.toJson(item))
                    context.startActivity(intent)
                }

                item_favoritar.setOnClickListener{
                    Toast.makeText(context,"O ${item.name} foi favoritado!",Toast.LENGTH_LONG).show()
                    item_favoritar.setImageResource(R.drawable.ic_poke_marcado)
                }


            }
        }


    }


}