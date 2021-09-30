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
                1,
                "Bulbasaur",
                listOf(
                    PokemonType("Grass"),
                    PokemonType("Poison")
                )
        )

        val charmander = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            4,
            "Charmander ",
            listOf(
                PokemonType("Fire"),
            )
        )

        val Squirtle  = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
            4,
            "Squirtle",
            listOf(
                PokemonType("Water"),
            )
        )

        val Pikachu = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png",
            25,
            "Pikachu",
            listOf(
                PokemonType("Electric"),
                PokemonType("Poison")
            )
        )

        val listPokemons = listOf(bulbasaur,charmander,Squirtle,Pikachu)


        val layoutManager = LinearLayoutManager(this)
        rvPokemons.layoutManager = layoutManager
        rvPokemons.adapter = PokemonAdapter(listPokemons)

    }
}