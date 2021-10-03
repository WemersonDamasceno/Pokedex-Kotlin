package br.com.pokedex.pagina_inicial.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.pokedex.pagina_inicial.model.Pokemon
import br.com.pokedex.pagina_inicial.repository.PokemonRepository

class PokemonViewModel: ViewModel() {
    var pokemons = MutableLiveData<List<Pokemon?>>()


    init {
        Thread {
            loadPokemons()
        }.start()
    }

    private fun loadPokemons() {
        val pokemonsApiResult = PokemonRepository.listPokemons()

        pokemonsApiResult?.results?.let {
            pokemons.postValue(it.map { pokemonResult ->
                val number = pokemonResult.url
                        .replace("https://pokeapi.co/api/v2/pokemon/", "")
                        .replace("/", "").toInt()

                val pokemonApiResult = PokemonRepository.getPokemon(number)

                pokemonApiResult?.let {
                    Pokemon(
                            pokemonApiResult.id,
                            pokemonApiResult.name,
                            pokemonApiResult.types.map { type ->
                                type.type
                            }
                    )
                }
            })
        }
    }
}