package br.com.pokedex.pagina_inicial.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon (
        val imageURL: String,
        val id: Int,
        val name: String,
        val types: List<PokemonType>
        ) : Parcelable{
    val numeroFormatado = id.toString().padStart(3,'0')
}

@Parcelize
data class PokemonType (
    val name: String,
    val colorBackground: String? = null,
    val colorText: String? = null,
    ) : Parcelable

