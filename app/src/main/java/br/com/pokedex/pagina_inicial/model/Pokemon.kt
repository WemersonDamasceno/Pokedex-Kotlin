package br.com.pokedex.pagina_inicial.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
        val number: Int,
        val name: String,
        val types: List<PokemonType>
) : Parcelable {

    val formattedNumber = number.toString().padStart(3, '0')

    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"
}

@Parcelize
data class PokemonType (
    val name: String,
    val colorBackground: String? = null,
    val colorText: String? = null,
    ) : Parcelable

