package br.com.pokedex.pagina_inicial.repository

import br.com.pokedex.pagina_inicial.repository.model.PokemonApiResult
import br.com.pokedex.pagina_inicial.repository.model.PokemonsApiResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {
    private val service: PokemonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonService::class.java)
    }

    fun listPokemons(limit: Int = 100): PokemonsApiResult? {
        val call = service.listPokemons(limit)
        return call.execute().body()

    }

    fun getPokemon(number: Int): PokemonApiResult? {
        val call = service.getPokemon(number)
        return call.execute().body()
    }


}