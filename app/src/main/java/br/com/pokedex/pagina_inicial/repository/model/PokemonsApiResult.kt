package br.com.pokedex.pagina_inicial.repository.model

import br.com.pokedex.pagina_inicial.model.PokemonType

//O objeto que a API vai retornar
data class PokemonsApiResult(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)

data class PokemonApiResult(
    val id: Int,
    val name: String,
    val types: PokemonTypesSlot
)

data class PokemonTypesSlot(
    val slot: Int,
    val type: PokemonType,
)
