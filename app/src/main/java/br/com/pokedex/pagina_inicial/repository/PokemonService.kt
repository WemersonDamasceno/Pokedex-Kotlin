package br.com.pokedex.pagina_inicial.repository

import br.com.pokedex.pagina_inicial.repository.model.PokemonApiResult
import br.com.pokedex.pagina_inicial.repository.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface PokemonService {
    @GET("/pokemon")
    fun listPokemons(@Query("limit") limit: Int): Call<PokemonsApiResult>

    @GET("/pokemon/{id}")
    fun getPokemon(id: Int): Call<PokemonApiResult>



}