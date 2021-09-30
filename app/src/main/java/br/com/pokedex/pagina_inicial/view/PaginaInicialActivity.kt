package br.com.pokedex.pagina_inicial.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.pokedex.R
import br.com.pokedex.pagina_inicial.adapter.PokemonAdapter
import br.com.pokedex.pagina_inicial.model.Pokemon
import br.com.pokedex.pagina_inicial.model.PokemonType
import kotlinx.android.synthetic.main.activity_pagina_inicial.*

class PaginaInicialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_inicial)

        val bulbasaur = Pokemon(
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
                4,
                "Bulbasaur",
                listOf(
                    PokemonType("Grass"),
                    PokemonType("Poison")
                )
        )

        val listPokemons = listOf(bulbasaur,bulbasaur,bulbasaur,bulbasaur)


        val layoutManager = LinearLayoutManager(this)
        rvPokemons.layoutManager = layoutManager
        rvPokemons.adapter = PokemonAdapter(listPokemons)

    }
}