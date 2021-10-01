package br.com.pokedex.detalhesPokemon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.pokedex.R
import br.com.pokedex.pagina_inicial.model.Pokemon
import com.google.gson.Gson

class DetalhesPokemonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_pokemon)

        //Receber o pokemon de outra tela
        val gson = Gson()
        val pokemon_item = gson.fromJson(intent.getStringExtra("pokemon_item"), Pokemon::class.java)




    }
}