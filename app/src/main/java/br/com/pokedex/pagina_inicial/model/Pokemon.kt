package br.com.pokedex.pagina_inicial.model

data class Pokemon (
        val imageURL: String,
        val id: Int,
        val name: String,
        val types: List<PokemonType>
        ) {
    val numeroFormatado = id.toString().padStart(3,'0')
}

data class PokemonType (
    val name: String,
    )

