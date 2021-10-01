package br.com.pokedex.pagina_inicial.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.pokedex.R
import br.com.pokedex.pagina_inicial.adapter.PokemonAdapter
import br.com.pokedex.pagina_inicial.model.Pokemon
import br.com.pokedex.pagina_inicial.model.PokemonType
import com.facebook.shimmer.ShimmerFrameLayout
import java.util.*


class PaginaInicialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_inicial)

        //TODO 01 - Adicionar um menu na tela inicial
        //TODO 03 - Adicionar o retrofit para consumir a API

        val shimmer = findViewById<View>(R.id.shimmerFrameLayout) as ShimmerFrameLayout
        shimmer.visibility = View.GONE
        //shimmer.startShimmer()
        // shimmer.stopShimmer()


        //list fake
        val listPokemons = listaPokemonsMocados()


         val layoutManager = GridLayoutManager(baseContext, 2)
        val rvPokemons: RecyclerView = findViewById(R.id.rvPokemons)
        rvPokemons.layoutManager = layoutManager
        rvPokemons.adapter = PokemonAdapter(listPokemons)




    }

    private fun listaPokemonsMocados(): List<Pokemon> {
        return listOf(
            Pokemon(
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
                1,
                "Bulbasaur",
                listOf(
                    PokemonType("Grass"),
                    PokemonType("Poison")
                )
            ),

            Pokemon(
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
                4,
                "Charmander ",
                listOf(
                    PokemonType("Fire"),
                )
            ),

            Pokemon(
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png",
                4,
                "Squirtle",
                listOf(
                    PokemonType("Water"),
                )
            ),

            Pokemon(
                "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png",
                25,
                "Pikachu",
                listOf(
                    PokemonType("Electric"),
                    PokemonType("Poison")
                )
            )
        )
    }
}