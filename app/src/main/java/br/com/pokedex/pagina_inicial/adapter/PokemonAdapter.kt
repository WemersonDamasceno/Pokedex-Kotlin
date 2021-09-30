package br.com.pokedex.pagina_inicial.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.pokedex.R
import br.com.pokedex.pagina_inicial.model.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_item.view.*

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
                Picasso.get().load(item.imageURL).into(itemView.img_pokemon)
                id_pokemon.text = "Nº ${item.numeroFormatado}"
                nome_pokemon.text = item.name
                tipo_pokemon_1.text = item.types[0].name
                if(item.types.size >1){
                    tipo_pokemon_2.visibility = View.VISIBLE
                    tipo_pokemon_2.text = item.types[1].name
                }else{
                    tipo_pokemon_2.visibility = View.GONE
                }

            }
        }
    }


}