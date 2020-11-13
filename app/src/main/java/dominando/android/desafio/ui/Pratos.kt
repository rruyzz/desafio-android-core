package dominando.android.desafio.ui

import android.widget.ImageView

data class Pratos(val nome: String, val image: Int) {
    override fun toString(): String {
        return "Pratos(nome='$nome', image=$image)"
    }
}