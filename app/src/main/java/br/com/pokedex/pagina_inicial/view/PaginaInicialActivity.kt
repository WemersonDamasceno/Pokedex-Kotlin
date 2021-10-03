package br.com.pokedex.pagina_inicial.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.pokedex.R
import br.com.pokedex.pagina_inicial.adapter.PokemonAdapter
import br.com.pokedex.pagina_inicial.model.Pokemon
import br.com.pokedex.pagina_inicial.viewmodel.PokemonViewModel
import br.com.pokedex.pagina_inicial.viewmodel.PokemonViewModelFactory
import com.facebook.shimmer.ShimmerFrameLayout


class PaginaInicialActivity : AppCompatActivity() {
    private val viewModelPokemon by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvPokemons)
    }

    private val shimmer by lazy {
        findViewById<View>(R.id.shimmerFrameLayout) as ShimmerFrameLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_inicial)


        shimmer.startShimmer()

        viewModelPokemon.pokemons.observe(this, {
            loadRecyclerView(it)
        })

    }
    @Suppress("UNCHECKED_CAST")
    private fun loadRecyclerView(pokemons: List<Pokemon?>) {
        recyclerView.layoutManager = GridLayoutManager(baseContext, 2)
        recyclerView.adapter = PokemonAdapter(pokemons as List<Pokemon>)
        shimmer.visibility = View.GONE
        shimmer.stopShimmer()
    }
}